package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.MyAccountPageConstants;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class MyAccountTestService extends ActionManager {


    public static void registroFallido(String mensaje) {
        String respuestaMensaje = getText(MyAccountPageConstants.DIV_TEXT_ERRORMESSAGE_XPATH);
        System.out.println("mensaje " +  respuestaMensaje);
        Assert.assertEquals(mensaje, respuestaMensaje);
    }

    public static void verifyLoginFail2(String mensaje) {
        String respuestaMensaje = getText(MyAccountPageConstants.DIV_TEXT_ERRORMESSAGE_XPATH);
        String mensajeEsperado = mensaje.replace("*my_username", MyAccountPageService.userName);
        Assert.assertTrue(respuestaMensaje.contains(mensajeEsperado));
    }

    public static void verifyLogIn() {
        Assert.assertTrue(isPresent(MyAccountPageConstants.BTN_LOGOUT_XPATH), "error de login");
    }

    public static void verifyViewLoginPage() {
        SoftAssert assertSoft = new SoftAssert();
        assertSoft.assertTrue(isPresent(MyAccountPageConstants.BTN_LOGIN_XPATH),"Btn Login no se encuentra");
        assertSoft.assertTrue(isPresent(MyAccountPageConstants.BTN_REGISTER_XPATH),"Btn Register no se encuentra");
        assertSoft.assertAll();
    }

    public static void verifyAccountDetailsAndChangePass() {
        TpUtils.verifyCurrentUrl("https://practice.automationtesting.in/my-account/edit-account/");
        String name = "Curso 2022_v" +TpUtils.randomNum();
        setInput(MyAccountPageConstants.FIRST_NAME, name);
        String last_name = "Crowdar_v" +TpUtils.randomNum();
        setInput(MyAccountPageConstants.LAST_NAME, last_name);

        String emailInEditPage= getElement(MyAccountPageConstants.EMAIL_REGISTRADO).getAttribute("value");
        Assert.assertEquals(emailInEditPage, TpUtils.info_email);

        setInput(MyAccountPageConstants.INPUT_CURRENT_PASSWORD_ID, TpUtils.info_password);
        String new_pass = TpUtils.info_password +TpUtils.randomNum();
        setInput(MyAccountPageConstants.INPUT_NEW_PASSWORD_ID, new_pass);
        setInput(MyAccountPageConstants.INPUT_CONFIRM_PASSWORD_ID, new_pass);
        click(MyAccountPageConstants.BTN_SAVE_XPATH);

        String mensajeRecibido= getText(MyAccountPageConstants.TEXT_MESSAGE_XPATH);
        String mensajeEsperado = "Account details changed successfully.";
        Assert.assertTrue(mensajeRecibido.contains(mensajeEsperado), "Error en el cambio de clave");

    }

}