package DAO;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JTable;

import DTO.LoaiPhong;

import DataConnection.DataProvider;

public class LoaiPhongDAO {

	public static ArrayList<LoaiPhong> loadDSLoaiPhong(){
		ArrayList<LoaiPhong> result = new ArrayList<LoaiPhong>();
		String query = "exec pro_LoadDanhSachLoaiPhong";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		
		int countRow = table.getRowCount();
		for(int i = 0; i < countRow; i++) {
			int id = (int) table.getModel().getValueAt(i, 0);
			String tenLoai = (String) table.getModel().getValueAt(i, 1);
			BigDecimal donGia = (BigDecimal) table.getModel().getValueAt(i, 2);
			int slKhachBT = (int) table.getModel().getValueAt(i, 3);
			int slKhachTD = (int) table.getModel().getValueAt(i, 4);
			double phuThu = (double) table.getModel().getValueAt(i, 5);
			result.add(new LoaiPhong(id, tenLoai, donGia, slKhachBT, slKhachTD, phuThu));
		}
		return result;
	}
	public static LoaiPhong loadLoaiPhongTheoTenPhong(String tenPhong) {
		LoaiPhong result = new LoaiPhong();
		String query = "EXEC pro_LoadLoaiPhongTheoTenPhong N'" + tenPhong + "'";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		
		if(table.getRowCount() > 0) {
			int id = (int) table.getModel().getValueAt(0, 0);
			String tenLoai = (String) table.getModel().getValueAt(0, 1);
			BigDecimal donGia = (BigDecimal) table.getModel().getValueAt(0, 2);
			int slKhachBT = (int) table.getModel().getValueAt(0, 3);
			int slKhachTD = (int) table.getModel().getValueAt(0, 4);
			double phuThu = (double) table.getModel().getValueAt(0, 5);
			result = new LoaiPhong(id, tenLoai, donGia, slKhachBT, slKhachTD, phuThu);
		}
		return result;
	}
	
}
