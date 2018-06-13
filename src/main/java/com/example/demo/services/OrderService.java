package com.example.demo.services;
import com.example.demo.model.Order;

import java.util.ArrayList;

public class OrderService implements Service<Order>
{
    ArrayList<Order> orderArr = new ArrayList<Order>();

    @Override
    public Order create(Order order)
    {
        orderArr.add(order);
        return order;

    }

    @Override
    public Order read(int id)
    {
        Order orderAux = null;
        for(int index = 0; index < orderArr.size(); index++)
        {
            if(orderArr.get(index).getId() == id)
            {
                orderAux = orderArr.get(index);

            }

        }

        return orderAux;
    }

    @Override
    public Order update(Order order)
    {
        for(int index = 0; index < orderArr.size(); index++)
        {
            if(orderArr.get(index).getId() == order.getId())
            {
                orderArr.set(index, order);
            }

        }
        return order;

    }

    @Override
    public void delete(int id)
    {
        //indexAux save index for deleting later, -1 if object does not exist.
        int indexAux = -1;
        for(int index = 0 ; index < orderArr.size(); index++)
        {
            if(orderArr.get(index).getId() == id)
            {
                indexAux = orderArr.get(index).getId();

            }
        }

    }

    public String toString()
    {
        return orderArr.toString();
    }
}
