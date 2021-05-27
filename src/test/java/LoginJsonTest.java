import com.google.gson.JsonObject;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.io.IOException;

import static setup.DriverSetup.getDriver;

public class LoginJsonTest extends TestBase {
    @Test
    public void apiLogin() throws IOException {
        JsonObject user = ApiHelper.createUser();
        String key = user.get("response").getAsJsonObject().get("key").getAsString();
        Cookie cookie = new Cookie("user_key", key);
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();

    }
}
