package com.example.demo.DAOClasses;

import com.example.demo.DB.conectionDB;
import com.example.demo.DataAccesObject.DAOInterface;
import com.example.demo.model.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ItemDAO implements DAOInterface<Item> {

    private static final String SQL_INSERT = "INSERT INTO item (name) VALUES(?)";
    private static final String SQL_READ = "SELECT * FROM item WHERE idItem = ?";
    private static final String SQL_UPDATE = "UPDATE item SET name = ? WHERE idItem = ?";
    private static final String SQL_DELETE = "DELETE FROM item WHERE idItem = ?";

    private static final conectionDB conn = conectionDB.getDbCon();

    @Override
    public Item persist(Item item) {

        PreparedStatement ps;
        try {
            ps = conn.getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1, item.getName());

            if (ps.executeUpdate() > 0){

                return item;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;


    }

    @Override
    public Item retrieve(Object id) {

        PreparedStatement ps;
        ResultSet res;
        Item i = null;

        try {
            ps = conn.getConnection().prepareStatement(SQL_READ);
            ps.setString(1, id.toString());

            res = ps.executeQuery();
            while (res.next()){
                i = new Item(res.getString(2));
            }
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;

    }

    @Override
    public Item update(Item item) {

        PreparedStatement ps;

        try {
            ps = conn.getConnection().prepareStatement(SQL_UPDATE);
            ps.setString(1, item.getName());
            ps.setInt(2, item.getId());

            if (ps.executeUpdate() > 0){
                return item;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void delete(Object id) {

        PreparedStatement ps;
        try {
            ps = conn.getConnection().prepareStatement(SQL_DELETE);
            ps.setString(1, id.toString());

            if (ps.executeUpdate() > 0){
                System.out.println("Item deleted from data base!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
