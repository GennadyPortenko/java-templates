package gpk.practice.spring.corecontext.dao;

import gpk.practice.spring.corecontext.connection.SingletonConnection;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeDAO {
    @Autowired
    @Getter
    SingletonConnection singletonConnection;
}
