package gpk.practice.spring.corecontext.app.xmlconfigapp;

import gpk.practice.spring.corecontext.app.IApp;
import gpk.practice.spring.corecontext.app.xmlconfigapp.dao.SomeDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigApp implements IApp {
    public void start() {
        try ( ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("classpath:appconfig.xml")) {

            SomeDAO dao = (SomeDAO) context.getBean("daoBean");
            System.out.println(dao.getConnection().getName());
        }
    }
}
