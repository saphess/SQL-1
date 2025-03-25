package Helpers;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DataHelper {
    private static final Faker FAKER = new Faker();

    public User generateUser() {
        return new User(
                FAKER.internet().password(),
                FAKER.name().firstName(),
                "password",
                "active"
        );
    }

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
