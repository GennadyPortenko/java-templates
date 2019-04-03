package hibernateexample;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import webstudio.WebStudio;

public class HibernateExample {
    private static SessionFactory factory;

    public static void main(String... args)  {

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        HibernateExample he = new HibernateExample();

        Integer id01 = he.addWebStudio("ProStudio", 5450030.5d, 10);

        System.out.println(id01);
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
