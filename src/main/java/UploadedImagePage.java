import org.openqa.selenium.By;

public class UploadedImagePage extends BasePage {

    private final By hashtag = By.cssSelector("[href='/hashtag/hashtag_added']");

    public UploadedImagePage(long imageId) {
        open(BASE_URL + "/i/" + imageId);
    }

    @Override
    public String getUrl() {
        return null;
    }

    public boolean isHashtagChanged() {
        return isDisplayed(hashtag);
    }
}
