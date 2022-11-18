package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lippia.web.services.MyAccountPageService;
import lippia.web.services.MyAccountTestService;


public class Steps_Section3_Registro extends PageSteps {


    @And("enter Email {string} in Email-Address textbox")
    public void enterEmail(String email) {
        MyAccountPageService.inputEmail(email);
    }

    @And("enter password {string} in password textbox")
    public void enterPassword(String password) {
        MyAccountPageService.inputRegPassword(password);
    }

    @And("click on Register button")
    public void clickOnRegisterButton() {
        MyAccountPageService.clickAuxiliar();  //clic auxiliar para activar el boton Register
        MyAccountPageService.clickBtnRegister();
    }

    @Then("Registration must fail with a warning message  {string}")
    public void registrationErrorResponse(String mensaje) {
        MyAccountTestService.registroFallido(mensaje);
    }

}

