/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.edu.service;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import fpt.edu.model.TheLoai;
import fpt.edu.reponstory.DBConnect;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dung Tran
 */
public class TheLoaiService {
    public List<TheLoai> getAll(){
        String sql = """
                     select * from TheLoai
                     """;
        try(Connection c = DBConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<TheLoai> list  = new ArrayList<>();
            while (rs.next()) {                
                TheLoai tl = new TheLoai();
                tl.setMaTL(rs.getString(1));
                tl.setTenTL(rs.getString(2));
                tl.setTrangThai(rs.getBoolean(3));
                list.add(tl);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<TheLoai> paging(int page, int limit){
        String sql = """
                     SELECT [MaTL]
                           ,[TenTL]
                           ,[TrangThai]
                       FROM [dbo].[TheLoai] order by MaTL offset ? rows fetch next ? rows only 
                     """;
        try(Connection c = DBConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            ps.setInt(1, (page - 1)*limit);
            ps.setInt(2, limit);
            List<TheLoai> list = new ArrayList<>();
            while (rs.next()) {                
                TheLoai tl = new TheLoai();
                tl.setMaTL(rs.getString(1));
                tl.setTenTL(rs.getString(2));
                tl.setTrangThai(rs.getBoolean(3));
                list.add(tl);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean add(TheLoai tl){
        int check = 0;
        String sql = """
                     insert into TheLoai
                     values (?,?,?)
                     """;
        try(Connection c = DBConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, tl.getMaTL());
            ps.setString(2, tl.getTenTL());
            ps.setBoolean(3, tl.isTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check>0;
    }
    public boolean update(String maS,TheLoai tl){
        int check = 0;
        String sql = """
                     update TheLoai
                     set MaTL = ?, TenTL = ?, TrangThai = ?
                     where MaTL = ?
                     """;
        try(Connection c = DBConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, tl.getMaTL());
            ps.setString(2, tl.getTenTL());
            ps.setBoolean(3, tl.isTrangThai());
            ps.setString(4, maS);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check>0;
    }
    public boolean remove(String ma){
        int check = 0;
        String sql = """
                     delete from TheLoai
                     where MaTL = ?
                     """;
        try(Connection c = DBConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check>0;
    }
    public List<TheLoai> search(String ma){
////        List<TheLoai> listSearch = new ArrayList<>();
////        for (TheLoai tl : getAll()) {
////            if (tl.getMaTL().contains(ma)) {
////                listSearch.add(tl);
////            }
////        }
//       
                List<TheLoai> list = new ArrayList<>();
        String sql = """
                     select * from TheLoai where MaTL = ? or TrangThai = ?
                     """;
        try(Connection c = DBConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            ps.setObject(1, ma);
            ps.setObject(2, ma);
             
            while (rs.next()) {                
                TheLoai tl = new TheLoai();
                tl.setMaTL(rs.getString(1));
                tl.setTenTL(rs.getString(2));
                tl.setTrangThai(rs.getBoolean(3));
                list.add(tl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
