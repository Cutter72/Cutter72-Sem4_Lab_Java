package model;

import java.util.Date;

public class Transaction {
    private Human seller;
    private Human buyer;
    private Double price;
    private Date date;

    public Human getSeller() {
        return seller;
    }

    public Transaction setSeller(Human seller) {
        this.seller = seller;
        return this;
    }

    public Human getBuyer() {
        return buyer;
    }

    public Transaction setBuyer(Human buyer) {
        this.buyer = buyer;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Transaction setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Transaction setDate(Date date) {
        this.date = date;
        return this;
    }
}
