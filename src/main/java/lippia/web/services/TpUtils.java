package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.HomePageConstants;
import lippia.web.constants.MyAccountPageConstants;
import org.testng.Assert;

import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class TpUtils extends ActionManager {

    public static String info_email; //variable invocada posteriormente
    public static String info_password; //variable invocada posteriormente

    public static void navegarWebTesting() {
        String URL = DriverManager.getDriverInstance().getCurrentUrl();
        boolean URLHome = URL.matches("https://practice.automationtesting.in/");
        if (!URLHome) {
            navigateTo(PropertyManager.getProperty("web.base.url"));
        }
    }

    public static void cambiarVentana() {
        String testPage = DriverManager.getDriverInstance().getWindowHandle();
        sleep(1000);
        DriverManager.getDriverInstance().switchTo().window(testPage);
    }

    public static void createUser() {
        info_email = "cursoCrowdar22_v" + randomNum() + "@gmail.com";
        info_password = "cursoCrowdarPass_" + randomNum();

        navigateTo("https://practice.automationtesting.in/my-account/");
        MyAccountPageService.inputEmail(info_email);
        MyAccountPageService.inputRegPassword(info_password);
        MyAccountPageService.clickAuxiliar();
        MyAccountPageService.clickBtnRegister();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyAccountPageService.clicBtnLogout();

        click(MyAccountPageConstants.BTN_HOMEMENU_XPATH);
    }

    public static int randomNum() {
        double random = Math.random();
        int num = (int) (Math.random() * (1000));
        return num;
    }

    public static void hacerLogin() {
        click(HomePageConstants.BTN_MY_ACCOUNT_XPATH);
        setInput(MyAccountPageConstants.INPUT_USER_NAME_ID, info_email);
        setInput(MyAccountPageConstants.INPUT_LOGIN_PASSWORD_ID, info_password,true, false);
        click(waitClickable(MyAccountPageConstants.BTN_LOGIN_XPATH));
    }

    public static void signOutUser() {
        navigateTo("https://practice.automationtesting.in/my-account/");
        click(MyAccountPageConstants.BTN_SIGNOUT_XPATH);
        click(MyAccountPageConstants.BTN_HOMEMENU_XPATH);
    }

    public static void goBackPage() {
        DriverManager.getDriverInstance().navigate().back();
    }

    public static void verifyCurrentUrl(String urlEsperada) {
        String currentURL = DriverManager.getDriverInstance().getCurrentUrl();
        Assert.assertEquals(urlEsperada, currentURL);
    }

    public static void sleep(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String reverseCase(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray())
            sb.append(Character.isUpperCase(c) ?
                    Character.toLowerCase(c) :
                    Character.toUpperCase(c));
        return sb.toString();
    }

    public static float getPrecioSinMoneda(String precio) {
        return Float.parseFloat(precio.substring(1));
    }


}
