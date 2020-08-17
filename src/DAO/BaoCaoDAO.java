package DAO;

import java.math.BigDecimal;

import javax.swing.JTable;


import DataConnection.DataProvider;

public class BaoCaoDAO {
	public static float BaoCaoDoanhThuTheoLoaiPhong(int idLoaiPhong, String thang) {// thang co format la N'yyyy-MM-01'
		float result = 0.0f;
		String query = "exec pro_BaoCaoTheoLoaiPhong "+ idLoaiPhong + ", N'" + thang + "'";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		int countRow = table.getRowCount();
		if(countRow > 0) {
			if(table.getModel().getValueAt(0, 0) != null) {
				result = Float.valueOf(((BigDecimal)table.getModel().getValueAt(0, 0)).toString());
			}
		}
		return result;
	}
	
	public static float BaoCaoMatDoSuDungPhong(int idPhong, String thang) {// thang co format la N'yyyy-MM-01'
		int result = 0;
		String query = "pro_BaoCaoMatDoSuDungPhong "+ idPhong + ", N'" + thang + "'";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		int countRow = table.getRowCount();
		if(countRow > 0) {
			if(table.getModel().getValueAt(0, 0) != null) {
				result = (int)table.getModel().getValueAt(0, 0);
			}
		}
		return result;
	}
}
