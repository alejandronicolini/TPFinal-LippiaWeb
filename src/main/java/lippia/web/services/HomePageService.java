package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.HomePageConstants;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageService extends ActionManager {


    public static void clickBtnShopMenu() {
        click(HomePageConstants.BTN_SHOPMENU_XPATH);
    }

    public static void clickBtnMyAccountMenu() {
        click(HomePageConstants.BTN_MY_ACCOUNT_XPATH);
    }

    public static void clickImgArrivalsWithStock() {
        List<WebElement> listaBtnAdd = getElements("xpath://a[text()='Add to basket']");
        WebElement btnPrimerLibro = listaBtnAdd.get(0);
        String attrProductId = btnPrimerLibro.getAttribute("data-product_id");
        String imgWithStock = HomePageConstants.IMG_ARRIVAL_STOCK_XPATH.replace("xxx", attrProductId);
        click(imgWithStock);
    }

}
