package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("    <meta name=\"keywords\" content=\"\"/>\n");
      out.write("    <meta name=\"description\" content=\"\"/>\n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\"/>\n");
      out.write("\n");
      out.write("    <title>Bazar aplikacji</title>\n");
      out.write("\n");
      out.write("    <link type=\"text/css\" href=\"css/custom-theme/jquery-ui-1.8.24.custom.css\" rel=\"stylesheet\"/>\n");
      out.write("    <link href=\"http://fonts.googleapis.com/css?family=Arvo\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/style.css\"/>\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-1.8.2.min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-ui-1.8.24.custom.min.js\"></script>\n");
      out.write("    <script language=\"JavaScript\">\n");
      out.write("        window.onload = function () {\n");
      out.write("            document.forms[0].elements[\"searchString\"].focus();\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function submitSearchForm() {\n");
      out.write("\n");
      out.write("            var searchString = document.forms[0].elements[\"searchString\"];\n");
      out.write("\n");
      out.write("            if (searchString.value == null || searchString.value.replace(/^\\s+|\\s+$/g, '') == \"\") {\n");
      out.write("                alert(\"Wprowadz slowa kluczowe\");\n");
      out.write("            } else {\n");
      out.write("                document.forms[0].submit();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function installApp() {\n");
      out.write("            alert(\"Instalowanie aplikacji zostalo poprawne xxx z konta\");\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<div id=\"bg1\"></div>\n");
      out.write("<div id=\"bg2\"></div>\n");
      out.write("<div id=\"outer\">\n");
      out.write("    <div id=\"header\">\n");
      out.write("        <div id=\"logo\">\n");
      out.write("            <h1><a href=\"index.html\"><i>Bazar</i> Aplikacji</a></h1>\n");
      out.write("        </div>\n");
      out.write("        <form action=\"search\" method=\"post\">\n");
      out.write("            <div id=\"search\">\n");
      out.write("                <div>\n");
      out.write("                    <input type=\"text\" class=\"text\" name=\"searchString\" size=\"32\" maxlength=\"64\">\n");
      out.write("                    <img src=\"images/search.png\" style=\"margin: -13px\" alt=\"\" onclick=\"submitSearchForm()\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div id=\"banner\">\n");
      out.write("        <div class=\"captions\">\n");
      out.write("            <h2><i>Największe</i> żródło aplikacji</h2>\n");
      out.write("        </div>\n");
      out.write("        <img src=\"images/banner.jpg\" alt=\"\" height=\"150\" width=\"1180\"/>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"main\">\n");
      out.write("        <div id=\"sidebar\">\n");
      out.write("            <div class=\"box\">\n");
      out.write("                <h3>Premiery</h3>\n");
      out.write("                <div class=\"dateList\">\n");
      out.write("                    <ul class=\"linkedList dateList\">\n");
      out.write("                        <li class=\"first\">\n");
      out.write("                            <span class=\"date\">data1</span> apka 1\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"first\">\n");
      out.write("                            <span class=\"date\">data2</span> apka 2\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"first\">\n");
      out.write("                            <span class=\"date\">data3</span> apka 3\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"first\">\n");
      out.write("                            <span class=\"date\">data4</span> apka 4\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"content\">\n");
      out.write("        <div class=\"box\"><h2>Wyniki wyszukiwania</h2></div>\n");
      out.write("    </div>\n");
      out.write("    <table style=\"width: 100%; margin-left:auto; margin-right: auto\">\n");
      out.write("        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    </table>\n");
      out.write("\n");
      out.write("    <div>\n");
      out.write("        <br class=\"clear\">\n");
      out.write("    </div>\n");
      out.write("    <br class=\"clear\">\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apps}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("app");
    _jspx_th_c_forEach_0.setVarStatus("loop");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("            <tr>\n");
          out.write("                <td style=\"width: 25%; text-align: center; vertical-align: middle;\" rowspan=\"2\">\n");
          out.write("                    <img src=\"images/apps/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${app.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\">\n");
          out.write("                </td>\n");
          out.write("                <td style=\"height: 1em; width: 75%; text-align: left; vertical-align: bottom; border-bottom: thin dotted black\">\n");
          out.write("                    <b>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${app.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</b>\n");
          out.write("                    <input type=\"button\" id=\"appDetailButton_");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loop.index}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" value=\"Szczegóły\"></td>\n");
          out.write("            </tr>\n");
          out.write("            <tr>\n");
          out.write("                <td style=\"text-align: left; vertical-align: top; padding-bottom: 30px;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${app.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("            </tr>\n");
          out.write("\n");
          out.write("\n");
          out.write("            <div style=\"font-size: 10px; display:none;\">\n");
          out.write("                <div id=\"appDetail_");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loop.index}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" title=\"Szczegóły\">\n");
          out.write("                    <img src=\"images/apps/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${app.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" style=\"float: left; margin: 10px;\" alt=\"\">\n");
          out.write("                    <b>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${app.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</b>\n");
          out.write("                    <input type=\"button\" value=\"Instaluj\" onclick=\"installApp()\">\n");
          out.write("                    <hr>\n");
          out.write("\n");
          out.write("                    <br>\n");
          out.write("                        ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${app.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                    <br><br>\n");
          out.write("                    <hr>\n");
          out.write("\n");
          out.write("                    Wspierane urządzenia:\n");
          out.write("\n");
          out.write("                    ");
          if (_jspx_meth_c_forEach_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                    <hr>\n");
          out.write("                    <br>\n");
          out.write("\n");
          out.write("                    Opinie klientów:\n");
          out.write("\n");
          out.write("                    <br>\n");
          out.write("                    <hr>\n");
          out.write("\n");
          out.write("                    ");
          if (_jspx_meth_c_forEach_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                </div>\n");
          out.write("            </div>\n");
          out.write("\n");
          out.write("            <script language=\"JavaScript\">\n");
          out.write("                $(function () {\n");
          out.write("                    $(\"#appDetailButton_");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loop.index}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\").click(function () {\n");
          out.write("                        $(\"#appDetail_");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loop.index}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\").dialog({\n");
          out.write("                            width: 650, modal: true\n");
          out.write("                        });\n");
          out.write("                    });\n");
          out.write("                });\n");
          out.write("            </script>\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${app.supportedDevices}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("customerReview");
    _jspx_th_c_forEach_1.setVarStatus("devicesLoop");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${device.manufactured}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${device.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          if (_jspx_meth_c_if_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not devicesLoop.last}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(',');
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${app.customerReviews}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_2.setVar("customerReview");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        <b>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customerReview.stars}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" na 5 gwiazdek</b>\n");
          out.write("                        (użytkownik: <i> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customerReview.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</i><br>\n");
          out.write("                        ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customerReview.comments}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                        <br>\n");
          out.write("                        <br>\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }
}
