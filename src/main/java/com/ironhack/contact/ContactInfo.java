package com.ironhack.contact;

import java.util.Objects;

public abstract class ContactInfo {
    private static int idCounter = 1;
    private int id = idCounter;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    public ContactInfo(String name, String phoneNumber, String email, String companyName) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
        setId(id);
        idCounter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInfo that = (ContactInfo) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(email, that.email) && Objects.equals(companyName, that.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, email, companyName);
    }
}
