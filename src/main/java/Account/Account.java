package Account;

import java.util.ArrayList;

//enum
enum Industry{
    PRODUCE,
    ECOMMERCE,
    MANUFACTURING,
    MEDICAL,
    OTHER
}

public class Account {
    int id;
    int employeeCount;
    String city;
    String Country;

//Constructor
    public Account(int id, int employeeCount, String city, String country) {
        this.id = id;
        this.employeeCount = employeeCount;
        this.city = city;
        Country = country;
    }
//Getter and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }


}

