/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Seenastic-local
 */
public class HoaChat {
    private int id;
    private String name;
    private float khoiLuongRieng, nhietChayThap;

    public HoaChat() {
    }

    public HoaChat(int id, String name, float khoiLuongRieng, float nhietChayThap) {
        this.id = id;
        this.name = name;
        this.khoiLuongRieng = khoiLuongRieng;
        this.nhietChayThap = nhietChayThap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public HoaChat(String name, float khoiLuongRieng, float nhietChayThap) {
        this.name = name;
        this.khoiLuongRieng = khoiLuongRieng;
        this.nhietChayThap = nhietChayThap;
    }

    @Override
    public String toString() {
        return "HoaChat{" + "id=" + id + ", name=" + name + ", khoiLuongRieng=" + khoiLuongRieng + ", nhietChayThap=" + nhietChayThap + '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getKhoiLuongRieng() {
        return khoiLuongRieng;
    }

    public void setKhoiLuongRieng(float khoiLuongRieng) {
        this.khoiLuongRieng = khoiLuongRieng;
    }

    public float getNhietChayThap() {
        return nhietChayThap;
    }

    public void setNhietChayThap(float nhietChayThap) {
        this.nhietChayThap = nhietChayThap;
    }
    
    
    
}
