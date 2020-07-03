package DAO;
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
		for(int i = 0; i < countRow; i++) {
			int id = (int) table.getModel().getValueAt(i, 0);
			String tenPhong =  (String) table.getModel().getValueAt(i, 1);
			String loaiPhong = (String) table.getModel().getValueAt(i, 2);
			String ghiChu = (String) table.getModel().getValueAt(i, 3);
			int tinhTrang = (int) table.getModel().getValueAt(i, 4);
			phong = new Phong(id, tenPhong, loaiPhong, ghiChu, tinhTrang);
			result.add(phong);
		}
		return result;
	}
	
}
