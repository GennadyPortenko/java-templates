package gpk.practice.spring.corecontext.app.xmlconfigapp.dao;

import gpk.practice.spring.corecontext.app.xmlconfigapp.connection.Connection;
import lombok.Getter;
import lombok.Setter;

public class SomeDAO {
    @Getter
    @Setter
    Connection connection;
}
