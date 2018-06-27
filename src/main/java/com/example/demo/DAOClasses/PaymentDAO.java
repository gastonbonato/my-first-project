package com.example.demo.DAOClasses;

import com.example.demo.DB.conectionDB;
import com.example.demo.DataAccesObject.DAOInterface;
import com.example.demo.model.Payment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAO implements DAOInterface<Payment> {

    private static final String SQL_INSERT = "INSERT INTO payment(amount) VALUES(?)";
    private static final String SQL_READ = "SELECT * FROM payment WHERE idPayment = ?";
    private static final String SQL_UPDATE = "UPDATE payment SET amount = ? WHERE idPayment = ?";
    private static final String SQL_DELETE = "DELETE FROM payment WHERE idPayment = ?";

    private static final conectionDB conn = conectionDB.getDbCon();

    @Override
    public Payment persist(Payment payment) {

        PreparedStatement ps;
        try {
            ps = conn.getConnection().prepareStatement(SQL_INSERT);
            ps.setDouble(1, payment.getAmount());

            if(ps.executeUpdate() > 0){
                return payment;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    @Override
    public Payment retrieve(Object id) {

        PreparedStatement ps;
        ResultSet res;
        Payment p = null;
        try {
            ps = conn.getConnection().prepareStatement(SQL_READ);
            ps.setString(1, id.toString());

            res = ps.executeQuery();
            while (res.next()){
                p = new Payment(res.getDouble(2));
            }
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;

    }


    @Override
    public Payment update(Payment payment) {

        PreparedStatement ps;
        try {
            ps = conn.getConnection().prepareStatement(SQL_UPDATE);
            ps.setDouble(1, payment.getAmount());
            ps.setInt(2, payment.getId());

            if (ps.executeUpdate() > 0){
                return payment;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }

    @Override
    public void delete(Object id) {

        PreparedStatement ps;
        try {
            ps = conn.getConnection().prepareStatement(SQL_DELETE);
            ps.setString(1, id.toString());

            if (ps.executeUpdate() > 0){

                System.out.println("Payment deleted from data base!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
