package gpk.practice.spring.corecontext.app.annotationconfigapp.connection;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
@PropertySource("classpath:app.properties")
public class ProxyPrototypeConnection {
    @Getter
    @Value("${connection.prototype.name}")
    private String name;
}
