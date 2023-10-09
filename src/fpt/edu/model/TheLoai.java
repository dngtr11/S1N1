/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.edu.model;

/**
 *
 * @author Dung Tran
 */
public class TheLoai {

    private String maTL;
    private String tenTL;
    private boolean trangThai;
    id cut;

    public TheLoai() {
    }

    public TheLoai(String maTL, String tenTL, boolean trangThai) {
        this.maTL = maTL;
        this.tenTL = tenTL;
        this.trangThai = trangThai;
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public String getTenTL() {
        return tenTL;
    }

    public void setTenTL(String tenTL) {
        this.tenTL = tenTL;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "TheLoai{" + "maTL=" + maTL + ", tenTL=" + tenTL + ", trangThai=" + trangThai + '}';
    }

}
