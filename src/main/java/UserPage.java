import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class UserPage extends BasePage {

    @Override
    public String getUrl() {
        return BASE_URL + "u/smart_offer";
    }

    public void open() {
        open(getUrl());
    }

   //private By likeLocation = By.cssSelector("i[class*='c-like-button']");
    private By likeLocation = By.cssSelector("[class*='c-dynamic-tooltip'] [data-photo-id='349802346077201']");
    private By userPhotoGrid = By.cssSelector("[data-js-analytics-page='user_profile']");
    //private By image = By.cssSelector("[class*='img-wrapper']");
    private By image = By.cssSelector("figure[class*='c-preview']");

    public void openImage() {
        WaitHelper.getInstance().waitForElementDisplayed(userPhotoGrid);
        Actions actions = new Actions(driver);
        List<WebElement> imagesList = findAll(image);
        // click(imagesList.get(0));
        actions.moveToElement(imagesList.get(0)).build().perform();
    }

    public void clickLikeButton() {
        WaitHelper.getInstance().waitForElementDisplayed(likeLocation);
        click(likeLocation);
    }

    public boolean isImageLiked() {
        return find(likeLocation).getAttribute("class").contains("active");
    }

    public void moveToLikeButton() {
        WaitHelper.getInstance().waitForElementDisplayed(likeLocation);
        Actions actions = new Actions(driver);
        actions.moveToElement(find(likeLocation)).click().build().perform();
    }


}
