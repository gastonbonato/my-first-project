package com.example.demo.services;
import com.example.demo.model.Order;

import java.util.ArrayList;

public class OrderService implements Service<Order> {
    private ArrayList<Order> orderArr = new ArrayList<>();

    @Override
    public Order create(Order order) {
        orderArr.add(order);
        return order;

    }

    @Override
    public Order read(int id) {
        Order orderAux = null;
        for(int index = 0; index < orderArr.size(); index++) {
            if(orderArr.get(index).getId() == id) {
                orderAux = orderArr.get(index);
            }
        }
        return orderAux;
    }

    @Override
    public Order update(Order order) {
        for(int index = 0; index < orderArr.size(); index++) {
            if(orderArr.get(index).getId() == order.getId()) {
                orderArr.set(index, order);
            }
        }
        return order;
    }

    @Override
    public void delete(int id) {
        //indexAux save index for deleting later, -1 if object does not exist.
        int indexAux = -1;
        for(int index = 0 ; index < orderArr.size(); index++) {
            if(orderArr.get(index).getId() == id) {
                indexAux = index;

            }
        }
        //TODO: CUIDADO! si indexAux es = -1 va a saltar ArrayIndexOutOfBoundsException
        orderArr.remove(indexAux);
    }

    public String toString()
    {
        return orderArr.toString();
    }
}
