package com.example.demo;

import com.example.demo.DAOClasses.ClientDAO;
import com.example.demo.DAOClasses.ItemDAO;
import com.example.demo.DAOClasses.OrderDAO;
import com.example.demo.DAOClasses.PaymentDAO;
import com.example.demo.model.Client;
import com.example.demo.model.Item;
import com.example.demo.model.Order;
import com.example.demo.model.Payment;

import java.util.Scanner;

public class DaoTest {

    public static void main(String[] args){
        /**
         * MENU
         * */

        Scanner input = new Scanner(System.in);
        Boolean exit = false;
        int op = 0;
        while(!exit){

            System.out.println("---------------------------------");
            System.out.println("Adding Shopping cart objects Menu");
            System.out.println("---------------------------------");

            System.out.println("Enter option:");
            op = input.nextInt();

            switch (op){
                case 1: break;
                case 2:
                    exit =  true;
                default: break;

            }

        }


    }
}
