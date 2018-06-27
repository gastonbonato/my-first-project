package com.example.demo;

import com.example.demo.model.Client;
import com.example.demo.model.Item;
import com.example.demo.model.Order;
import com.example.demo.model.Payment;
import com.example.demo.services.ClientService;
import com.example.demo.services.ItemService;
import com.example.demo.services.OrderService;
import com.example.demo.services.PaymentService;
import com.example.demo.services.Service;

import java.util.ArrayList;

public class App {
    
    private static Service<Order> orderService = new OrderService();
    private static Service<Payment> paymentService = new PaymentService();
    private static Service<Client> clientService = new ClientService();
    private static Service<Item> itemService = new ItemService();
    
    
    public static void main( String[] args ) {
        
        //Agregar MENU


        Item item1 = new Item(335, "Monitor");
        Item item2 = new Item(336, "Parlante");

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(item1);
        items.add(item2);
        
        itemService.create(item1);
        itemService.create(item2);
        
        //Order  creation
        Order order = new Order("compra monitor");

        orderService.create(order);
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order);
        //Payment creation
        Payment pay1 = new Payment(8888, 5000, orders);
        Payment pay2 = new Payment(8889, 5050, orders);


        ArrayList<Payment> payments = new ArrayList<>();
        payments.add(pay1);
        //Client creation
        Client client = new Client(13, "Gaston", "Bonato","Noob developer",payments);
        
        clientService.create(client);
        paymentService.create(pay1);
        paymentService.create(pay2);
        
        System.out.println(paymentService.read(pay2.getId()).toString());
        System.out.println(paymentService.read(pay1.getId()).toString());
        paymentService.delete(pay2.getId());
        System.out.print(paymentService.read(pay2.getId()));
    }

}
