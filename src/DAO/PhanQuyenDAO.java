package DAO;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JTable;

import DTO.LoaiKhach;
import DTO.PhanQuyen;
import DataConnection.DataProvider;

public class PhanQuyenDAO {
	public static ArrayList<PhanQuyen> loadDSPhanQuyen(){
		ArrayList<PhanQuyen> result = new ArrayList<PhanQuyen>();
		String query = "select * from PHAN_QUYEN";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		
		int countRow = table.getRowCount();
		for(int i = 0; i < countRow; i++) {
			int id = (int) table.getModel().getValueAt(i, 0);
			String ten = (String) table.getModel().getValueAt(i, 1);
			String ghiChu = (String) table.getModel().getValueAt(i, 2);
			result.add(new PhanQuyen(id, ten, ghiChu));
		}
		return result;
	}
	
	public static ArrayList<String> loadDSTenPhanQuyen(){
		ArrayList<String> result = new ArrayList<String>();
		String query = "select TenPhanQuyen from PHAN_QUYEN";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		
		int countRow = table.getRowCount();
		for(int i = 0; i < countRow; i++) {
			String ten = (String) table.getModel().getValueAt(i, 0);
			result.add(ten);
		}
		return result;
	}
	
	public static PhanQuyen loadPhanQuyenTheoTen(String ten) {
		PhanQuyen result = new PhanQuyen();
		String query = "select * from PHAN_QUYEN where TenPhanQuyen = N'" + ten + "'";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		
		if(table.getRowCount() > 0) {
			int id = (int) table.getModel().getValueAt(0, 0);
			String tenPQ = (String) table.getModel().getValueAt(0, 1);
			String ghiChu = (String) table.getModel().getValueAt(0, 2);
			result = new PhanQuyen(id, tenPQ, ghiChu);
		}
		return result;
	}
	
	
}
