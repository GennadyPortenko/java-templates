package gpk.practice.spring.corecontext.app.annotationconfigapp;

import gpk.practice.spring.corecontext.app.IApp;
import gpk.practice.spring.corecontext.dao.SomeDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigurationApp implements IApp {
    public void start() {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                "gpk.practice.spring.corecontext.dao",
                "gpk.practice.spring.corecontext.connection");

        SomeDAO dao = context.getBean(SomeDAO.class);
        // System.out.println( "dao name : "+ dao.getName());
        System.out.println(dao.getSingletonConnection().getName() + " : " +  dao.getSingletonConnection());
    }
}
