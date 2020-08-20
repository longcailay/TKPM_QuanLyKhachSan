package DAO;

import javax.swing.JTable;

import DTO.NguoiDung;
import DataConnection.DataProvider;

public class DangNhapDAO {
	public static NguoiDung LoadNguoiDungTheoTaiKhoanVaMatKhau(String TaiKhoan, String MatKhau) {
		NguoiDung result = null;
		String query = "select * from NGUOI_DUNG where TaiKhoan = N'" + TaiKhoan + "' and MatKhau = N'" + MatKhau + "' and TinhTrang = 1";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		if(table.getRowCount() > 0) {
			int id =(int) table.getModel().getValueAt(0, 0);
			String hoTen =(String) table.getModel().getValueAt(0, 1);
			String cmnd =(String) table.getModel().getValueAt(0, 2);
			String sdt =(String) table.getModel().getValueAt(0, 3);
			String diaChi = (String)table.getModel().getValueAt(0, 4);
			String taiKhoan =(String) table.getModel().getValueAt(0, 5);
			String matKhau = (String)table.getModel().getValueAt(0, 6);
			int tinhTrang = (int) table.getModel().getValueAt(0, 7);
			int phanQuyen =(int) table.getModel().getValueAt(0, 8);
			result = new NguoiDung(id, hoTen, cmnd, sdt, diaChi, taiKhoan, matKhau, tinhTrang, phanQuyen);
		}
		//System.out.println(query);
		return result;
	}
}
