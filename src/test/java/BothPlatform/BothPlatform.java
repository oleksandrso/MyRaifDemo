package BothPlatform;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.testng.Assert.assertTrue;


public class BothPlatform {
    public static URL getAppiumServerUrl() {
        try {
            String appiumUrl=System.getProperty("appiumUrl","http://127.0.0.1:4723/");
            return new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }

    public static void allureConfigFile() {
        Path configJenkinsFile = Path.of("notifications/configJenkins.json");

        String content = null;
        try {
            content = new String(Files.readAllBytes(configJenkinsFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = new JSONObject(content);

        // Update values
        String env = System.getProperty("env");

        jsonObject.getJSONObject("base").put("project", "MyRaif");
        jsonObject.getJSONObject("base").put("environment", env);

        // Write JSON back to file
        try {
            Files.write(configJenkinsFile, jsonObject.toString(4).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
