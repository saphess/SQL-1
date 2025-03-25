package helpers;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    private static final QueryRunner RUNNER = new QueryRunner();

    @SneakyThrows
    public static DataHelper.User getUser(String login) {
        String requestSQL = "SELECT * FROM users WHERE login = ?";
        try (var conn = DBConnection.getCon()) {
            DataHelper.User user = RUNNER.query(conn, requestSQL, new BeanHandler<>(DataHelper.User.class), login);
            user.setPassword("qwerty123");
            return user;
        }
    }

    @SneakyThrows
    public static DataHelper.AuthCode getCode(DataHelper.User user) {
        String requestSQL = "SELECT * FROM auth_codes WHERE user_id = ? ORDER BY created DESC";
        try (var conn = DBConnection.getCon()) {
            return RUNNER.query(conn, requestSQL, new BeanHandler<>(DataHelper.AuthCode.class), user.getId());
        }
    }

    @SneakyThrows
    public static void clearingDB() {
        String delCardTransactionSQL = "DELETE FROM card_transactions";
        String delCard = "DELETE FROM cards";
        String delAuthCodes = "DELETE FROM auth_codes";
        String delUsers = "DELETE FROM users";
        try (var conn = DBConnection.getCon()) {
            RUNNER.update(conn, delCardTransactionSQL);
            RUNNER.update(conn, delCard);
            RUNNER.update(conn, delAuthCodes);
            RUNNER.update(conn, delUsers);
        }
    }

    public static class DBConnection {
        public static Connection getCon() throws SQLException {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/app",
                    "app", "pass");
        }
    }
}


