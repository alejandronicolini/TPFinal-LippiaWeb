@FeatureHomePage @Smoke
Feature: Seccion Home Page

  Background:
    Given the user is on the home page of practice.automationtesting.in
    And clic on Shop Menu
    And click on Home menu button
    And the Home page has Three Arrivals only
    And click the image in the Arrivals
    And navigating to next page where the user can add that book into his basket
    And click on the Add To Basket button which adds that book to your basket
    And the user can view that Book in the Menu item with price.
    When Now click on Item link which navigates to proceed to check out page.
    And Now user can find total and subtotal values just above the Proceed to Checkout button.
    And The total always < subtotal because taxes are added in the subtotal
    And Now click on Proceed to Check out button which navigates to payment gateway page.


  @CheckOutAndAddCoupon
  Scenario: 17. Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway
    Then User can view Billing Details,Order Details,Additional details and Payment gateway details.
    And Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
    And User has the feasibility to add coupon in the payment gateway page and also he can find billing,order and additional details.


  @CheckOutOrdenConfirmation
  Scenario: 18. Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway-Place order
    Then User can view Billing Details,Order Details,Additional details and Payment gateway details.
    And Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
    And Now click on Place Order button to complete process
    And Go to Order confirmation page with order details,bank details,customer details and billing details
