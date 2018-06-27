package com.example.demo.model;
import java.util.ArrayList;

public class Order {

    /*Atributes*/
    private int id;
    private String name;
    private ArrayList<Item> itemList = new ArrayList<Item>();

    /*Constructor*/
    public Order(int id,String name, ArrayList<Item> itemList){
        this.id = id;
        this.name = name;
        this.itemList = itemList;
    }

    public Order(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Order(String name){
        //default constructor
        this.name = name;

    }


    /*Methods*/
    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public ArrayList<Item> getItemList(){
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList){
        this.itemList = itemList;
    }

    public String toString(){
        String aux = "";
        aux += "Id Order:" + this.id + " Name: " + this.name + " Items: " ;

        for(Item counter: itemList) {
            aux += "Id: "+ counter.getId() + " ";
            aux += "Name: " + counter.getName() + " ";
        }

        return aux;
    }







}
