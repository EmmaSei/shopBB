package ru.sfedu.shop.dto;

public class Customer extends BaseDto{
    
    private String name;
    private String address;
    private String phone;
    private String email;
    private int countOrder=0;

    public Customer() throws InterruptedException {
        super(ClassType.CUS);
    }

    public Customer(long id, String name, String address, String phone, String email) throws InterruptedException {
        super(ClassType.CUS);
        setId(id);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return getId() + ";" + name + ";" + address + ";" + phone + ";" + email;
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
        final Customer other = (Customer) obj;
        if (getId() != other.getId()) {
            return false;
        }
        return true;
    }

    public int getCountOrder() {
        return countOrder;
    }

    public void setCountOrder(int countOrder) {
        this.countOrder = countOrder;
    }
    
}
