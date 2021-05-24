import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getDriver;

public class LikeTest extends TestBase {


    @Test
    public void likeTest() {
        UserPage userPage = new UserPage();
        userPage.open();

        Cookie cookie = new Cookie("user_key", "a524635b-49f3-401d-8fe0-cd982a456ea8");
        Cookie cookieSid = new Cookie("sid", "s%3AS0vB_oUQHKdOX0MWenwCu0I1GOcHqQA6.vBG1FBd2k4L66jDa6KVPS1zbVzVFDB2RXHgD5%2F257K8");
        getDriver().manage().addCookie(cookie);
        getDriver().manage().addCookie(cookieSid);
        getDriver().navigate().refresh();

        userPage.moveToImage();
        if(!userPage.isImageLiked()){
            userPage.moveToLikeButton();
        }
        assertTrue(userPage.isImageLiked(), "Error");
    }
}

