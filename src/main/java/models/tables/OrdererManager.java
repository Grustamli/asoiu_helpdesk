package models.tables;

import models.beans.Order;
import models.utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdererManager {
    private static Connection conn;

    public static List<Order> getALL(){
        Connection connection = ConnectionManager.getInstance().getConnection();
        String sql = "SELECT * FROM orders";
        List<Order> orders = null;
        try(
                Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(sql);
                ){
            if(rs.next()){
                rs.beforeFirst();
                orders = new ArrayList<>();
                while(rs.next()){
                    Order order = new Order();
                    // Implement ...

                    orders.add(order);
                }
            }

        }catch (SQLException e){
            System.err.println("Could not retrieve all orders");
            System.err.println(e.getMessage());
        }
        return orders;
    }

    public static Order getRow(int id) throws SQLException {
        Connection connection = ConnectionManager.getInstance().getConnection();
        Order order = null;
        String sql = "SELECT * FROM orders WHERE id = ?";
        ResultSet rs = null;

        try(
                PreparedStatement stmt = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ){
            stmt.setInt(1, id);
            rs = stmt.executeQuery();


        }catch (SQLException e){

        }
        finally {
            if(rs != null){
                rs.close();
            }
        }

        return order;
    }
}
