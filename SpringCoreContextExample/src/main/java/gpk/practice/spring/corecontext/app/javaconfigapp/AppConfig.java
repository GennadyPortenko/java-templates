package gpk.practice.spring.corecontext.app.javaconfigapp;

import gpk.practice.spring.corecontext.app.javaconfigapp.connection.Connection;
import gpk.practice.spring.corecontext.app.javaconfigapp.dao.SomeDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:app.properties")
public class AppConfig {

    @Bean
    public Connection connectionBean() { return new Connection(); }
    @Bean
    public SomeDAO daoBean() { return new SomeDAO(connectionBean()); }
}
