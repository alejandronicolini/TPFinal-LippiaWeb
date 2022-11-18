package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lippia.web.services.*;

public class Steps_Section1_HomePage extends PageSteps {


    @And("click on Home menu button")
    public void clickOnHomeMenuButton() {
        ShopPageService.clickBtnHomeMenu();
    }

    @Then("the Home page has Three Arrivals only")
    public void theHomePageHasThreeArrivalsOnly() {
        HomePageTestService.TestResultArrivalsInHomePage();
    }

    @And("click the image in the Arrivals")
    public void clicFistImageInTheArrivals() {
        HomePageService.clickFistImgArrivals();
    }

    @And("navigating to next page where the user can add that book into his basket")
    public void navigatingToProductPageAndViewBtnAddToCart() {
        ProductPageTestService.TestResultPageProductAndBtnAddToCart();
    }

    @And("click on the Add To Basket button which adds that book to your basket")
    public void clickOnTheAddToBasketButton() {
        ProductPageService.clickOnBtnAddToBasket();
    }

    @And("the user can view that Book in the Menu item with price.")
    public void verifyBookInTheMenuItemWithPrice() {
        ProductPageTestService.verifyBookAndPrice();
    }

    @Then("User has the feasibility to add coupon in the payment gateway page and also he can find billing,order and additional details.")
    public void verifyCouponFuncionality() {
        ShopPageTestService.verifyCoupon();
    }

}
