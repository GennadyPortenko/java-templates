package gpk.practice.spring.corecontext.dao;

import gpk.practice.spring.corecontext.connection.PrototypeConnection;
import gpk.practice.spring.corecontext.connection.ProxyPrototypeConnection;
import gpk.practice.spring.corecontext.connection.SingletonConnection;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:annotconfig.properties")
public class SomeDAO {
    @Autowired
    @Getter
    SingletonConnection singletonConnection;
    @Autowired
    @Getter
    PrototypeConnection prototypeConnection1;
    @Autowired
    @Getter
    PrototypeConnection prototypeConnection2;
    @Autowired
    @Getter
    ProxyPrototypeConnection proxyConnection1;
    @Autowired
    @Getter
    ProxyPrototypeConnection proxyConnection2;
    public void printConnections() {
        System.out.println( singletonConnection.getName() + "   : " + singletonConnection);
        System.out.println( "Prototype Connection 1 : " + prototypeConnection1);
        System.out.println( "Prototype Connection 2 : " + prototypeConnection2);
        System.out.println( "Proxy Prototype Connection 1 : " + proxyConnection1);
        System.out.println( "Proxy Prototype Connection 2 : " + proxyConnection2);
    }
}
