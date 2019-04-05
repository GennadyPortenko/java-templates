package hibernateexample;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import webstudio.WebStudio;

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

        System.out.println(addedStudioId);
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
}
