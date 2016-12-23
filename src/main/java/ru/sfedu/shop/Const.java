package ru.sfedu.shop;

/**
 *
 * @author Эмма
 */
public class Const {
    public static final String CUSTOMER_FILE_NAME="customer.csv"; 
    public static final String ORDER_FILE_NAME="order.csv"; 
    public static final String PAYMENT_FILE_NAME="payment.csv"; 
    public static final String PRODUCT_FILE_NAME="product.csv"; 
    public static final String DELIVERY_FILE_NAME="delivery.csv"; 
    public static final String[] COLUMNS_CUS = new String[] {"id", "name", "address", "phone", "email", "countOrder"}; 
    public static final String[] COLUMNS_ORD = new String[] {"id", "customer", "number", "payment", "date", "statusOrder", "amountOrder", "delivery"};
    public static final String[] COLUMNS_PRD = new String[] {"id", "name", "price", "count"}; 
    public static final String[] COLUMNS_DLV = new String[] {"id", "method", "price"}; 
    public static final String[] COLUMNS_PAY = new String[] {"id", "paymentMethod", "dateReceived", "amountReceived", "productsString"}; 
}
