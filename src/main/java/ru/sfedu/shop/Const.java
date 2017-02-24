package ru.sfedu.shop;

/**
 *
 * @author Эмма
 */
public class Const {
    public static final String GLOBAL_PROP = "ru.sfedu.shop.prop";
    public static final String PATH_CSV_STORE = "ru.sfedu.path.csv_store";
    public static final String PATH_XML_STORE = "ru.sfedu.path.xml_store";
    public static final String[] COLUMNS_CUS = new String[] {"id", "name", "address", "phone", "email", "countOrder", "admin"}; 
    public static final String[] COLUMNS_ORD = new String[] {"id", "customer", "number", "payment", "date", "statusOrder", "amountOrder", "delivery", "productsString"};
    public static final String[] COLUMNS_PRD = new String[] {"id", "name", "price", "count"}; 
    public static final String[] COLUMNS_DLV = new String[] {"id", "method", "price"}; 
    public static final String[] COLUMNS_PAY = new String[] {"id", "paymentMethod", "dateReceived", "amountReceived"}; 
}
