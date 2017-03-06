package ru.sfedu.shop.dto;

import org.simpleframework.xml.*;

@Root(name="Payment")
public class Payment extends BaseDto{
    @Element(name="paymentMethod")
    private String paymentMethod;
    
    @Element(name="date")
    private long dateReceived;
    
    @Element
    private float amountReceived;

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
    public String getValueByFieldName(String name) throws Exception{
        String value;
        switch(name){
            case "id" : value = Long.toString(getId()); break;
            case "paymentMethod"  : value = paymentMethod; break;
            case "dateReceived"  : value = Long.toString(dateReceived); break;
            case "amountReceived"  : value = Float.toString(amountReceived); break;
            default : throw new Exception("field is not right");
        }
        return value;
    }    
}
