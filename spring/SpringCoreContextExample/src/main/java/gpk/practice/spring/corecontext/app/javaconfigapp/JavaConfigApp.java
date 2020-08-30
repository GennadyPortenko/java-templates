package gpk.practice.spring.corecontext.app.javaconfigapp;

import gpk.practice.spring.corecontext.app.IApp;
import gpk.practice.spring.corecontext.app.javaconfigapp.dao.SomeDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigApp implements IApp {
    public void start() {
        try ( AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(AppConfig.class)) {

            SomeDAO dao = context.getBean(SomeDAO.class);
            System.out.println(dao.getConnection().getName());
        }
    }
}
