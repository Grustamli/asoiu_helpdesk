package models.tables;

import models.beans.Order;

import java.sql.Connection;
import java.util.List;

public class OrderManager {
    private static Connection conn;
    public static List<Order> getAll(){
        List<Order> orders = null;

        return orders;
    }

    public static Order getRow(int id){
        Order order = null;

        return order;
    }

    public static boolean insert(Order bean){
        boolean inserted = false;


        return inserted;
    }

    public static boolean update(Order bean){
        boolean updated = false;

        return updated;

    }

    public static boolean delete(int id){
        boolean deleted = false;

        return deleted;

    }
}
