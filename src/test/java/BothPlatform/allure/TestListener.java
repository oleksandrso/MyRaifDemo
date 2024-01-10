package BothPlatform.allure;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
//        byte[] videoData = stopRecording();
        byte[] screenshot = DriverUtils.getScreenshotAsBytes();
        AllureAttachments.addScreenshotAs("Failure screenshot", screenshot);
//        AllureAttachments.attachVideo(videoData);
//        acceptTrackPermissionAfterOnboard();
    }
}
