package com.ironhack.dao;

import com.ironhack.data.DatabaseManager;
import com.ironhack.enums.Product;
import com.ironhack.enums.Status;


public class Opportunity {
    private int id;
    private Product product;
    private int quantity;
    private Contact contact;
    private Status status;

    //Constructor
    public Opportunity(int product, int quantity, Contact contact) {
        setId(DatabaseManager.findLastOpportunityId());
        setProduct(product);
        setQuantity(quantity);
        setContact(contact);
        this.status = Status.OPEN;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(int product) {
        if(product == 1) this.product = Product.HYBRID;
        if(product == 2) this.product = Product.FLATBED;
        if(product == 3) this.product = Product.BOX;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //Methods
    public void opportunityLost(){
    setStatus(Status.CLOSED_LOST);
    }

    public void opportunityWon(){
        setStatus(Status.CLOSED_WON);
    }

    @Override
    public String toString() {
        return "Opportunity{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", contact=" + contact +
                ", status=" + status +
                '}';
    }
}
