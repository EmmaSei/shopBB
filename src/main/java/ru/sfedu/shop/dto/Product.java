package ru.sfedu.shop.dto;



public class Product extends BaseDto{
    private String name;
    private float price;
    private int count;

    public Product() throws InterruptedException {
        super(ClassType.PRD);
    }

    public Product(long id, String name, float price, int count) throws InterruptedException {
        super(ClassType.PRD);
        setId(id);
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "id - "+ getId() + "; name - " + name + "; price - " + price + "; amount - " + count;
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
        final Product other = (Product) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        return true;
    }
    
}
