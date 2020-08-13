package DAO;

import javax.swing.JTable;

import DataConnection.DataProvider;

public class TraPhongDAO {
	public static int TraPhong(int idPhong) {
		int result;
		String query = "pro_TraPhong " + idPhong;
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);		
		return result;
	}
	
	public static int layIDPhieuThue(int idPhong) {
		int result = -1;
		String query = "select ID from PHIEU_THUE where Phong = " + idPhong + " and " + " TinhTrang = 0";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		if(table.getRowCount() > 0) {
			result = (int)table.getModel().getValueAt(0, 0);
		}
		return result;
	}
}
