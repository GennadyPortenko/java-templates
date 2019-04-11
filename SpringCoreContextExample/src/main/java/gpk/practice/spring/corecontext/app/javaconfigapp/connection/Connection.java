package gpk.practice.spring.corecontext.app.javaconfigapp.connection;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

public class Connection {
    @Value("${connection.singleton.name}")
    @Getter
    private String name;
}
