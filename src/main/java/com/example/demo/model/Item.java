package com.example.demo.model;

public class Item {

    /*Atributes*/
    private int id;
    private String name;

    /*Constructor*/
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(){
        //default constructor
    }

    /*Methods*/
    public int getId() {
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
       return "Id: " +  id + " Name: " + name;
    }



}
