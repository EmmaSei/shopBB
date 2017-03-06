package ru.sfedu.shop.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Customer extends BaseDto{
    @Element
    private String name;
    
    @Element
    private String address;
    
    @Element
    private String phone;
    
    @Element
    private String email;
    
    @Element
    private int countOrder=0;
    
    @Element
    private boolean admin=false;

    public Customer() throws InterruptedException {
        super(ClassType.CUS);
    }

    public Customer(long id, String name, String address, String phone, String email, boolean admin) throws InterruptedException {
        super(ClassType.CUS);
        setId(id);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.admin = admin;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
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
  
    @Override
    public String getValueByFieldName(String name) throws Exception{
        String value;
        switch(name){
            case "id" : value = Long.toString(getId()); break;
            case "name"  : value = name; break;
            case "address"  : value = address; break;
            case "phone"  : value = phone; break;
            case "email"  : value = email; break;
            case "countOrder"  : value = Float.toString(countOrder); break;
            case "admin"  : value = Boolean.toString(admin); break;
            default : throw new Exception("field is not right");
        }
        return value;
    }    
}
