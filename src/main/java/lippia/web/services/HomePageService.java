package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.HomePageConstants;

public class HomePageService extends ActionManager {


    public static void clickBtnShopMenu() {
        click(HomePageConstants.BTN_SHOPMENU_XPATH);
    }

    public static void clickBtnMyAccountMenu() {
        click(HomePageConstants.BTN_MY_ACCOUNT_XPATH);
    }

    public static void clickFistImgArrivals() {
        click(HomePageConstants.DIV_FISRT_IMG_ARRIVAL_XPATH);
    }


}
