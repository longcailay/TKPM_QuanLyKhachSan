package DAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;

import DTO.ChiTietHoaDon;
import DTO.Khach;
import DTO.LoaiKhach;
import DTO.PhieuThue;
import DataConnection.DataProvider;

public class ChiTietHoaDonDAO {
	public static ArrayList<ChiTietHoaDon> LoadDSchiTietHoaDonTheoIDhoaDon(int idHoaDon) {
		ArrayList<ChiTietHoaDon> result = new ArrayList<ChiTietHoaDon>();
		String query = "SELECT * FROM CHI_TIET_HOA_DON WHERE HoaDon = "+ idHoaDon;
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		int countRow = table.getRowCount();
		for(int i = 0; i < countRow; i++) {
			//int id = (int) table.getModel().getValueAt(i, 0);
			int idPhieuThue = (int) table.getModel().getValueAt(i, 1);
			int soNgay = (int) table.getModel().getValueAt(i, 2);
			BigDecimal donGia = (BigDecimal) table.getModel().getValueAt(i, 3);
			double phuThu = (double) table.getModel().getValueAt(i, 4);
			BigDecimal tien = (BigDecimal) table.getModel().getValueAt(i, 5);
			result.add(new ChiTietHoaDon(idHoaDon, idPhieuThue, soNgay, donGia.floatValue(), (float)phuThu, tien.floatValue()));
		}
		return result;
	}
}
