package DAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;

import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import DTO.Khach;
import DTO.PhieuThue;
import DataConnection.DataProvider;

public class HoaDonDAO {
	public static int getIDHoaDonMax() {
		int result = -1;
		String query = "SELECT MAX(ID) FROM HOA_DON";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		if(table.getRowCount() > 0) {
			result = (int)table.getModel().getValueAt(0, 0);
		}
		return result;
	 }
	
	public static int TaoHoaDon(HoaDon hd) {
		int result = -1;
		String query = "pro_TaoHoaDon N'" + hd.getKhachHang() + "', N'" + hd.getDiaChi() + "', " + hd.getTongTien() + ", " + hd.getNguoiDung();
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);
		return result; //trả ra 1 nếu thực hiện thành công
	}
	
	public static int TaoChiTietHoaDon(ChiTietHoaDon cthd) {
		int result = -1;
		String query = "pro_TaoChiTietHoaDon " + cthd.getIdHoaDon() + ", " + cthd.getIdPhieuThue() + ", " + cthd.getSoNgay() + ", " + cthd.getDonGia() + ", " + cthd.getPhuThu() + ", " + cthd.getTien();
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);
		return result; //trả ra 2 nếu thực hiện thành công
	}
	public static ArrayList<HoaDon> LoadDanhSachHoaDon() {
		ArrayList<HoaDon> result = new ArrayList<HoaDon>();
		String query = "SELECT ID, KhachHang, DiaChi, TongTien, NguoiDung FROM HOA_DON ";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		int coutRow = table.getRowCount();
		for(int i = 0; i < coutRow; i++) {
			int id = (int)table.getModel().getValueAt(i, 0);
			String khachHang = (String)table.getModel().getValueAt(i, 1);
			String diaChi = (String)table.getModel().getValueAt(i, 2);
			BigDecimal tongTien = (BigDecimal)table.getModel().getValueAt(i, 3);
			int idNguoiDung = (int)table.getModel().getValueAt(i, 4);
			
			HoaDon hoaDon = new HoaDon(id, khachHang, diaChi, tongTien.floatValue(), idNguoiDung);
			result.add(hoaDon);
		}
		return result;
	}
	
	public static ArrayList<HoaDon> LoadDanhSachHoaDonTheoMaHoaDonVaKhachHang(int idHoaDon, String strKhachHang) {
		ArrayList<HoaDon> result = new ArrayList<HoaDon>();
		String query = "pro_LoadDanhSachHoaDonTheoMaHoaDonVaKhachHang " + idHoaDon + ", N'" + strKhachHang + "'";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		int coutRow = table.getRowCount();
		for(int i = 0; i < coutRow; i++) {
			int id = (int)table.getModel().getValueAt(i, 0);
			String khachHang = (String)table.getModel().getValueAt(i, 1);
			String diaChi = (String)table.getModel().getValueAt(i, 2);
			BigDecimal tongTien = (BigDecimal)table.getModel().getValueAt(i, 3);
			int idNguoiDung = (int)table.getModel().getValueAt(i, 4);
			
			HoaDon hoaDon = new HoaDon(id, khachHang, diaChi, tongTien.floatValue(), idNguoiDung);
			result.add(hoaDon);
		}
		return result;
	}
	
}
