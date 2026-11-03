package com.Mohamed.model;

public class Customer {

    private String firstName;
    private String lastName;
    private String phone;
    private int id;

    private String city;
    private String country;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String phone, int id, String city, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.id = id;
        this.city = city;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public int getId() {
        return id;
    }


    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                "}\n";
    }
}
