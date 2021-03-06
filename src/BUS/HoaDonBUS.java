package BUS;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.HoaDonDAO;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;


public class HoaDonBUS {
	public static int getIDHoaDonMax() {
		return HoaDonDAO.getIDHoaDonMax();
	 }
	
	public static int TaoHoaDon(HoaDon hd) {
		if(hd.getKhachHang().isBlank()) {
			JOptionPane.showMessageDialog(null, "Khách hàng/ Cơ quan không được bỏ trống!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		if(hd.getDiaChi().isBlank()) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được bỏ trống!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		return HoaDonDAO.TaoHoaDon(hd);
	}
	
	public static int TaoChiTietHoaDon(ChiTietHoaDon cthd) {
		return HoaDonDAO.TaoChiTietHoaDon(cthd);
	}
	public static ArrayList<HoaDon> LoadDanhSachHoaDon() {
		return HoaDonDAO.LoadDanhSachHoaDon();
	}
	
	public static ArrayList<HoaDon> LoadDanhSachHoaDonTheoMaHoaDonVaKhachHang(String idHoaDon, String strKhachHang) {
		if(idHoaDon.equals("Tất cả")) {
			return HoaDonDAO.LoadDanhSachHoaDonTheoMaHoaDonVaKhachHang(-1, strKhachHang);
		}
		else {
			return HoaDonDAO.LoadDanhSachHoaDonTheoMaHoaDonVaKhachHang(Integer.valueOf(idHoaDon), strKhachHang);
		}
	}
}
