package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.ProductPageConstants;
import org.testng.Assert;


public class ProductPageTestService extends ActionManager {

    public static void TestResultPageProductAndBtnAddToCart() {
        String URL = DriverManager.getDriverInstance().getCurrentUrl();
        boolean  URLproductos= URL.matches("https://practice.automationtesting.in/product/(.*)");
        Assert.assertTrue(URLproductos);
        System.out.println("url recibida: " + URL);
        Assert.assertTrue(isPresent(ProductPageConstants.BTN_ADD_TO_BASKET));
    }

    public static void verifyBookAndPrice() {
        //doble verificacion: Cantidad y Precio
        String strCartContent = getText(ProductPageConstants.SPAN_CARTCONTENT_XPATH);
        String [] arregloCartContent = strCartContent.split(" ");
        int itemInCartContent = Integer.parseInt(arregloCartContent[0]);
        System.out.println("numero Item: "+itemInCartContent);
        Assert.assertEquals(1,itemInCartContent);

        ShopPageTestService.montoCarrito = getText(ProductPageConstants.SPAN_AMOUNT_XPATH);
        String precioCarrito = ShopPageTestService.montoCarrito.substring(1);
        String spanPrecioLibro = getText(ProductPageConstants.SPAN_BOOK_PRICE_XPATH);
        String precioLibro = spanPrecioLibro.substring(1);

        Assert.assertEquals(precioLibro, precioCarrito);

    }

}