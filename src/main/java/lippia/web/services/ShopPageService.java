package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.BasketPageConstants;
import lippia.web.constants.CheckOutPageConstants;
import lippia.web.constants.ShopPageConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;


public class ShopPageService extends WebActionManager {


    public static void clickBtnHomeMenu() {
        click(ShopPageConstants.BTN_HOMEMENU_XPATH);
    }

    private static WebElement btnLibro;
    public static void clickBtnAddTobasket() {
        List<WebElement> listaBtnAdd = getElements(ShopPageConstants.LIST_BTN_ADD_TO_BASKET_XPATH);
        btnLibro = listaBtnAdd.get(3);
        click(btnLibro);
    }

    public static String locatorPrecioLibro; //variable invocada posteriormente
    public static void bookAttribute() {
        String attrProductId = btnLibro.getAttribute("data-product_id");
        locatorPrecioLibro = ShopPageConstants.BOOK_PRICE_XPATH.replace("xxx", attrProductId);
    }

    public static void clickOnLinkCart() {
        click(ShopPageConstants.BTN_CART_XPATH);
    }

    public static void clickBtnCheckOut() {
        click(BasketPageConstants.BTN_CHECKOUT_XPATH);
    }

    public static void clickBtnPlaceOrder() {
        TpUtils.sleep(2000);
        click(CheckOutPageConstants.BTN_PLACE_ORDER_ID);
    }

    public static String metodoDePago; //variable invocada posteriormente
    public static String priceTotalByCountry;
    public static void fillCheckOutProcess() {
        TpUtils.sleep(1000);
        SoftAssert assertSoft = new SoftAssert();
        assertSoft.assertTrue(isPresent(CheckOutPageConstants.TITLE_BANK_XPATH));
        assertSoft.assertTrue(isPresent(CheckOutPageConstants.TITLE_CHECK_XPATH));
        assertSoft.assertTrue(isPresent(CheckOutPageConstants.TITLE_CASH_XPATH));
        assertSoft.assertTrue(isPresent(CheckOutPageConstants.TITLE_PAYPAL_XPATH));
        assertSoft.assertAll();

        setInput(CheckOutPageConstants.INPUT_NAME_ID, "Curso");
        setInput(CheckOutPageConstants.INPUT_LASTNAME_ID, "Crowdar2022");
        setInput(CheckOutPageConstants.INPUT_EMAIL_ID, "crowdartesting@gmail.com");
        setInput(CheckOutPageConstants.INPUT_PHONE_ID, "5402235112233");
        setInput(CheckOutPageConstants.INPUT_PAIS_ID, "Argentina");
        click(CheckOutPageConstants.SELECT_PAIS_XPATH);
        setInput(CheckOutPageConstants.INPUT_ADDRESS_ID, "Av.Constitucion 1050");
        setInput(CheckOutPageConstants.INPUT_CITY_ID, "Mar del Plata");
        setInput(CheckOutPageConstants.INPUT_POSTCODE_ID, "7600");

        WebElement estate = getElement(CheckOutPageConstants.DROPDOWN_STATE_XPATH);
        new Actions(DriverManager.getDriverInstance()).moveToElement(estate).click().build().perform();
        click(CheckOutPageConstants.SELECT_STATE_XPATH);

        List<String> listFormasDePago = new ArrayList<>();
        listFormasDePago.add("Direct Bank Transfer");
        listFormasDePago.add("Check Payments");
        listFormasDePago.add("Cash on Delivery");
        listFormasDePago.add("PayPal Express Checkout");

        int n = (int) (Math.random() * (4 - 1)) + 1;
        metodoDePago = listFormasDePago.get(n-1);
        String locMetodo;
        switch (n-1) {
            case 0:
                locMetodo = CheckOutPageConstants.BTN_TRANSFERENCIA_XPATH;
                break;
            case 1:
                locMetodo = CheckOutPageConstants.BTN_CHEQUE_XPATH;
                break;
            case 2:
                locMetodo = CheckOutPageConstants.BTN_CASH_XPATH;
                break;
            case 3:
                locMetodo = CheckOutPageConstants.BTN_PAYPAL_XPATH;
            default:
                locMetodo = CheckOutPageConstants.BTN_CHEQUE_XPATH;
        }

        TpUtils.sleep(1500);
        click(locMetodo);
        priceTotalByCountry = getText(CheckOutPageConstants.TOTAL_XPATH);

    }


}
