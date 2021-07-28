package com.ironhack.opportunity;

import com.ironhack.contact.Contact;

public class Opportunity {
    private static int idCounter = 1;
    private int id = idCounter;
    private Product product;
    private int quantity;
    private Contact contact;
    private Status status;

    //Constructor
    public Opportunity(int id, Product product, int quantity, Contact contact) {
        setId(id);
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
        idCounter++;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
