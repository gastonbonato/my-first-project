package com.example.demo.services;

import com.example.demo.model.Client;
import com.example.demo.model.Items;


import java.util.ArrayList;

public class ClientService implements Service<Client>
{
    private ArrayList<Client> clientsArr = new ArrayList<Client>();

    @Override
    public Client create(Client client)
    {
        clientsArr.add(client);
        return client;

    }

    @Override
    public Client read(int id) {

       Client cread =  null;
       for(int index = 0; index < clientsArr.size(); index++)
       {
            if(clientsArr.get(index).getId() == id)
            {
                cread = clientsArr.get(index);
            }
       }

       return cread;
    }

    @Override
    public Client update(Client client)
    {

        for(int index = 0 ; index < clientsArr.size(); index++)
        {
            if(clientsArr.get(index).getId() == client.getId())
            {
                clientsArr.set(index, client);
            }
        }

        return client;

    }

    @Override
    public void delete(int id)
    {
       //indexAux save index for deleting later, -1 if object does not exist.
       int indexAux = -1;
       for(int index = 0 ; index < clientsArr.size(); index++)
       {
           if(clientsArr.get(index).getId() == id)
           {
               indexAux = clientsArr.get(index).getId();

           }
       }



    }

    public String toString()
    {
        return clientsArr.toString();
    }
}
