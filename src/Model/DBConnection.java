/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DBConnection {
      // chứa kết nối đến server và DB
    Connection conn=null;
    //Xử lý lệnh SQL theo kiểu truyền thống
    Statement state=null;
    //Xử lý lệnh SQL theo hỗ trợ của java
    PreparedStatement preState=null;
    //Nhận kết quả từ câu lệnh Select
    ResultSet rs=null;
    public DBConnection(String driver,String URL,String user,
            String pass){
        try {
            Class.forName(driver);
            //step 2:
            conn=DriverManager.getConnection(URL, user, pass);
            System.out.println("connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public DBConnection(String URL,String user, String pass){
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //step 2:
            conn=DriverManager.getConnection(URL, user, pass);
            System.out.println("connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DBConnection() {
        this("jdbc:sqlserver://localhost:1433;databaseName=manageSoft","sa","123456");
    }
    public Connection getConn(){
        return conn;
    }
    public ResultSet getData(String sql){
        ResultSet rs=null;
        try {
            Statement state=conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs=state.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        return rs;
                
    }
    
    public static void main(String[] args) {
        DBConnection dbcon = new DBConnection();
        System.out.println(dbcon.getData("SELECT * FROM HoaChat"));
    }
  
    
}
