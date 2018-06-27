package com.example.demo.DAOClasses;

import com.example.demo.DB.conectionDB;
import com.example.demo.DataAccesObject.DAOInterface;
import com.example.demo.model.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO implements DAOInterface<Order> {

    private static final String SQL_INSERT = " INSERT INTO  `order` (name) VALUES(?)";
    private static final String SQL_READ = "SELECT * FROM `order` WHERE idOrder = ?";
    private static final String SQL_UPDATE = "UPDATE `order` SET name = ? WHERE idOrder = ?";
    private static final String SQL_DELETE = "DELETE FROM `order` WHERE idOrder = ?";

    private static final conectionDB conn = conectionDB.getDbCon();

    @Override
    public Order persist(Order order) {

        PreparedStatement ps;
        try {
            ps = conn.getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1, order.getName());

            if (ps.executeUpdate() > 0){
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Order retrieve(Object id) {

        PreparedStatement ps;
        ResultSet res;
        Order ord = null;
        try {
            ps = conn.getConnection().prepareStatement(SQL_READ);
            ps.setString(1, id.toString());

            res = ps.executeQuery();
            while (res.next()){
                ord = new Order(res.getString(2));
            }
            return ord;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ord;

    }

    @Override
    public Order update(Order order) {

        PreparedStatement ps;
        try {
            ps = conn.getConnection().prepareStatement(SQL_UPDATE);
            ps.setString(1, order.getName());
            ps.setInt(2, order.getId());

            if (ps.executeUpdate() > 0){
                return order;
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
            ps.setString(1,id.toString());

            if (ps.executeUpdate() > 0){

                System.out.println("Order deleted from data base!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
