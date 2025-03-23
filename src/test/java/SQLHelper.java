import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    private static final QueryRunner RUNNER = new QueryRunner();

    @SneakyThrows
    public static void updateUsers(DataHelper.User user) {
        String requestSQL = "INSERT INTO users(id, login, password) VALUES (?, ?, ?)";
        try (var conn = DBConnection.getCon()) {
            RUNNER.update(conn, requestSQL, user.getId(), user.getLogin(), user.getPassword());
        }
    }

    @SneakyThrows
    public static DataHelper.User getFirstUser() {
        String requestSQL = "SELECT * FROM users";
        try (var conn = DBConnection.getCon()) {
            return RUNNER.query(conn, requestSQL, new BeanHandler<>(DataHelper.User.class));
        }
    }

    public static class DBConnection {
        public static Connection getCon() throws SQLException {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/app",
                    "app", "pass");
        }
    }
}


