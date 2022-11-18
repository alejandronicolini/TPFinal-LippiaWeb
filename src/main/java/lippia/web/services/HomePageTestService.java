package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.HomePageConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class HomePageTestService extends ActionManager {


    public static void TestResultArrivalsInHomePage() {
        List<WebElement> listado =  getElementsByParent(HomePageConstants.DIV_ARRIVAL_XPATH,HomePageConstants.DIV_IMG_ARRIVAL_XPATH);
        System.out.println("Elementos encontrados: " + listado.size());
        Assert.assertEquals(3, listado.size());
    }

}