package lippia.web.constants;

public class CheckOutPageConstants {

    public static  final String TABLE_BILLING_XPATH = "xpath://div[@class='woocommerce-billing-fields']";
    public static  final String TABLE_ADDITIONAL_INFO_XPATH = "xpath://div[@class='woocommerce-shipping-fields']";
    public static  final String TABLE_ORDER_XPATH = "xpath://table[@class='shop_table woocommerce-checkout-review-order-table']";
    public static  final String TABLE_PAYMENT_ID = "id:payment";

    public static  final String SUBTOTAL_XPATH = "xpath://tr[@class='cart-subtotal']//span[@class='woocommerce-Price-amount amount']";
    public static  final String TOTAL_XPATH = "xpath://*[@class='order-total']//span[@class='woocommerce-Price-amount amount']";
    public static  final String TAX_XPATH = "xpath://*[@class=\"tax-rate tax-rate-roaming-tax-1\"]/td/*[@class='woocommerce-Price-amount amount']";

    public static  final String INPUT_NAME_ID = "id:billing_first_name";
    public static  final String INPUT_LASTNAME_ID = "id:billing_last_name";
    public static  final String INPUT_EMAIL_ID = "id:billing_email";
    public static  final String INPUT_PHONE_ID = "id:billing_phone";

    public static  final String INPUT_PAIS_ID = "id:s2id_autogen1";
    public static  final String SELECT_PAIS_XPATH = "xpath://*[@id='select2-results-1']/li[1]";
    public static  final String DROPDOWN_STATE_XPATH = "xpath://div[@class='select2-container state_select']";
    public static  final String SELECT_STATE_XPATH = "xpath://*[@class='select2-results']/li[1]";

    public static  final String INPUT_ADDRESS_ID = "id:billing_address_1";
    public static  final String INPUT_CITY_ID = "id:billing_city";
    public static  final String INPUT_POSTCODE_ID = "id:billing_postcode";
    public static  final String BTN_TRANSFERENCIA_XPATH = "xpath://input[@id='payment_method_bacs']";
    public static  final String BTN_CHEQUE_XPATH = "xpath://input[@id='payment_method_cheque']";
    public static  final String BTN_CASH_XPATH = "xpath://input[@id='payment_method_cod']";
    public static  final String BTN_PAYPAL_XPATH = "xpath://input[@id='payment_method_ppec_paypal']";

    public static  final String BTN_PLACE_ORDER_ID ="xpath://input[@id='place_order']";

    public static  final String TITLE_BANK_XPATH = "xpath://label[contains(.,'Direct Bank Transfer')]";
    public static  final String TITLE_CHECK_XPATH = "xpath://label[contains(.,'Check Payments')]";
    public static  final String TITLE_CASH_XPATH = "xpath://label[contains(.,'Cash on Delivery')]";
    public static  final String TITLE_PAYPAL_XPATH = "xpath://label[contains(.,'PayPal Express Checkout')]";

    public static  final String LINK_COUPON_XPATH = "xpath://a[.='Click here to enter your code']";
    public static  final String BTN_COUPON_XPATH = "xpath://input[@name='apply_coupon']";
    public static  final String INPUT_COUPON_XPATH = "xpath://input[@id='coupon_code']";

}
