package DAO;
import UI.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;

import DTO.Phong;
import DataConnection.DataProvider;

public class PhongDAO {
	public static ArrayList<Phong> LoadDSPhong(){
		ArrayList<Phong> result = new ArrayList<Phong>();
		String query = "exec pro_LoadDSPhong";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		Phong phong = null;
		
		int countRow  = table.getRowCount();
		//System.out.println("Ô" + numRow);
		for(int i = 0; i < 30; i++) {
			int id = (int) table.getModel().getValueAt(i, 0);
			String tenPhong =  (String) table.getModel().getValueAt(i, 1);
			String loaiPhong = (String) table.getModel().getValueAt(i, 2);
			String ghiChu = (String) table.getModel().getValueAt(i, 3);
			int tinhTrang = (int) table.getModel().getValueAt(i, 4);
			phong = new Phong(id, tenPhong, loaiPhong, ghiChu, tinhTrang);
			result.add(phong);
		}
		
//		try {
//			resultSet.next();//int id, String tenPhong, String loaiPhong, String ghiChu, int tinhTrang
//			phong = new Phong(resultSet.getInt("ID"),resultSet.getString("TenPhong"),resultSet.getNString("TenLoai"),resultSet.getString("GhiChu"),resultSet.getInt("TinhTrang"));
//			System.out.println("U:" + phong.getGhiChu());
//			result.add(phong);
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		System.out.println("So dong: " + result.size());
		return result;
	}
	
}
