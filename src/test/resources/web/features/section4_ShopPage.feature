@FeatureShop @Smoke
Feature: Section Shop

  Background:
    Given the user is on the home page of practice.automationtesting.in
    And clic on Shop Menu
    And Click on the Add To Basket button which adds that book to your basket
    And User can view that Book in the Menu item with price
    When Now click on Item link which navigates to proceed to check out page.
    And Now user can find total and subtotal values just above the Proceed to Checkout button.
    And The total always < subtotal because taxes are added in the subtotal
    And Now click on Proceed to Check out button which navigates to payment gateway page.


@ShopOrderConfirmation
  Scenario: 11.Shop-Add to Basket-View Basket through Item link
    Then User can view Billing Details,Order Details,Additional details and Payment gateway details.
    And Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
    And Now click on Place Order button to complete process
    And Go to Order confirmation page with order details,bank details,customer details and billing details


  @ShopTaxFunctionality
  Scenario: 12. Shop-Add to Basket-View Basket-Tax Functionality
    Then Tax rate for indian should be 2% and for abroad it should be 5%

