package gpk.practice.spring.corecontext.connection;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@PropertySource("classpath:annotconfig.properties")
public class PrototypeConnection {
    @Getter
    @Value("${connection.prototype.name}")
    private String name;
}
