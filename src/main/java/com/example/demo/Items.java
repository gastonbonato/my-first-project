package com.example.demo;

public class Items {

    /*Atributes*/
    private int id;
    private String name;

    /*Constructor*/
    public Items(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Items(){
        //default constructor
    }

    /*Methods*/
    public int getId() {
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

    public String toString(){
       return "Id: " +  id + " Name: " + name;
    }



}
