package ru.sfedu.shop.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Payment extends BaseDto{
    private String paymentMethod;
    private long dateReceived;
    private float amountReceived;
    private String productsString="";
    private Map <Long,Integer> products = new HashMap<Long, Integer>();

    public Payment() throws InterruptedException {
        super(ClassType.PAY);
    }

    public Payment(long id, String paymentMethod, long dateReceived, float amountReceived) throws InterruptedException {
        super(ClassType.PAY);
        setId(id);
        this.paymentMethod = paymentMethod;
        this.dateReceived = dateReceived;
        this.amountReceived = amountReceived;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public long getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(long dateReceived) {
        this.dateReceived = dateReceived;
    }

    public float getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(float amountReceived) {
        this.amountReceived = amountReceived;
    }

    @Override
    public String toString() {
        return getId() + ";" + paymentMethod + ";" + dateReceived + ";" + amountReceived;
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
        final Payment other = (Payment) obj;
        if (getId() != other.getId()) {
            return false;
        }
        return true;
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
}
