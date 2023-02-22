package com.techelevator;

import java.math.BigDecimal;

public class Item {
private String location;
private String name;
private BigDecimal price;
private String type;
private int amountLeft = 5;



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmountLeft() {
        return amountLeft;
    }

    public void purchaseOneItem() {
        amountLeft -= 1;
    }
}
