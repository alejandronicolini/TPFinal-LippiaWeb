package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lippia.web.services.MyAccountPageService;
import lippia.web.services.MyAccountTestService;
import lippia.web.services.TpUtils;

public class Steps_Section5_Account extends PageSteps {


    @And("User must successfully login to the web page")
    public void userMustSuccessfullyLoginToTheWebPage() {
        MyAccountTestService.verifyLogIn();
    }

    @And("Click on My account link")
    public void clickOnMyAccountLink() {
        MyAccountPageService.clickBtnMyAccount();
    }

    @And("Click on Account details")
    public void clickOnAccountDetails() {
        MyAccountPageService.clickBtnAccountDetails();
    }

    @Then("User can view account details where he can change his password also")
    public void verifyAccountDetails() {
        MyAccountTestService.verifyAccountDetailsAndChangePass();
        TpUtils.signOutUser();
    }

    @And("Click on Logout button")
    public void clickOnLogoutButton() {
        MyAccountPageService.clickBtnSignOut();
    }

    @Then("On clicking logout,User successfully comes out from the site")
    public void verifyLogOut() {
        MyAccountTestService.verifyViewLoginPage();
    }

}
