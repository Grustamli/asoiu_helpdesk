package models.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static ConnectionManager instance = null;
    private Connection conn = null;
    private String username;
    private String password;
    private String dbUrl;
    private ConnectionStatus connStatus;
    private static final String authErrorCode = "28P01";


    private ConnectionManager(){}

    public static ConnectionManager getInstance(){
        if(instance == null){
            instance = new ConnectionManager();
        }
        return instance;
    }


    public void setDb(String host, int port, String database){
        dbUrl = String.format("jdbc:postgresql://%s:%d/%s", host, port, database);
    }


    private boolean openConnection(){
        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
            return true;
        }
        catch (SQLException e){
            if(e.getSQLState().equals(authErrorCode)){
                setConnectionStatus(ConnectionStatus.AUTH_ERROR);
            }
            else{
                setConnectionStatus(ConnectionStatus.SERVER_ERROR);
            }
            return false;
        }

    }

    public Connection getConnection(){
        if (conn == null){
            if(openConnection()){
                System.out.println("Connection Opened");
                return conn;
            }
            else return null;
        }
        else {
            return conn;
        }
    }

    public void Close(){
        System.out.println("Closing Connection");
        try {
            conn.close();
            conn = null;
            System.out.println("Connection closed");
        }
        catch (Exception e){
            System.err.println("Connection could not be closed");
        }
    }

    private void setConnectionStatus(ConnectionStatus connectionStatus) {
        this.connStatus = connectionStatus;
    }

    public ConnectionStatus getConnectionStatus() {
        return connStatus;
    }
}
