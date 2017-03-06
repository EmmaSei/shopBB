package ru.sfedu.shop.dto;

import static ru.sfedu.shop.Const.*;

public enum ClassType {

    
    CUS(COLUMNS_CUS, Customer.class),
    ORD(COLUMNS_ORD, Order.class),
    PAY(COLUMNS_PAY, Payment.class),
    PRD(COLUMNS_PRD, Product.class),
    DLV(COLUMNS_DLV, Delivery.class);
    
    
    private String[] description;
    private Class cl;

    private ClassType() {
    }
    
    private ClassType(String[] description, Class cl) { 
        this.description = description; 
        this.cl = cl;
    } 

    @Override
    public String toString() {
        return super.toString();
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public Class getCl() {
        return cl;
    }

    public void setCl(Class cl) {
        this.cl = cl;
    }

  
}
