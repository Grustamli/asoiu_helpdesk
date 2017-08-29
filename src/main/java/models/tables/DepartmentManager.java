package models.tables;

import models.beans.Department;
import models.utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentManager {

    private static Connection conn = ConnectionManager.getInstance().getConnection();
    private DepartmentManager(){}

    public static Department getRow(int id) throws SQLException {
        String sql = "SELECT * FROM departments WHERE id = ?";
        ResultSet rs = null;
        Department department = null;

        try(
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            if(rs.next()){
                department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                department.setRoomNo(rs.getInt("room_no"));
            }
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
        return department;
    }

    public static List<Department> getAll(){
        String sql = "SELECT * FROM departments";
        List<Department> departments = null;
        try(
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(sql);
                ){
            if(rs.next()){
                departments = new ArrayList<>();
                rs.beforeFirst();
                while(rs.next()){
                    Department department = new Department();
                    department.setId(rs.getInt("id"));
                    department.setName(rs.getString("name"));
                    department.setRoomNo(rs.getInt("room_no"));
                    departments.add(department);
                }
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return departments;
    }

    public static void delete(int id){}


}
