package DAO;

import java.util.ArrayList;

import javax.swing.JTable;

import DTO.LoaiKhach;
import DataConnection.DataProvider;

public class LoaiKhachDAO {
	public static ArrayList<LoaiKhach> loadDSLoaiKhach(){
		ArrayList<LoaiKhach> result = new ArrayList<LoaiKhach>();
		String query = "exec pro_LoadDanhSachLoaiKhach";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		
		int countRow = table.getRowCount();
		for(int i = 0; i < countRow; i++) {
			int id = (int) table.getModel().getValueAt(i, 0);
			String tenLoai = (String) table.getModel().getValueAt(i, 1);
			double phuThu = (double) table.getModel().getValueAt(i, 2);
			result.add(new LoaiKhach(id, tenLoai, phuThu));
		}
		return result;
	}
	
	public static int ThemKhach(String hoTen, String cmnd, String diaChi, String tenLoaiKhach) {
		int result;
		String query = "pro_ThemKhach N'"+ hoTen + "', N'" + cmnd + "', N'" + diaChi + "', N'" + tenLoaiKhach + "'";
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);		
		return result;
	}
	
	public static int ThemLoaiKhach(String tenLoai, double phuThu) {
		int result;
		String query = "INSERT INTO LOAI_KHACH (TenLoai, PhuThu) VALUES(N'" + tenLoai + "', " + phuThu + ")";
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);		
		return result;
	}
	
	public static int LoadMaLoaiKhachTheoTenLoaiKhach(String tenLoaiKhach) {
		int result = -1;
		String query = "pro_LoadMaLoaiKhachTheoTenLoaiKhach N'" + tenLoaiKhach + "'";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		if(table.getRowCount() > 0) {
			result = (int)table.getModel().getValueAt(0, 0);
		}
		return result;
	}
	
	public static LoaiKhach LoadLoaiKhachTheoID(int id) {
		LoaiKhach result = new LoaiKhach(id,"", 0.0);
		String query = "pro_LayLoaiKhachTheoID "+ id;
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		if(table.getRowCount() > 0) {
			result.setTenLoai(table.getValueAt(0, 1).toString());
			result.setPhuThu((double)table.getValueAt(0, 2));
		}
		return result;
	}
	
	public static int CapNhatLoaiKhach(LoaiKhach loaiKhach) {
		int result = -1;
		String query = "UPDATE LOAI_KHACH SET TenLoai = N'" + loaiKhach.getTenLoai() + "', PhuThu = " + loaiKhach.getPhuThu() +"  WHERE ID = " + loaiKhach.getId();
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);
		return result;
	}
}
