/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import entity.Phong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Seenastic-local
 */
public class PhongDAO {
    model.DBConnection DBCon;
        Connection conn = null;

    public PhongDAO() {
        DBCon = new model.DBConnection();
        conn = DBCon.getConn();
    }
    
     public PhongDAO(model.DBConnection dbcon) {
        this.DBCon = dbcon;
        conn = DBCon.getConn();
    }
    
     public int add(Phong obj){
         int n = 0;
            System.out.println(obj);
         String sql = "INSERT INTO [Phong](name, dienTich, autoAntiFire, khoangCach)"
                + " VALUES(?,?,?,?)";
        try {
            // thu tu cac dau ? bat dau la 1
            PreparedStatement pre = conn.prepareStatement(sql);
            //set value for ?
            // pre.setString(index of ?, values of parameter);
            pre.setString(1, obj.getTenPhong());
            pre.setFloat(2, obj.getDienTich());
            pre.setInt(3, obj.getAuto());
            pre.setFloat(4, obj.getKhoangCach());
            // run
            n = pre.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PhongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return n;
     }
     public int update(Phong obj) {
        int n = 0;
        String sql = "UPDATE Phong SET sid = ? , sname = ? ,email = ? ,phone = ? , cid = ? WHere sid = ?";
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
            Logger.getLogger(PhongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
     public int remove(int id) {
        int n = 0;
        String sql = 
                "DELETE FROM Phong_HoaChat WHERE pid = " + id + " DELETE Phong WHERE id = '"+ id+"'";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
     public Vector getPhong(String sql) throws SQLException{
        Vector vector=new Vector<>();
        // get all record into vector
        ResultSet rs=DBCon.getData(sql);
        //code here
        while(true){ 
            if(!rs.next()) break;
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            String phone = rs.getString(4);
            int cid = rs.getInt(5);
            Vector tmp = new Vector();
            tmp.add(id);
            tmp.add(name);
            tmp.add( email);
            tmp.add( phone);
            tmp.add( cid);
            vector.add(tmp);
        }
        return vector;
    }
     
     public Vector getChatByPhong(int id) throws SQLException{
        Vector vector=new Vector<>();
        // get all record into vector
        String sql =    "SELECT P.name, P.dienTich, H.name, PH.theTich, H.khoiLuongRieng, H.nhietChayThap " +
                        "FROM Phong P, Phong_HoaChat PH, HoaChat H " +
                        "WHERE P.id = PH.pid AND PH.hid = H.id AND P.id = " + id;
        ResultSet rs=DBCon.getData(sql);
        int index = 0;
        //code here
        while(true){ 
            if(!rs.next()) break;
            
            String pname = rs.getString(1);
            float dientich = rs.getFloat(2);
            String hname = rs.getString(3);
            float theTich = rs.getFloat(4);
            float khoiLuongRieng = rs.getFloat(5);
            float nhietChayThap = rs.getFloat(6);
            
            Vector tmp = new Vector();
            tmp.add(++index);
            tmp.add(hname);
            tmp.add(theTich);
            tmp.add(theTich);
            tmp.add(theTich*khoiLuongRieng);
            tmp.add(theTich*khoiLuongRieng*nhietChayThap);
            vector.add(tmp);
        }
        return vector;
    }
     
     public Vector getPhongMainData(String sql) throws SQLException{
         Vector vector=new Vector<>();
        // get all record into vector
        ResultSet rs=DBCon.getData(sql);
        //code here
        while(true){ 
            if(!rs.next()) break;
            int id = rs.getInt(1);
            String name = rs.getString(2);
            float dientich = rs.getFloat(3);
            int auto = rs.getInt(4);
            float khoangCach = rs.getFloat(5);
            Phong obj = new Phong(id, name, dientich,auto, khoangCach );
            vector.add(obj);
        }
        return vector;
    } 
     
     public Vector getPhongTable(String sql) throws SQLException{
         Vector vector=new Vector<>();
        // get all record into vector
        ResultSet rs=DBCon.getData(sql);
        int index=0;
        //code here
        while(true){ 
            if(!rs.next()) break;
            int id = rs.getInt(1);
            String name = rs.getString(2);
            float dientich = rs.getFloat(3);
            int auto = rs.getInt(4);
            float khoangCach = rs.getFloat(5);
            System.out.println(new Phong(id, name, dientich, auto, khoangCach));
            Vector obj= new Vector<>();
            obj.add(++index);
            obj.add(name);
            obj.add(dientich);
            obj.add(auto == 0 ? "Thủ công" :"Tự động");
            obj.add(khoangCach);
            obj.add("Chưa có hạng");
            //taiTrongChay =
                    
            vector.add(obj);
        }
        return vector;
    } 
     
     public Vector getPhongSelect(String sql) throws SQLException{
        Vector vector=new Vector<>();
        // get all record into vector
        ResultSet rs=DBCon.getData(sql);
        //code here
        while(true){ 
            if(!rs.next()) break;
            int id = rs.getInt(1);
            String name = rs.getString(2);
            float dientich =rs.getFloat(3);
            int auto =rs.getInt(4);
            float kc =rs.getFloat(5);
            vector.add(name);
        }
        return vector;
    } 

     //INSERT INTO Phong_HoaChat(pid, hid,dai,rong,cao) VALUES(1,1,7,8,8)
    public int addChatToPhong(int pid,int hid,float theTich) {
        int n = 0;
        String sql = "INSERT INTO Phong_HoaChat(pid, hid,theTich) VALUES(?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, pid);
            pre.setInt(2, hid);
            pre.setFloat(3, theTich);
            
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }     
     public static void main(String[] args) {
        PhongDAO tmp = new PhongDAO();
    }
}
