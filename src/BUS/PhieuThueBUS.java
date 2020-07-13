package BUS;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.PhieuThueDAO;
import DTO.Khach;
import DTO.PhieuThue;
import DTO.Phong;

public class PhieuThueBUS {
	public static int TaoPhieuThue(PhieuThue phieuThue) {
		int idPhieuThue = -1;
		if(phieuThue.getNgayThue() == null) {
			JOptionPane.showMessageDialog(null, "Ngày thuê không được bỏ trống!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		if(phieuThue.getDanhSachKhach().size() == 0) {
			JOptionPane.showMessageDialog(null, "Phòng phải có ít nhất 1 khách!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		if(PhieuThueDAO.TaoPhieuThue(phieuThue) == 1) {// nếu tạo thành công
				//JOptionPane.showMessageDialog(null, "Tạo phiếu thuê thành công!", "Information!", JOptionPane.INFORMATION_MESSAGE);
				idPhieuThue = PhieuThueDAO.getIDPhieuThueMax();
		}
		return idPhieuThue;
	}
	
	public static int TaoChiTietPhieuThue(int idPhieuthue, Khach khach ) {
		if(idPhieuthue < 0) {
			JOptionPane.showMessageDialog(null, "idPhieuThue không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		return PhieuThueDAO.TaoChiTietPhieuThue(idPhieuthue, khach);
	}
	
	public static int CapNhatTinhTrangPhongThanhDangThue(int idPhong) {
		if(idPhong < 0) {
			JOptionPane.showMessageDialog(null, "idPhong không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		return PhieuThueDAO.CapNhatTinhTrangPhongThanhDangThue(idPhong);
	}
	
	public static String getNgayKetThucMax(int idPhong) {
		return PhieuThueDAO.getNgayKetThucMax(idPhong);
	}
	
	public static ArrayList<PhieuThue> LoadDanhSachPhieuThue(){
		return PhieuThueDAO.LoadDanhSachPhieuThue();
	}
	
	public static int XoaPhieuThueTheoID(int idPhieuThue) {
		if(idPhieuThue < 0) {
			JOptionPane.showMessageDialog(null, "idPhieuThue không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return 0;
		}
		return PhieuThueDAO.XoaPhieuThueTheoID(idPhieuThue);
	}
	
	public static ArrayList<Phong> LoadDanhSachPhongCoPhieuThue(){
		return PhieuThueDAO.LoadDanhSachPhongCoPhieuThue();
	}
	
	public static ArrayList<PhieuThue> LoadDanhSachPhieuThueTheoTenPhongVaTinhTrang(String TenPhong, String strTinhTrang){
		if(TenPhong.isBlank()) {
			JOptionPane.showMessageDialog(null, "Tên phòng không được bỏ trống!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return new ArrayList<PhieuThue>();
		}
		else {
			int tinhTrang = -1;
			if(strTinhTrang.equals("Đang cho thuê")) {
				tinhTrang = 0;
			}
			if(strTinhTrang.equals("Đã thanh toán")) {
				tinhTrang = 1;
			}
			if(strTinhTrang.equals("Chưa thanh toán")) {
				tinhTrang = 2;
			}
			return PhieuThueDAO.LoadDanhSachPhieuThueTheoTenPhongVaTinhTrang(TenPhong, tinhTrang);
		}
	}
	public static PhieuThue LoadPhieuThueTheoID(int idPhieuThue) {
		return PhieuThueDAO.LoadPhieuThueTheoID(idPhieuThue);
	}
}
