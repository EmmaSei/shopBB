package ru.sfedu.shop.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.simpleframework.xml.*;

@Root
public class Order extends BaseDto{
    
    @Element
    private long customer;
    
    @Element
    private String number;
    
    @Element
    private long payment;
    
    @Element
    private long date;
    
    @Element (name = "status")
    private String statusOrder;
    
    @Element(name = "amount")
    private float amountOrder;
    
    @Element
    private long delivery;
    
    private String productsString="";
    
    @ElementMap
    private Map <Long,Integer> products = new HashMap<Long, Integer>();

    public Order() throws InterruptedException {
        super(ClassType.ORD);
    }

    public Order(long id, String number,long customer, long date, String statusOrder, long payment, float amountOrder, long delivery) throws InterruptedException {
        super(ClassType.ORD);
        setId(id);
        this.number=number;
        this.customer = customer;
        this.payment = payment;
        this.date = date;
        this.statusOrder = statusOrder;
        this.amountOrder = amountOrder;
        this.delivery=delivery;
    }


    public long getCustomer() {
        return customer;
    }

    public void setCustomer(long customer) {
        this.customer = customer;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    } 

    public long getPayment() {
        return payment;
    }

    public void setPayment(long payment) {
        this.payment = payment;
    }

    public float getAmountOrder() {
        return amountOrder;
    }

    public void setAmountOrder(float amountOrder) {
        this.amountOrder = amountOrder;
    }

    @Override
    public String toString() {
        return getId() + ";" + customer + ";" + payment + ";" + date + ";" + statusOrder + ";" + payment + ";" + amountOrder;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (getId() != other.getId()) {
            return false;
        }
        return true;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getDelivery() {
        return delivery;
    }

    public void setDelivery(long delivery) {
        this.delivery = delivery;
    }

    private void buildProductsString(){
        String valuesString="";
        for (Map.Entry<Long, Integer> entry : products.entrySet()) {
            Long key = entry.getKey();
            Integer value = entry.getValue();
            valuesString+=key+"="+value+"?";
            this.productsString=valuesString;
        }
    }
    
    public String getProductsString() {
        return productsString;
    }

    public void setProductsString(String productsString) {
        this.productsString = productsString;
    }
    
    public Map<Long,Integer> getProducts() {
        parseProductsString();
        buildProductsString();
        return products;
    }

    public void setProducts(Map<Long, Integer> produts) {
        this.products = produts;
        buildProductsString();
    }
    
    private void parseProductsString(){
        String[] objectsString;
        objectsString=divide(this.productsString, '?');
        for (int i = 0; i < objectsString.length; i++) {
            String[] obj=divide(objectsString[i], '=');
            this.products.put(Long.parseLong(obj[0]), Integer.parseInt(obj[1]));
        }
    }
    
    private String[] divide(String s, char separator) {
        ArrayList<String> tmp = new ArrayList<String>();
        int i = 0;
        boolean f = false;

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == separator) {
                if (j > i) {
                    tmp.add(s.substring(i, j));
                }
                i = j + 1;
            }
        }
        if (i < s.length()) {
            tmp.add(s.substring(i));
        }
        return tmp.toArray(new String[tmp.size()]);
    }

    @Override
    public String getValueByFieldName(String name) throws Exception{
        String value;
        switch(name){
            case "id" : value = Long.toString(getId()); break;
            case "customer"  : value = Long.toString(customer); break;
            case "number"  : value = number; break;
            case "payment"  : value = Long.toString(payment); break;
            case "date"  : value = Long.toString(date); break;
            case "status"  : value = statusOrder; break;
            case "amount"  : value = Float.toString(amountOrder); break;
            case "delivery"  : value = Long.toString(delivery); break;
            default : throw new Exception("field is not right");
        }
        return value;
    } 
}
