package com.mhkhoa.webserviceontap.model;

/**
 * Created by thaim on 23/12/2017.
 */

public class NhanVien {
    private String ma;
    private String ten;
    private String hsluong; //kieu du lieu gi thi ti qua Main ep kieu do

    public NhanVien() {
    }

    public NhanVien(String ma, String ten, String hsluong) {
        this.ma = ma;
        this.ten = ten;
        this.hsluong = hsluong;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHsluong() {
        return hsluong;
    }

    public void setHsluong(String hsluong) {
        this.hsluong = hsluong;
    }
}
