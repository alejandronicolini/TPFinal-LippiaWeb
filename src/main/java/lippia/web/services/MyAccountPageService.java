package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.MyAccountPageConstants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class MyAccountPageService extends ActionManager {

    public static String userName;

    public static void clickBtnRegister() {
        WebElement btnRegister= getElement(MyAccountPageConstants.BTN_REGISTER_XPATH);
        ((JavascriptExecutor)DriverManager.getDriverInstance()).executeScript("arguments[0].removeAttribute('disabled')", btnRegister);
        click(waitClickable(MyAccountPageConstants.BTN_REGISTER_XPATH));
    }

    public static void clickAuxiliar() {
        click("xpath://p[@class='woocomerce-FormRow form-row']");
    }

    public  static void inputEmail (String email){
        setInput(MyAccountPageConstants.INPUT_EMAIL_ID, email,true,false);
    }

    public static void inputRegPassword(String password) {
        setInput(MyAccountPageConstants.INPUT_REG_PASSWORD_ID, password,true, false);
    }

    public static void inputUserName(String userName) {
        setInput(MyAccountPageConstants.INPUT_USER_NAME_ID, userName);
    }

    public static void inputLoginPassword(String password) {
        setInput(MyAccountPageConstants.INPUT_LOGIN_PASSWORD_ID, password,true, false);
    }

    public static void clickBtnLogin() {
        click(waitClickable(MyAccountPageConstants.BTN_LOGIN_XPATH));
    }

    public static void clicBtnLogout() {
        click(waitClickable(MyAccountPageConstants.BTN_LOGOUT_XPATH));
    }

    public static void changeCaseUsername() {
        userName = TpUtils.reverseCase(TpUtils.info_email);
        inputUserName(userName);
    }

    public static void changeCasePassword() {
        String pass = TpUtils.reverseCase(TpUtils.info_password);
        inputLoginPassword(pass);
    }

    public static void clickBtnSignOut() {
        click(MyAccountPageConstants.BTN_SIGNOUT_XPATH);
    }

    public static void clickBtnMyAccount() {
        click(MyAccountPageConstants.BTN_MY_ACCOUNT_XPATH);
    }

    public static void clickBtnAccountDetails() {
        click(MyAccountPageConstants.BTN_ACCOUNT_DETAILS_XPATH);
    }

}
