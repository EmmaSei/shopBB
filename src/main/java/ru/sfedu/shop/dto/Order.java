package ru.sfedu.shop.dto;

public class Order extends BaseDto{
    private long customer;
    private String number;
    private Payment payment;
    private long date;
    private String statusOrder;
    private float amountOrder;
    private long delivery;

    public Order() throws InterruptedException {
        super(ClassType.ORD);
    }

    public Order(long id, String number,long customer, long date, String statusOrder, Payment payment, float amountOrder, long delivery) throws InterruptedException {
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
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

    
}
