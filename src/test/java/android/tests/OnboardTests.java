package android.tests;

import android.driver.MobileTestBaseAndroid;
import android.pages.BoardPage;
import android.pages.PermissionDialogPage;
import android.pages.RegistrationPage;
import android.pages.SupportPage;
import android.pages.boarding_pages.BoardPageThree;
import android.pages.boarding_pages.BoardPageTwo;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.MINOR;


@Story("Here we check all Onboard after install")
@Feature("Onboard functional")
@Epic("Onboard")
@Severity(MINOR)
@Issue("Check onboard process")
public class OnboardTests extends MobileTestBaseAndroid {


    @Test(priority = 1, testName = "Check All Elements on Boarding Page", description = "Check visibility of all important elements on the boarding page")
    void checkAllElementsOnBoardingPage() {
        step("Action bar root is visible", () -> {
            BoardPage.ACTION_BAR_ROOT.shouldBe(visible);
        });
        step("Navigation host container is visible", () -> {
            BoardPage.NAV_HOST_CONTAINER.shouldBe(visible);
        });
        step("Permissions navigation host is visible", () -> {
            BoardPage.PERMISSIONS_NAV_HOST.shouldBe(visible);
        });
        step("Onboard page title is visible", () -> {
            BoardPage.ONBOARD_PAGE_TITLE.shouldBe(visible);
        });
        step("Onboard page subtitle is visible", () -> {
            BoardPage.ONBOARD_PAGE_SUBTITLE.shouldBe(visible);
        });
        step("Continue button is visible", () -> {
            BoardPage.CONTINUE_BUTTON.shouldBe(visible);
        });
        step("Support button is visible", () -> {
            BoardPage.NAVIGATION_BAR_TRAILING_ICON.shouldBe(visible).click();
        });
    }

    @Test(priority = 2, testName = "Check All Elements on Support Page", description = "Check visibility of all important elements on the support page")
    void checkAllElementsOnSupportPage() {
        step("Info icon is visible", () -> {
            SupportPage.SUPPORT_NAV_HOST.shouldBe(visible);
        });
        step("Headline group is visible", () -> {
            SupportPage.HEADLINE_GROUP.shouldBe(visible);
        });
        step("'Need Any Help?' text is visible", () -> {
            SupportPage.NEED_ANY_HELP_TEXT.shouldBe(visible);
        });
        step("'We are in touch with you 24/7' text is visible", () -> {
            SupportPage.WE_ARE_IN_TOUCH_TEXT.shouldBe(visible);
        });
        step("'We are in touch with you 24/7' text is visible", () -> {
            SupportPage.NAVIGATION_BAR_BACK_BUTTON.shouldBe(visible).click();
        });
    }

    @Test(priority = 3, testName = "Return to Boarding Page, Click Continue and Accept Permissions", description = "Return to the boarding page, click on the continue button and accept permissions")
    void returnToBoardingPageClickContinueAndAcceptPermissions() {

        BoardPage.CONTINUE_BUTTON.shouldBe(visible).click();

        step("Permission message is visible", () -> {
            PermissionDialogPage.PERMISSION_MESSAGE.shouldBe(visible);
        });
        step("Click on 'ALLOW' button", () -> {
            PermissionDialogPage.ALLOW_BUTTON.click();
        });
    }

    @Test(priority = 4, testName = "Check Elements on Board Page One", description = "Check elements on the first board page and click next")
    void checkElementsOnBoardPageOne() {
        step("Check title text visibility on Page One", () -> {

            BoardPage.TITLE_TEXT.shouldBe(visible);
        });
        step("Check subtitle text visibility on Page One", () -> {
            BoardPage.SUBTITLE_TEXT.shouldBe(visible);
        });
        step("Click 'Next' button on Page One", () -> {
            BoardPage.NEXT_BUTTON.click();
        });
    }


    @Test(priority = 5, testName = "Check Elements on Board Page Two", description = "Check elements on the second board page and click next")
    void checkElementsOnBoardPageTwo() {
        step("Check title text visibility on Page Two", () -> {
            BoardPageTwo.TITLE_TEXT.shouldBe(visible);
        });
        step("Check subtitle text visibility on Page Two", () -> {
            BoardPageTwo.SUBTITLE_TEXT.shouldBe(visible);
        });
        step("Click 'Next' button on Page Two", () -> {
            BoardPageTwo.NEXT_BUTTON.click();
        });
    }

    @Test(priority = 6, testName = "Check Elements on Board Page Three", description = "Check elements on the third board page and click register")
    void checkElementsOnBoardPageThree() {
        step("Check title text visibility on Page Three", () -> {
            BoardPageThree.TITLE_TEXT.shouldBe(visible);
        });
        step("Check subtitle text visibility on Page Three", () -> {
            BoardPageThree.SUBTITLE_TEXT.shouldBe(visible);
        });
        step("Click 'Register' button on Page Three", () -> {
            BoardPageThree.REGISTER_BUTTON.click();
        });
    }

    @Test(priority = 7, testName = "Enter Phone Number and Click Continue", description = "Enter phone number and click on the continue button")
    void enterPhoneNumberAndClickContinue() {
        step("Enter phone number", () -> {
            RegistrationPage.enterPhoneNumber("671234567");
        });
        step("Click on 'Continue' button", () -> {
            RegistrationPage.CONTINUE_BUTTON.shouldBe(visible).shouldBe(enabled);
        });
    }
}

