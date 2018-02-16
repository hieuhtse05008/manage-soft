/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import entity.HoaChat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DBConnection;

/**
 *
 * @author golde_000
 */
public class HoaChatDAO {
    DBConnection DBCon;
        Connection conn = null;

    public HoaChatDAO() {
        DBCon = new DBConnection();
        conn = DBCon.getConn();
    }
    
     public HoaChatDAO(DBConnection dbcon) {
        this.DBCon = dbcon;
        conn = DBCon.getConn();
    }
    
     public int add(HoaChat obj){
         int n = 0;
         
         String sql = "INSERT INTO [HoaChat](name, khoiLuongRieng, nhietChayThap)"
                + " VALUES(?,?,?)";
        try {
            // thu tu cac dau ? bat dau la 1
            PreparedStatement pre = conn.prepareStatement(sql);
            //set value for ?
            // pre.setString(index of ?, values of parameter);
            pre.setString(1, obj.getName());
            pre.setFloat(2, obj.getKhoiLuongRieng());
            pre.setFloat(3, obj.getNhietChayThap());
            // run
            n = pre.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(HoaChatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return n;
     }
     public int update(HoaChat obj) {
        int n = 0;
        String sql = "UPDATE HoaChat SET sid = ? , sname = ? ,email = ? ,phone = ? , cid = ? WHere sid = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
//            pre.setInt(1, obj.getSid());
//            pre.setString(2, obj.getSname());
//            pre.setString(3, obj.getEmail());
//            pre.setString(4, obj.getPhone());
//            pre.setInt(5, obj.getCid());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaChatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
     public int remove(int id) {
        int n = 0;
        String sql = 
                "DELETE FROM Phong_HoaChat WHERE hid = "+ id +" DELETE HoaChat WHERE id = '"+ id+"'";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaChatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
     public Vector getHoaChat(String sql) throws SQLException{
        Vector vector=new Vector<>();
        // get all record into vector
        ResultSet rs=DBCon.getData(sql);
        //code here
        while(true){ 
            if(!rs.next()) break;
            int id = rs.getInt(1);
            String name = rs.getString(2);
            float khoiLuongRieng = rs.getFloat(3);
            float nhietChayThap = rs.getFloat(4);
            Vector tmp = new Vector();
            tmp.add(id);
            tmp.add(name);
            tmp.add( khoiLuongRieng);
            tmp.add( nhietChayThap);
            
            HoaChat obj = new HoaChat(id, name, khoiLuongRieng, nhietChayThap);
            System.out.println(obj);
            
            vector.add(tmp);
        }
        return vector;
    }
     
     public Vector getChatTable(String sql) throws SQLException{
        Vector vector=new Vector<>();
        // get all record into vector
        ResultSet rs=DBCon.getData(sql);
        int index = 0;
        //code here

        while(true){ 
            if(!rs.next()) break;
            int id = rs.getInt(1);
            String name = rs.getString(2);
            float khoiLuongRieng = rs.getFloat(3);
            float nhietChayThap = rs.getFloat(4);
            Vector tmp = new Vector();
            tmp.add(++index);
            tmp.add(name);
            tmp.add( khoiLuongRieng);
            tmp.add( nhietChayThap);
            
            vector.add(tmp);
        }
        return vector;
    }
     
     public Vector getChatMainData(String sql) throws SQLException{
        Vector vector=new Vector<>();
        // get all record into vector
        ResultSet rs=DBCon.getData(sql);
        //code here
        while(true){ 
            if(!rs.next()) break;
            int id = rs.getInt(1);
            String name = rs.getString(2);
            float khoiLuongRieng = rs.getFloat(3);
            float nhietChayThap = rs.getFloat(4);
            
            HoaChat obj = new HoaChat(id, name, khoiLuongRieng, nhietChayThap);
            System.out.println(obj);
            
            vector.add(obj);
        }
        return vector;
    }
     
     public Vector getHoaChatSelect(String sql) throws SQLException{
        Vector vector=new Vector<>();
        // get all record into vector
        ResultSet rs=DBCon.getData(sql);
        //code here
        while(true){ 
            if(!rs.next()) break;
            int id = rs.getInt(1);
            String name = rs.getString(2);
            float khoiLuongRieng = rs.getFloat(3);
            float nhietChayThap = rs.getFloat(4);
            
            vector.add(name);
        }
        return vector;
    } 
     
     public static void main(String[] args) throws SQLException {
        HoaChatDAO tmp = new HoaChatDAO();
        tmp.getHoaChatSelect("SELECT * FROM HoaChat");
    }
}
