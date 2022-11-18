package lippia.web.constants;

public class OrderPageConstants {

    public static final String MESSAGE_XPATH = "xpath://p[@class='woocommerce-thankyou-order-received']";

    public static final String TITLE_PAYMENT_METHOD_XPATH = "xpath://*[@class='method']/strong";
    public static final String SUBTOTAL_XPATH = "xpath://*[@class=\"shop_table order_details\"]//tr[1]/td[1]/span";
    public static final String PAYMENT_METHOD_XPATH = "xpath://*[@class=\"shop_table order_details\"]//tr[3]/td";
    public static final String TOTAL_XPATH = "xpath://*[@class=\"shop_table order_details\"]//tr[4]/td/span";

}
