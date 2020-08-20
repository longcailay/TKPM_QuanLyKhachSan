package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import DAO.PhanQuyenDAO;
import DTO.PhanQuyen;
import DataConnection.DataProvider;

public class PhanQuyenBUS {
	public static ArrayList<PhanQuyen> loadDSPhanQuyen(){
		return PhanQuyenDAO.loadDSPhanQuyen();
	}
	
	public static ArrayList<String> loadDSTenPhanQuyen(){
		return PhanQuyenDAO.loadDSTenPhanQuyen();
	}
	
	public static PhanQuyen loadPhanQuyenTheoTen(String ten) {
		PhanQuyen result = new PhanQuyen();
		if(ten.isBlank()) {
			JOptionPane.showMessageDialog(null, "Tên phân quyền không được bỏ trống!", "Warning!", JOptionPane.WARNING_MESSAGE);
		}
		else {
			result = PhanQuyenDAO.loadPhanQuyenTheoTen(ten);
		}
		return result;
	}
}
