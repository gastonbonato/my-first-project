package com.example.demo;

import java.util.ArrayList;

public class Client {
    /*Attributes*/

    private int id;
    private String name;
    private String lastName;
    private String description;
    private ArrayList<Payment> paymentList = new ArrayList<Payment>();

    /*Constructor*/
    public Client(int id, String name, String lastName, String description){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.description = description;
    }

    public Client(){
        //default constructor
    }

    /*Methods*/
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void addPayments( Payment p ){
        this.paymentList.add(p);
    }

    public ArrayList<Payment> getPaymentList(){
        return paymentList;
    }

    public void setPaymentList(ArrayList<Payment> paymentList){
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
