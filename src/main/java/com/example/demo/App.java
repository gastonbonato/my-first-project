package com.example.demo;

public class App 
{
    public static void main( String[] args )
    {
        //Items creation
        Items item1 = new Items(335, "Monitor");
        Items item2 = new Items(336, "Parlante");
        //Order  creation
        Order order = new Order(1115);
        order.AddItem(item1);
        order.AddItem(item2);
        //Payment creation
        Payment pay1 = new Payment(8888, 5000);
        pay1.addOrder(order);
        //Client creation
        Client c1 = new Client(12, "Gaston", "Bonato","Noob developer");
        c1.addPayments(pay1);
        System.out.println(c1.toString());

    }

}
