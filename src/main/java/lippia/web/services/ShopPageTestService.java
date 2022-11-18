package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.BasketPageConstants;
import lippia.web.constants.CheckOutPageConstants;
import lippia.web.constants.OrderPageConstants;
import lippia.web.constants.ShopPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class ShopPageTestService extends WebActionManager {


    public static String montoCarrito;
    public static void verifyCartAmount() {
        TpUtils.sleep(1500);
        montoCarrito = getText(ShopPageConstants.CART_AMOUNT_XPATH);
        String precioLibro = getText(ShopPageService.locatorPrecioLibro);
        float fMontoCarrito = TpUtils.getPrecioSinMoneda(montoCarrito);
        float fPrecioLibro = TpUtils.getPrecioSinMoneda(precioLibro);

        Assert.assertEquals(fMontoCarrito, fPrecioLibro);
    }

    public static void verifyPriceCheckOutPage() {
        TpUtils.sleep(1500);
        TpUtils.verifyCurrentUrl("https://practice.automationtesting.in/basket/");
        Assert.assertTrue(isPresent(BasketPageConstants.TITLE_SUBTOTAL_PRICE_XPATH), "el titulo Subtotal, no se encuentra");
        Assert.assertTrue(isPresent(BasketPageConstants.TITLE_TOTAL_PRICE_XPATH), "el titulo Total, no se encuentra");
        String subTotalPrice = getText(BasketPageConstants.SUBTOTAL_PRICE_XPATH);
        float fMontoCarrito = TpUtils.getPrecioSinMoneda(montoCarrito);
        float fSubTotalPrice = TpUtils.getPrecioSinMoneda(subTotalPrice);

        Assert.assertEquals(fMontoCarrito, fSubTotalPrice);
    }

    private static String strSubTotalPrice;
    private static String strTotalPrice;
    public static void verifyTotalAndSubtotalPrice() {
        strSubTotalPrice = getText(BasketPageConstants.SUBTOTAL_PRICE_XPATH);
        strTotalPrice = getText(BasketPageConstants.TOTAL_PRICE_XPATH);
        float subTotalPrice = TpUtils.getPrecioSinMoneda(strSubTotalPrice);
        float totalPrice = TpUtils.getPrecioSinMoneda(strTotalPrice);

        Assert.assertTrue((totalPrice > subTotalPrice), "Error en precio total y subtotal");
    }

    public static void verifyUrlPaymentPage() {
        TpUtils.verifyCurrentUrl("https://practice.automationtesting.in/checkout/");
    }

    public static void verifyViewTableDetails() {
        TpUtils.sleep(1000);
        String subTotal = getText(CheckOutPageConstants.SUBTOTAL_XPATH);
        String total = getText(CheckOutPageConstants.TOTAL_XPATH);

        SoftAssert assertSoft = new SoftAssert();
        assertSoft.assertTrue(isPresent(CheckOutPageConstants.TABLE_BILLING_XPATH), "El formulario Billing Details no se encuentra");
        assertSoft.assertTrue(isPresent(CheckOutPageConstants.TABLE_ADDITIONAL_INFO_XPATH), "El formulario Additional Information no se encuentra");
        assertSoft.assertTrue(isPresent(CheckOutPageConstants.TABLE_ORDER_XPATH), "El formulario Your order no se encuentra");
        assertSoft.assertTrue(isPresent(CheckOutPageConstants.TABLE_PAYMENT_ID), "El formulario Metodo de Pago no se encuentra");
        assertSoft.assertEquals(subTotal, strSubTotalPrice);
        assertSoft.assertEquals(total, strTotalPrice);
        assertSoft.assertAll();
    }

    public static void verifyDataOrderConfirmation() {
        TpUtils.sleep(2000);
        String urlOrderConfirmation = DriverManager.getDriverInstance().getCurrentUrl();
        String messageConfirmation = getText(OrderPageConstants.MESSAGE_XPATH);
        Assert.assertTrue(messageConfirmation.contains("Thank you. Your order has been received."), "Error: mensaje de Orden Recibida");

        String payMethod = getText(OrderPageConstants.TITLE_PAYMENT_METHOD_XPATH);
        String subTotalPrice = getText(OrderPageConstants.SUBTOTAL_XPATH);
        String totalPrice = getText(OrderPageConstants.TOTAL_XPATH);
        String payMethodInTable = getText(OrderPageConstants.PAYMENT_METHOD_XPATH);

        SoftAssert assertSoft = new SoftAssert();
        assertSoft.assertEquals(subTotalPrice, strSubTotalPrice);
        assertSoft.assertEquals(totalPrice, ShopPageService.priceTotalByCountry);
        assertSoft.assertEquals(ShopPageService.metodoDePago, payMethodInTable);
        assertSoft.assertAll();
    }

    public static void verifyTaxForCountry(int taxIndia, int taxOther) {

        for (int i = 1; i < 250; i++) {
            TpUtils.sleep(500);
            WebElement hoverable = DriverManager.getDriverInstance().findElement(By.id("s2id_billing_country"));
            new Actions(DriverManager.getDriverInstance()).moveToElement(hoverable).click().build().perform();
            TpUtils.sleep(2000);
            String locatorPais = "xpath://*[@id='select2-results-1']/li[" + i + "]/div";
            String pais = getText(locatorPais);
            setInput("xpath://*[@id='s2id_autogen1_search']", pais);
            click("xpath://*[@id='select2-results-1']/li[1]");
            TpUtils.sleep(1000);
            String strSubTotal = getText(CheckOutPageConstants.SUBTOTAL_XPATH);
            String strTax = getText(CheckOutPageConstants.TAX_XPATH);
            String strTotal = getText(CheckOutPageConstants.TOTAL_XPATH);
            new Actions(DriverManager.getDriverInstance()).moveToElement(hoverable).perform();
            ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("window.scrollBy(0,250)");
            String mensaje = "Tax invalido del Pais:" + pais;
            Assert.assertTrue(verificarTotalAndTaxPorPais(pais, taxIndia, taxOther, strSubTotal, strTax, strTotal), mensaje);
        }

    }

    private static boolean verificarTotalAndTaxPorPais(String pais, int taxIndia, int taxOther, String subTotal, String tax, String total) {
        float fSubTotal = TpUtils.getPrecioSinMoneda(subTotal);
        float fTax = TpUtils.getPrecioSinMoneda(tax);
        float fTotal = TpUtils.getPrecioSinMoneda(total);
        float suma = fSubTotal + fTax;

        int tasa = Math.round(fTax / fSubTotal * 100);
        boolean validarTasa;
        if (pais.equals("India")) {
            validarTasa = (tasa == taxIndia);
        } else {
            validarTasa = (tasa == taxOther);
        }
        return ((suma == fTotal) && validarTasa);
    }

    public static void verifyCoupon() {
        TpUtils.sleep(1000);
        Assert.assertTrue(isPresent(CheckOutPageConstants.LINK_COUPON_XPATH), "el link al Cupon no esta habilitado");
        WebElement linkCupon = getElement(CheckOutPageConstants.LINK_COUPON_XPATH);
        new Actions(DriverManager.getDriverInstance()).moveToElement(linkCupon).click().build().perform();
        TpUtils.sleep(1500);
        Assert.assertTrue(isPresent(CheckOutPageConstants.BTN_COUPON_XPATH), "el Boton de Aplicar Cupon no se encuentra");
        Assert.assertTrue(isPresent(CheckOutPageConstants.INPUT_COUPON_XPATH), "el campo de ingreso del codigo de descuento no se encuentra");
    }

}