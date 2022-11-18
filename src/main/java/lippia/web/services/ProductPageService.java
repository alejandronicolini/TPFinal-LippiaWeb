package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.ProductPageConstants;


public class ProductPageService extends ActionManager {

    public static void clickOnBtnAddToBasket() {
        click(ProductPageConstants.BTN_ADD_TO_BASKET);
    }

}
