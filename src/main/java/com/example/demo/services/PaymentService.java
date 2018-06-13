package com.example.demo.services;

import com.example.demo.model.Payment;

import java.util.ArrayList;

public class PaymentService implements Service<Payment>
{
    ArrayList<Payment> paymentArr = new ArrayList<Payment>();
    @Override
    public Payment create(Payment payment)
    {
        paymentArr.add(payment);
        return payment;
    }

    @Override
    public Payment read(int id)
    {
        Payment paymentAux = null;
        for(int index = 0; index < paymentArr.size(); index++)
        {
            if(paymentArr.get(index).getId() == id)
            {
                paymentAux = paymentArr.get(index);

            }

        }

        return paymentAux;
    }

    @Override
    public Payment update(Payment payment)
    {
        for(int index = 0; index < paymentArr.size(); index++)
        {
            if(paymentArr.get(index).getId() == payment.getId())
            {
                paymentArr.set(index, payment);

            }

        }

        return payment;
    }

    @Override
    public void delete(int id)
    {
        //indexAux save index for deleting later, -1 if object does not exist.
        int indexAux = -1;
        for(int index = 0 ; index < paymentArr.size(); index++)
        {
            if(paymentArr.get(index).getId() == id)
            {
                indexAux = paymentArr.get(index).getId();

            }
        }

    }
}
