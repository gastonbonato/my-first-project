package com.example.demo.services;

import com.example.demo.model.Item;

import java.util.ArrayList;

public class ItemService implements Service<Item> {
    private ArrayList<Item> itemArr = new ArrayList<>();

    @Override
    public Item create(Item item) {
        itemArr.add(item);
        return item;

    }

    @Override
    public Item read(int id) {
        Item itemAux = null;
        for(int index = 0; index < itemArr.size(); index++) {
            if(itemArr.get(index).getId() == id) {
                itemAux = itemArr.get(index);
            }
        }
        return itemAux;
    }

    @Override
    public Item update(Item item) {

        for(int index = 0; index < itemArr.size(); index++) {
            if(itemArr.get(index).getId() == item.getId()) {
                itemArr.set(index, item);
            }
        }
        return item;
    }

    @Override
    public void delete(int id) {
        //indexAux save index for deleting later, -1 if object does not exist.
        int indexAux = -1;
        for(int index = 0; index < itemArr.size(); index++) {
            if(itemArr.get(index).getId() == id) {
                indexAux = index;
            }
        }
        //TODO: CUIDADO! si indexAux es = -1 va a saltar ArrayIndexOutOfBoundsException
        itemArr.remove(indexAux);
    }

    public String toString() {
        return itemArr.toString();
    }
}
