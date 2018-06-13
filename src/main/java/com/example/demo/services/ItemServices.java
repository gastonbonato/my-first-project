package com.example.demo.services;

import com.example.demo.model.Items;

import java.util.ArrayList;

public class ItemServices implements Service<Items>
{
    private ArrayList<Items> itemsArr = new ArrayList<Items>();

    @Override
    public Items create(Items item)
    {
        itemsArr.add(item);
        return item;

    }

    @Override
    public Items read(int id)
    {
        Items itemAux = null;
        for(int index = 0; index < itemsArr.size(); index++)
        {
            if(itemsArr.get(index).getId() == id)
            {
                itemAux = itemsArr.get(index);

            }

        }

        return itemAux;

    }

    @Override
    public Items update(Items item) {

        for(int index = 0; index < itemsArr.size(); index++)
        {
            if(itemsArr.get(index).getId() == item.getId())
            {
                itemsArr.set(index, item);

            }

        }

        return item;
    }

    @Override
    public void delete(int id)
    {
        //indexAux save index for deleting later, -1 if object does not exist.
        int indexAux = -1;
        for(int index = 0 ; index < itemsArr.size(); index++)
        {
            if(itemsArr.get(index).getId() == id)
            {
                indexAux = itemsArr.get(index).getId();

            }
        }

    }

    public String toString() {
        return itemsArr.toString();
    }
}
