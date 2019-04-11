package gpk.practice.spring.corecontext.app.annotationconfigapp.connection;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:annotconfig.properties")
public class SingletonConnection {
    @Getter
    @Value("${connection.singleton.name}")
    private String name;
}
