package lippia.web.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lippia.web.services.HomePageService;
import lippia.web.services.MyAccountPageService;
import lippia.web.services.TpUtils;

import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class Steps_Comunes extends PageSteps {

    @Given("the user is on the home page of practice.automationtesting.in")
    public void homePage() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
        TpUtils.cambiarVentana();
    }

    @Given("create User")
    public void crearUsuario() {
        TpUtils.cambiarVentana();
        TpUtils.createUser();
    }

    @When("clic on Shop Menu")
    public void clicOnShopMenu() {
        HomePageService.clickBtnShopMenu();
    }

    @When("clic on My Account Menu")
    public void clicOnMyAccountMenu() {
        HomePageService.clickBtnMyAccountMenu();
    }

    @And("Enter the username in username textbox")
    public void enterUsername() {
        MyAccountPageService.inputUserName(TpUtils.info_email);
    }

    @And("Enter the password in password textbox")
    public void enterPasswordLogin() {
        MyAccountPageService.inputLoginPassword(TpUtils.info_password);
    }

    @And("click on login button")
    public void clickOnLoginButton() {
        MyAccountPageService.clickBtnLogin();
    }


}
