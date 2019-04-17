package hibernateexample;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import webstudio.WebStudio;

import java.util.List;
import java.util.Properties;

public class HibernateExample {
    private static SessionFactory factory = null;
    private static StandardServiceRegistry registry = null;

    public static void main(String... args)  {

        try {
           // XML configuration :
           // factory = new Configuration().configure().buildSessionFactory();

           // Java-based configuration :
           Properties prop = new Properties();
                prop.setProperty("connection.driver_class", "com.mysql.jdbc.Driver");
                prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/test");
                prop.setProperty("hibernate.connection.username", "test");
                prop.setProperty("hibernate.connection.password", "test");
                prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            factory =  new Configuration()
                    .addAnnotatedClass(WebStudio.class)
                    .setProperties(prop)
                    .buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        HibernateExample he = new HibernateExample();

        Integer addedStudioId = he.addWebStudio("ProStudio", 5450030.5d, 10);

        System.out.println("ID of the added studio : " + addedStudioId);

        WebStudio firstStudio = he.getWebstudioById(1);
        System.out.println(firstStudio);

        he.updateWebstudio(1, firstStudio.getName(),
                            firstStudio.getAnnualProfit(),
                            firstStudio.getEmployeesNum() + 1 );

        System.out.println(he.getWebstudioById(1));

        List webstudios= he.getWebstudios();
        if (webstudios == null) {
            throw new RuntimeException("Unable to read content of WEBSTUDIO table");
        }
        if (webstudios.isEmpty()) {
            System.out.println("WEBSTUDIO table id empty");
        } else {
            System.out.println("Number of web-studios: " + webstudios.size());
            System.out.println("Deleting the last web-studio...");
            he.deleteWebstudio(((List<WebStudio>)webstudios).get(webstudios.size() - 1).getId());
            webstudios= he.getWebstudios();
            if (webstudios == null) {
                throw new RuntimeException("Unable to read content of WEBSTUDIO table");
            }
            System.out.println("Number of web-studios: " + webstudios.size());
        }


    }

    public Integer addWebStudio(String name, double annualProfit, int employeesNum){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer webStudioID = null;
        try {
            tx = session.beginTransaction();
            WebStudio webStudio = new WebStudio(name, annualProfit, employeesNum);
            webStudioID = (Integer) session.save(webStudio);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return webStudioID;
    }

    public void deleteWebstudio(Integer webstudioId){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            WebStudio webstudio = (WebStudio) session.get(WebStudio.class, webstudioId);
            session.delete(webstudio);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public WebStudio getWebstudioById(Integer webstudioId){
        Session session = factory.openSession();
        Transaction tx = null;
        WebStudio webstudio = null;
        try {
            tx = session.beginTransaction();
            webstudio = (WebStudio) session.get(WebStudio.class, webstudioId);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return webstudio;
    }

    public void updateWebstudio(Integer webstudioId, String name, double annualProfit, int empliyeesNum){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            WebStudio webstudio = (WebStudio) session.get(WebStudio.class, webstudioId);
            webstudio.setName(name);
            webstudio.setAnnualProfit(annualProfit);
            webstudio.setEmployeesNum(empliyeesNum);
            session.update(webstudio);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List getWebstudios( ){
        Session session = factory.openSession();
        Transaction tx = null;
        List webstudios= null;
        try {
            tx = session.beginTransaction();
            webstudios = session.createQuery("FROM WEBSTUDIO").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return webstudios;
    }

}
