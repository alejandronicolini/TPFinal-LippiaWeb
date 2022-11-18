package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lippia.web.services.ShopPageService;
import lippia.web.services.ShopPageTestService;

public class Steps_Section4_Shop extends PageSteps {


    @And("Click on the Add To Basket button which adds that book to your basket")
    public void clickOnTheAddToBasketButton() {
        ShopPageService.clickBtnAddTobasket();
        ShopPageService.bookAttribute();
    }

    @And("User can view that Book in the Menu item with price")
    public void userCanViewThatBookInTheMenuItemWithPrice() {
        ShopPageTestService.verifyCartAmount();
    }

    @And("Now click on Item link which navigates to proceed to check out page.")
    public void clickOnItemLinkToProceedToCheckOut() {
        ShopPageService.clickOnLinkCart();
    }

    @And("Now user can find total and subtotal values just above the Proceed to Checkout button.")
    public void valuesInCheckoutPage() {
        ShopPageTestService.verifyPriceCheckOutPage();
    }

    @And("The total always < subtotal because taxes are added in the subtotal")
    public void taxesAddedInTheSubtotal() {
        ShopPageTestService.verifyTotalAndSubtotalPrice();
    }

    @And("Now click on Proceed to Check out button which navigates to payment gateway page.")
    public void clickOnProceedToCheckOutButton() {
        ShopPageService.clickBtnCheckOut();
        ShopPageTestService.verifyUrlPaymentPage();
    }

    @Then("User can view Billing Details,Order Details,Additional details and Payment gateway details.")
    public void userViewCheckOutDetails() {
        ShopPageTestService.verifyViewTableDetails();
    }

    @And("Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.")
    public void fillDataCheckOut() {
        ShopPageService.fillCheckOutProcess();
    }

    @And("Now click on Place Order button to complete process")
    public void clickOnPlaceOrderButton() {
        ShopPageService.clickBtnPlaceOrder();
    }

    @And("Go to Order confirmation page with order details,bank details,customer details and billing details")
    public void verifyInfoConfirmationPage() {
        ShopPageTestService.verifyDataOrderConfirmation();
    }

    @Then("Tax rate for indian should be {int}% and for abroad it should be {int}%")
    public void taxRateForIndianShouldBeAndForAbroadItShouldBe(int taxIndia, int taxOther) {
        ShopPageTestService.verifyTaxForCountry(taxIndia,taxOther);
    }

}
