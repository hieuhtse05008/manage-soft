/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author Seenastic-local
 */
public class Phong {
    private int id;
    private String tenPhong;
    private float dienTich;
    private int auto;
    private float khoangCach;

    public Phong() {
    }

    public Phong(String tenPhong, float dienTich, int auto, float khoangCach) {
        this.tenPhong = tenPhong;
        this.dienTich = dienTich;
        this.auto = auto;
        this.khoangCach = khoangCach;
    }

    public Phong(int id, String tenPhong, float dienTich, int auto, float khoangCach) {
        this.id = id;
        this.tenPhong = tenPhong;
        this.dienTich = dienTich;
        this.auto = auto;
        this.khoangCach = khoangCach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public float getDienTich() {
        return dienTich;
    }

    public void setDienTich(float dienTich) {
        this.dienTich = dienTich;
    }

    public int getAuto() {
        return auto;
    }

    public void setAuto(int auto) {
        this.auto = auto;
    }

    public float getKhoangCach() {
        return khoangCach;
    }

    public void setKhoangCach(float khoangCach) {
        this.khoangCach = khoangCach;
    }

    @Override
    public String toString() {
        return "Phong{" + "id=" + id + ", tenPhong=" + tenPhong + ", dienTich=" + dienTich + ", auto=" + auto + ", khoangCach=" + khoangCach + '}';
    }

      
    
    
}
