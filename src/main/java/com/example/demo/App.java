package com.example.demo;

import com.example.demo.model.Client;
import com.example.demo.model.Items;
import com.example.demo.model.Order;
import com.example.demo.model.Payment;
import com.example.demo.services.ClientService;
import com.example.demo.services.ItemServices;
import com.example.demo.services.OrderService;
import com.example.demo.services.PaymentService;

import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {
        Items item1 = new Items(335, "Monitor");
        Items item2 = new Items(336, "Parlante");
        Items item3 = new Items(337, "Monitor HD");

        ArrayList<Items> list2 = new ArrayList<Items>();
        list2.add(item1);
        list2.add(item2);
        //Order  creation
        Order order = new Order(1115,list2);
        Order order2 = new Order(1116);
        Order order3 = new Order(1116, list2);


        ArrayList<Order> list3 = new ArrayList<Order>();
        list3.add(order);
        //Payment creation
        Payment pay1 = new Payment(8888, 5000, list3);
        Payment pay2 = new Payment(8888, 5050, list3);


        ArrayList<Payment> list = new ArrayList<Payment>();
        list.add(pay1);
        //Client creation
        Client c1 = new Client(13, "Gaston", "Bonato","Noob developer",list);
        Client c2= new Client(15, "Fabian", "Bonato","Pro developer");


        PaymentService ps1 = new PaymentService();

        ps1.create(pay1);
        ps1.update(pay2);


        System.out.println(ps1.read(8888));



    }

}
