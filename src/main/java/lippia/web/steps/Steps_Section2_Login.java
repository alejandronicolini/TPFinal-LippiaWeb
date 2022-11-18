package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lippia.web.services.MyAccountPageService;
import lippia.web.services.MyAccountTestService;
import lippia.web.services.TpUtils;

public class Steps_Section2_Login extends PageSteps {


    @And("Enter the case changed username in username textbox")
    public void usernameChanged() {
        MyAccountPageService.changeCaseUsername();
    }

    @And("Enter the case changed password in the password tetxbox")
    public void passwordChanged() {
        MyAccountPageService.changeCasePassword();
    }

    @Then("Login must fail saying: {string}")
    public void loginMustFailSaying(String mensaje) {
        MyAccountTestService.verifyLoginFail2(mensaje);
    }

    @And("Once your are logged in, sign out of the site")
    public void signOutOfTheSite() {
        MyAccountTestService.verifyLogIn();
        MyAccountPageService.clickBtnSignOut();
    }

    @And("Now press back button")
    public void pressBackButton() {
        TpUtils.goBackPage();
    }

    @Then("User shouldn’t be signed in to his account rather a general webpage must be visible")
    public void verifyViewGeneralLoginPage() {
        MyAccountTestService.verifyViewLoginPage();
    }

}
