import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private DataHelper() {

    }

    public static AuthInfo getAuthInfo() {
        var faker = new Faker(new Locale("eng"));
        String id = faker.internet().password();
        String login = faker.name().firstName();
        String pass = faker.internet().password();

        AuthInfo authInfo = new AuthInfo(id, login, pass);
        return authInfo;
    }

    public static VerificationCode getVerificationCode(AuthInfo authInfo) {
        VerificationCode verificationCode = new VerificationCode(authInfo.user_id,
                "123456");
        return verificationCode;
    }

    @Value
    public static class AuthInfo {
        String user_id;
        String login;
        String password;
    }

    @Value
    public static class VerificationCode {
        String user_id;
        String code;
    }

}


