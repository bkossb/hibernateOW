package com.bartek.servlet;

import com.bartek.domain.App;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.hibernate.Session;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import com.bartek.util.StartupDataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//Servlet implementujacy kontroler obsługujacy przeszukiwanie i renderowanie wyników

@SuppressWarnings("serial")
@WebServlet("search")
public class SearchServlet extends HttpServlet {

    // główna funkcjonalnosc wyszukiwania wywoływana przy kazdym zapytaniu HTTP POST


    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Logger logger = LoggerFactory.getLogger(SearchServlet.class);
        String searchString = request.getParameter("searchString");
        String sortField = request.getParameter("sortField") != null ? request.getParameter("sortField").trim() : "relevance";
        int firstResult = request.getParameter("firstResult") != null ? Integer.parseInt(request.getParameter("firstResult")) : 0;
        logger.info("Wyszukaj po [" + searchString + "], sortowanie [" + sortField + "], zacznik od wyniku [" + firstResult + "]");


        Session session = StartupDataLoader.openSession();

        FullTextSession fullTextSession = Search.getFullTextSession(session);

        fullTextSession.beginTransaction();


        // obiekt hibernate search dla indeksu lucene
        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(App.class).get();

        Query luceneQuery = null;
        if (searchString.length() > 2 && searchString.startsWith("\"") && searchString.endsWith("\"")) {

            String unquotedSearchString = searchString.substring(1, searchString.length() - 1);
            luceneQuery = queryBuilder
                    .phrase()
                    .onField("name").andField("description").andField("supportedDevices.name").andField("customerReviews.comments")
                    .sentence(unquotedSearchString)
                    .createQuery();
        } else {

            luceneQuery = queryBuilder
                    .keyword()
                    .fuzzy()
                    .withThreshold(0.7f)
                    .onFields("name", "description", "supportedDevices.name", "customerReviews.comments")
                    .matching(searchString)
                    .createQuery();
        }
        FullTextQuery hibernateQuery = fullTextSession.createFullTextQuery(luceneQuery, App.class);


        if (sortField.equals("name")) {
            Sort sort = new Sort(new SortField("sorting_name", SortField.STRING));
            hibernateQuery.setSort(sort);
        } else if (sortField.equals("names-reverse")) {
            Sort sort = new Sort(new SortField("sorting_name", SortField.STRING, true));
            hibernateQuery.setSort(sort);
        }

        int resultSize = hibernateQuery.getResultSize();

        logger.info("Zapytanie == " + hibernateQuery.getQueryString());
        hibernateQuery.setFirstResult(firstResult);
        hibernateQuery.setMaxResults(5);

        List<App> apps = hibernateQuery.list();

        fullTextSession.clear();

        request.setAttribute("searchString", searchString);
        request.setAttribute("sortField", sortField);
        request.setAttribute("apps", apps);
        request.setAttribute("resultSize", resultSize);
        request.setAttribute("firstResult", firstResult);

        fullTextSession.getTransaction().commit();
        session.close();

        getServletContext().getRequestDispatcher("/WEB-INF/pages/search.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        this.doPost(request, response);
    }
}
