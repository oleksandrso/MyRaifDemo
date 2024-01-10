package android.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class PermissionDialogPage {
    public static final SelenideElement
            PERMISSION_MESSAGE = $(AppiumBy.id("com.android.permissioncontroller:id/permission_message")),
            ALLOW_BUTTON = $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")),
            DONT_ALLOW_BUTTON = $(AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button"));

}
