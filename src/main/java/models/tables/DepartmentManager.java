package models.tables;

import models.beans.Department;
import models.utils.ConnectionManager;

import java.sql.*;
import java.util.List;

public class DepartmentManager {

    private static Connection conn = ConnectionManager.getInstance().getConnection();
    private DepartmentManager(){}

    public static Department getRow(int id) throws SQLException {
        String sql = "SELECT * FROM departments WHERE id = ?";
        ResultSet rs = null;

        try(
                PreparedStatement stmt = conn.prepareStatement(sql);

                ){
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
        }
        catch (SQLException e){
            System.out.print("Could not get department row");
            System.out.print(e.getMessage());

        }
        finally {
            if(rs != null){
                rs.close();
            }
        }
    }

    public static List<Department> getAll(){
        String sql = "SELECT * FROM departments";
        try(
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(sql);
                ){


        }catch (SQLException e){

        }

    }

    public static void update(Department bean){}

    public static void delete(int id){}


}
