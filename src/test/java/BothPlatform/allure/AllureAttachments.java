package BothPlatform.allure;
import io.qameta.allure.Attachment;
import org.apache.commons.codec.binary.Base64;

public class AllureAttachments {

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] addScreenshotAs(String attachName, byte[] screenshot) {
        return screenshot;
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String attachVideo(byte[] videoData) {
        String videoBase64 = Base64.encodeBase64String(videoData);
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='data:video/mp4;base64,"
                + videoBase64 + "' type='video/mp4'></video></body></html>";
    }
}


