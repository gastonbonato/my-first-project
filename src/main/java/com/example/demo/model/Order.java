package com.example.demo.model;
import java.util.ArrayList;

public class Order {

    /*Atributes*/
    private int id;
    private ArrayList<Items> itemsList = new ArrayList<Items>();

    /*Constructor*/
    public Order(int id,ArrayList<Items> itemsList  ){
        this.id = id;
        this.itemsList = itemsList;
    }

    public Order(int id){
        this.id = id;
    }

    public Order(){
        //default constructor
    }


    /*Methods*/
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public ArrayList<Items> getItemsList(){
        return itemsList;
    }

    public void setItemsList(ArrayList<Items> itemsList){
        this.itemsList = itemsList;
    }

    public String toString(){
        String aux = "";
        aux += "Id Order:" + id + " Items: ";

        for(Items counter: itemsList) {
            aux += "Id: "+ counter.getId() + " ";
            aux += "Name: " + counter.getName() + " ";
        }

        return aux;
    }







}
