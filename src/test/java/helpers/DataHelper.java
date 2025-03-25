package helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DataHelper {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class User {
        String id;
        String login;
        String password;
        String status;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AuthCode {
        String id;
        String user_id;
        String code;
        String created;
    }
}
