package com.bartek.util;

import com.bartek.domain.App;
import com.bartek.domain.CustomerReview;
import com.bartek.domain.Device;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Arrays;
import java.util.HashSet;

@WebListener
public class StartupDataLoader implements ServletContextListener {

    private static SessionFactory sessionFactory;

    Logger logger = LoggerFactory.getLogger(StartupDataLoader.class);

    public static synchronized Session openSession() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();

            configuration.configure();

            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        }
        return sessionFactory.openSession();
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {


        Session session = openSession();
        session.beginTransaction();

        Device xPhone = new Device("Orange", "xPhone", null);
        Device xTablet = new Device("Orange", "xTablet", null);
        Device solarSystem = new Device("Song-Sung", "Solar System Phone", null);
        Device flame = new Device("Jungle", "Flame Book Reader", null);
        Device pc = new Device(null, "Pecet", null);

        App theCloud = new App("Chmura!", "cloud.jpg", "Aplikacja Chmura! jest miejscem, w którym dziej¹ siê cuda. Firmy dzia³aj¹ w chmurach. Programici nie potrzebuj¹ administratorów, jedzenia i picia w zasadzie te¿ nie. Mo¿esz ogl¹daæ telewizjê na tablecie, siedzaæ na kanapie; nie musisz w ogóle patrzeæ na telewizor! ci¹gnij aplikacjê Chmura! z chmury i dowiadcz tej cudownej potêgi!");
        theCloud.setSupportedDevices(new HashSet<Device>(Arrays.asList(new Device[]{xPhone, xTablet})));
        CustomerReview theCloudReview1 = new CustomerReview("fanboy1984", 5, "Ta aplikacja sprawia, ¿e mój xPhone jest jeszcze bardziej stylowy i trendy!");
        CustomerReview theCloudReview2 = new CustomerReview("anty.hipster", 1, "Nie rozumiem o co chodzi z t¹ 'Chmur¹'.  Dla mnie to raczej marketingowy be³kot...");
        theCloud.setCustomerReviews(new HashSet<CustomerReview>(Arrays.asList(new CustomerReview[]{theCloudReview1, theCloudReview2})));
        session.save(theCloud);
        logger.info("Zapisujê " + theCloud.getName());

        App salesCloser = new App("Zamykacz transakcji", "pointing.jpg", "Wysokoenergetyczna aplikacja wspomagaj¹ca energicznych sprzedawców. Twórz pe³ne energii kalendarze i arkusze. Gdy jeste w miecie i energicznie nawi¹zujesz kontakty, chcesz prezentowaæ swe naenergetyzowane foldery, pokazuj¹ce, ¿e te¿ masz w sobie mnóstwo energii.");
        salesCloser.setSupportedDevices(new HashSet<Device>(Arrays.asList(new Device[]{xPhone, solarSystem})));
        CustomerReview salesCloserReview = new CustomerReview("GdzieJestKasa", 5, "wietna aplikacja!  Je¿eli u¿ywa³e kiedy 'Sales Commandera 2000', szybko po³apiesz siê w tym interfejsie.");
        salesCloser.setCustomerReviews(new HashSet<CustomerReview>(Arrays.asList(new CustomerReview[]{salesCloserReview})));
        session.save(salesCloser);
        logger.info("Zapisujê " + salesCloser.getName());

        App football = new App("Miêdzynarodowy turniej pi³karski", "ball.jpg", "Ta ma³a aplikacja oferuje Ci radoæ gry w pi³kê no¿n¹, poza tym, ¿e grasz na ekranie dotykowym, zamiast biegaæ i kopaæ albo w ogóle siê ruszaæ. Poza tym zapewnia podobne wra¿enia.");
        football.setSupportedDevices(new HashSet<Device>(Arrays.asList(new Device[]{xTablet, flame})));
        CustomerReview footballReview = new CustomerReview("PrawdziwyAmerykanin", 2, "Podpucha... To nie jest amerykañski futbol!");
        football.setCustomerReviews(new HashSet<CustomerReview>(Arrays.asList(new CustomerReview[]{footballReview})));
        session.save(football);
        logger.info("Zapisujê " + football.getName());

        App crystal = new App("Kolejna gra o kryszta³ach", "brilliant.jpg", "Olniewaj¹ca aplikacja, w której ³¹czysz kryszta³y tego samego koloru, by zniknê³y. Co jak Tetris. W sumie przypomina tuzin innych gier, w których ³¹czysz kryszta³y tego samego koloru.");
        crystal.setSupportedDevices(new HashSet<Device>(Arrays.asList(new Device[]{flame, pc})));
        CustomerReview crystalReview = new CustomerReview("KolejnyGracz", 3, "czemu ta gra jest dostêpna tylko na dwóch urz¹dzeniach?  Z tuzin klonów tej gry jest dostêpny dla wszystkich urz¹dzeñ.  Powinnicie deaktywowaæ t¹ aplikacjê do czasu, gdy wszystkie urz¹dzenia bêd¹ wspierane...");
        crystal.setCustomerReviews(new HashSet<CustomerReview>(Arrays.asList(new CustomerReview[]{crystalReview})));
        crystal.setActive(false);
        session.save(crystal);
        logger.info("Zapisujê " + crystal.getName());

        App pencilSharpener = new App("Temperówka", "pencil.jpg", "Ostrz o³ówki, wk³adaj¹c je do gniazda Bluetooth i wciskaj¹c przycisk. Ta aplikacja wyciska ze sprzêtu wszystko!");
        pencilSharpener.setSupportedDevices(new HashSet<Device>(Arrays.asList(new Device[]{xPhone, solarSystem})));
        CustomerReview pencilSharpenerReview1 = new CustomerReview("brakuje.cyferek", 1, "Ta aplikacja jest niebezpieczna!  Mylê o pozwie.");
        CustomerReview pencilSharpenerReview2 = new CustomerReview("Prawnik", 5, "@brakuje.cyferek  Napisz do mnie.  Pogadamy...");
        pencilSharpener.setCustomerReviews(new HashSet<CustomerReview>(Arrays.asList(new CustomerReview[]{pencilSharpenerReview1, pencilSharpenerReview2})));
        session.save(pencilSharpener);
        logger.info("Zapisujê " + pencilSharpener.getName());

        App staplerTracker = new App("Namierzacz zszywaczy", "stapler.jpg", "Czy kto ci¹gle po¿ycza sobie Twój zszywacz? To typowy problem w biurach. Nasza aplikacja biznesowa sprawi, ¿e ju¿ nigdy nie bêdziesz musia³ siê zastanawiaæ, gdzie podziewa siê Twój zszywacz.");
        staplerTracker.setSupportedDevices(new HashSet<Device>(Arrays.asList(new Device[]{pc})));
        CustomerReview staplerTrackerReview = new CustomerReview("mike.bolton", 3, "'PC LOAD LETTER'?  O co w ogóle chodzi?!?");
        staplerTracker.setCustomerReviews(new HashSet<CustomerReview>(Arrays.asList(new CustomerReview[]{staplerTrackerReview})));
        session.save(staplerTracker);
        logger.info("Zapisujê " + staplerTracker.getName());

        App frustratedFlamingos = new App("Sfrustrowane Flamingi", "flamingo.jpg", "Ma³a aplikacja pozwalaj¹ca na ciskanie wielkimi ptakami na lewo i prawo bez powodu. Chyba nie zastanawiasz siê czemu s¹ sfrustrowane?");
        frustratedFlamingos.setSupportedDevices(new HashSet<Device>(Arrays.asList(new Device[]{xPhone, xTablet, solarSystem, flame, pc})));
        CustomerReview frustratedFlamingosReview = new CustomerReview("Procarz", 4, "LOL, uwielbiam katapulotwaæ flamingi w krowy! Trochê mnie wkurza, ¿e reklama trochê zas³ania obszar gry.");
        frustratedFlamingos.setCustomerReviews(new HashSet<CustomerReview>(Arrays.asList(new CustomerReview[]{frustratedFlamingosReview})));
        session.save(frustratedFlamingos);
        logger.info("Zapisujê " + frustratedFlamingos.getName());

        App grype = new App("Wideokonferencje Grype", "laptop.jpg", "Dzwoñ za darmo lokalnie i za granicê, równie¿ z transmisj¹ obrazu, u¿ywaj¹c domowego po³¹czenia internetowego i naszego produktu. W sumie nasz aplikacja zadzia³a jeszcze lepiej jeli skorzystasz z po³¹czenia internetowego Twojego pracodawcy!");
        grype.setSupportedDevices(new HashSet<Device>(Arrays.asList(new Device[]{xPhone, xTablet, solarSystem, pc})));
        CustomerReview grypeReview = new CustomerReview("biurowy.luzak", 4, "Szkoda, ¿e dodali obs³ugê wideo do najnowszej wersji. Wczeniej nie musia³em siê ubieraæ.");
        grype.setCustomerReviews(new HashSet<CustomerReview>(Arrays.asList(new CustomerReview[]{grypeReview})));
        session.save(grype);
        logger.info("Zapisujê " + grype.getName());

        App eReader = new App("Czytnik e-booków", "book.jpg", "Nasza aplikacja sprawi, ¿e bêdziesz móg³ czytaæ ksi¹¿ki na komputerze albo na dowolnym urz¹dzeniu mobilnym.  Polecamy \"Hibernate Search by Example\".");
        eReader.setSupportedDevices(new HashSet<Device>(Arrays.asList(new Device[]{xPhone, xTablet, solarSystem, flame, pc})));
        CustomerReview eReaderReview = new CustomerReview("StevePerkins", 5, "Ksi¹¿ka 'Hibernate Search by Example' jest super!  Dziêki za rekomendacje!");
        eReader.setCustomerReviews(new HashSet<CustomerReview>(Arrays.asList(new CustomerReview[]{eReaderReview})));
        session.save(eReader);
        logger.info("Zapisujê " + eReader.getName());

        App domeBrowser = new App("Przegl¹darka pod kopu³¹", "orangeswirls.jpg", "Ta cudowna aplikacja pozwala nam ledziæ Twoj¹ aktywnoæ w Internecie. Mo¿emy odgadn¹æ, gdzie mieszkasz, co jad³e dzisiaj na niadanie, albo jakie s¹ Twoje najwiêksze sekrety. Aha, w aplikacjê jest jeszcze wbudowana przegl¹darka stron WWW.");
        domeBrowser.setSupportedDevices(new HashSet<Device>(Arrays.asList(new Device[]{solarSystem, flame, pc})));
        CustomerReview domeBrowserReview = new CustomerReview("oni.wiedza", 1, "Odinstalowa³em t¹ aplikacjê.  Je¿eli uda³o im siê sfa³szowaæ l¹dowanie na ksiê¿ycu, z pewnoci¹ wykorzystaj¹ historiê mojej przegl¹darki przeciwko mnie.");
        domeBrowser.setCustomerReviews(new HashSet<CustomerReview>(Arrays.asList(new CustomerReview[]{domeBrowserReview})));
        session.save(domeBrowser);
        logger.info("Zapisujê " + domeBrowser.getName());

        App athenaRadio = new App("Internetowe radio Atena", "jamming.jpg", "S³uchaj swoich ulubionych piosenek w radiu internetowym! Kiedy polubisz jaki utwór, nasza aplikacja zagra Ci wiêcej podobnych kompozycji. A przynajmniej zagra wiêcej piosenek ... ¯eby byæ szczerym, czasem wcale nie s¹ takie podobne  :(");
        athenaRadio.setSupportedDevices(new HashSet<Device>(Arrays.asList(new Device[]{xPhone, xTablet, solarSystem, flame, pc})));
        CustomerReview athenaRadioReview = new CustomerReview("lskinner", 5, "Chcia³em'Free Bird', dosta³em 'Free Bird'.  Czego chcieæ wiêcej?");
        athenaRadio.setCustomerReviews(new HashSet<CustomerReview>(Arrays.asList(new CustomerReview[]{athenaRadioReview})));
        session.save(athenaRadio);
        logger.info("Zapisujê " + athenaRadio.getName());

        App mapJourney = new App("Mapa podró¿y", "compass.jpg", "Potrzebujesz wskazówek, by dotrzeæ do celu?  Nasza aplikacja GPS na pewno wygeneruje wystarczaj¹co du¿o propozycji, by dotar³ do celu!  Prêdzej czy póniej.");
        mapJourney.setSupportedDevices(new HashSet<Device>(Arrays.asList(new Device[]{xPhone, solarSystem, pc})));
        CustomerReview mapJourneyReview = new CustomerReview("Zagubiony", 3, "Nic szczególnego... ale ci¹gle o niebo lepsze od map Orange.");
        mapJourney.setCustomerReviews(new HashSet<CustomerReview>(Arrays.asList(new CustomerReview[]{mapJourneyReview})));
        session.save(mapJourney);
        logger.info("Zapisujê " + mapJourney.getName());

        session.getTransaction().commit();

        session.close();

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        if (!sessionFactory.isClosed()) {
            sessionFactory.close();
        }

    }
}
