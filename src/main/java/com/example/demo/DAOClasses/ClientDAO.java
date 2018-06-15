package com.example.demo.DAOClasses;

import com.example.demo.DB.conectionDB;
import com.example.demo.DataAccesObject.DAOInterface;
import com.example.demo.model.Client;
import com.example.demo.services.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO implements DAOInterface<Client> {

    private static final String SQL_INSERT = "INSERT INTO client (firstName, lastName, description) VALUES (?, ?, ?)";
    private static final String SQL_READ = "SELECT * FROM client WHERE idClient = ?";
    private static final String SQL_UPDATE = "UPDATE client SET firstName = ?, lastName = ?, description = ? WHERE idClient = ?";
    private static final String SQL_DELETE = "DELETE FROM client WHERE idClient = ?";



    private static final conectionDB conn = conectionDB.getDbCon();

    @Override
    public Client persist(Client client) {

        PreparedStatement ps;
        try {
            ps = conn.getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1, client.getName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getDescription());

            if (ps.executeUpdate() > 0){
                return client;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;


    }

    @Override
    public Client retrieve(Object id) {

        PreparedStatement ps;
        ResultSet res;
        Client c = null;

        try {
            ps = conn.getConnection().prepareStatement(SQL_READ);
            ps.setString(1, id.toString());

            res = ps.executeQuery();

            while(res.next()){
                c = new Client(res.getString(1), res.getString(2), res.getString(3));

            }
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    @Override
    public Client update(Client client) {

        PreparedStatement ps;

        try {
            ps = conn.getConnection().prepareStatement(SQL_UPDATE);
            ps.setString(1, client.getName());
            ps.setString(2,client.getLastName());
            ps.setString(3, client.getDescription());
            ps.setInt(4, client.getId());

            if(ps.executeUpdate() > 0){
                return client;
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

            if( ps.executeUpdate() > 0){
                System.out.println("Client deleted from data base!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
