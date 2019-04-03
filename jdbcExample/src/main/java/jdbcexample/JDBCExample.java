package jdbcexample;


import java.sql.*;

public class JDBCExample {
    public static void main(String... args) {

        String url = "jdbc:mysql://localhost/test";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) { e.printStackTrace(); }
        try (
                Connection connection = DriverManager.getConnection(url, "test", "test");
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(
                        "SELECT u.name, c.id FROM users AS u LEFT JOIN cities AS c ON u.city = c.name WHERE c.id != 0;"
                );
        ){
            while (result.next()) {
                System.out.println(result.getString("name") + " " + result.getInt("id"));
            }
        } catch (SQLException e) { e.printStackTrace(); }

    }
}
