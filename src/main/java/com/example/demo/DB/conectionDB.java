package com.example.demo.DB;
import java.sql.*;
import java.sql.DriverManager;

public class conectionDB {
    public Connection conn;
    private Statement statement;
    public static conectionDB db;

    private conectionDB() {
        String url= "jdbc:mysql://localhost:3306/shoppingcart";
        String dbName = "shoppingcart";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    /**
     * return a connection
     * */
    public Connection getConnection(){
        return conn;
    }

    /**
     *
     * @return MysqlConnect Database connection object
     * instance
     */
    public static synchronized conectionDB getDbCon()
    {
        if ( db == null )
        {
            db = new conectionDB();
        }
        return db;
    }


}
