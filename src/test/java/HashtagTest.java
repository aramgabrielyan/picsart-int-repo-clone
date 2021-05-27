import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class HashtagTest extends TestBase {

    @Test
    public void uploadPhotoWithHashtag() throws IOException {
        JsonObject photo = ApiHelper.uploadPhoto(key);
        long imageId = photo.getAsJsonPrimitive("id").getAsLong();
        ApiHelper.editPhoto(key, "#hashtag_added", imageId);
        UploadedImagePage uploadedImagePage = new UploadedImagePage(imageId);
        assertTrue(uploadedImagePage.isHashtagChanged(), "Hashtag not changed");
    }

}
