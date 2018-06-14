package com.example.demo.model;
import java.util.ArrayList;

public class Order {

    /*Atributes*/
    private int id;
    private ArrayList<Item> itemList = new ArrayList<Item>();

    /*Constructor*/
    public Order(int id,ArrayList<Item> itemList){
        this.id = id;
        this.itemList = itemList;
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

    public ArrayList<Item> getItemList(){
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList){
        this.itemList = itemList;
    }

    public String toString(){
        String aux = "";
        aux += "Id Order:" + id + " Items: ";

        for(Item counter: itemList) {
            aux += "Id: "+ counter.getId() + " ";
            aux += "Name: " + counter.getName() + " ";
        }

        return aux;
    }







}
