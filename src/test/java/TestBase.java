import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static setup.DriverSetup.getDriver;

public class TestBase {

    @BeforeMethod
    public void setup() {
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
}
