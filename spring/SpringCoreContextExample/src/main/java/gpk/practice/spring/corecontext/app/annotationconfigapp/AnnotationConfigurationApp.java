package gpk.practice.spring.corecontext.app.annotationconfigapp;

import gpk.practice.spring.corecontext.app.IApp;
import gpk.practice.spring.corecontext.app.annotationconfigapp.dao.SomeDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"gpk.practice.spring.corecontext.app.annotationconfigapp.dao",
                 "gpk.practice.spring.corecontext.app.annotationconfigapp.connection"})
public class AnnotationConfigurationApp implements IApp {
    public void start() {
        /*
        ApplicationContext context = new AnnotationConfigApplicationContext(
                "gpk.practice.spring.corecontext.app.annotationconfigapp.dao",
                "gpk.practice.spring.corecontext.app.annotationconfigapp.connection");
        */
        try (AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AnnotationConfigurationApp.class)) {

            SomeDAO dao1 = context.getBean(SomeDAO.class);
            SomeDAO dao2 = context.getBean(SomeDAO.class);

            System.out.println("dao1 : ");
            dao1.printConnections();

            System.out.println("dao2 : ");
            dao2.printConnections();
        }
    }
}
