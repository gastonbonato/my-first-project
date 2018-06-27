package com.example.demo.model;
import java.util.ArrayList;

public class Payment {

    /*Attributes*/
    private int id;
    private ArrayList<Order> orderList = new ArrayList<>();
    private double amount;

    /*Constructor*/
    public Payment(int id, double amount, ArrayList<Order> orderList  ){
        this.id = id;
        this.amount = amount;
        this.orderList = orderList;
    }

    public Payment(int id, double amount ){
        this.id = id;
        this.amount = amount;
    }

    public Payment(double amount){
        //default constructor
        this.amount = amount;
    }

    /*Methods*/
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public ArrayList<Order> getOrderList(){
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList ){
        this.orderList = orderList;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public String toString(){
        String aux = "";
        aux += "Id Payment: " + id + " Amount: " + amount + " Order: ";

        for(Order counter: orderList){
            aux += counter.toString();
        }

        return aux;
    }

}
