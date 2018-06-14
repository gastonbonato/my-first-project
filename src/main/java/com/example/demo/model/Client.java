package com.example.demo.model;

import java.util.ArrayList;

public class Client {
    /*Attributes*/

    private int id;
    private String name;
    private String lastName;
    private String description;
    private ArrayList<Payment> paymentList = new ArrayList<>();

    public Client(int id, String name, String lastName, String description, ArrayList<Payment> paymentList)
    {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        this.paymentList = paymentList;
    }

    public Client(int id, String name, String lastName, String description)
    {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.description = description;
    }

    public Client()
    {
        //default
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getDescription() {
        return this.description;
    }

    public ArrayList<Payment> getPaymentList() {
        return this.paymentList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPaymentList(ArrayList<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public String toString() {
        String aux = "";
        aux += "Id Client: " + id + " Name: " + name + " Lastname: " + lastName + " Description: " + description + " Payments: ";

        for (Payment counter : paymentList) {
            aux += paymentList.toString();
        }

        return aux;
    }
}
