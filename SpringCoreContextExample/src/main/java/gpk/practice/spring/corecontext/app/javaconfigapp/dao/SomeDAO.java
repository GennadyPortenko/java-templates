package gpk.practice.spring.corecontext.app.javaconfigapp.dao;

import gpk.practice.spring.corecontext.app.javaconfigapp.connection.Connection;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SomeDAO {
    @Getter
    final Connection connection;
}
