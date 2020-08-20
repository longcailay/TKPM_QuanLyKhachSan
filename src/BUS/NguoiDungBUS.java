package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import DAO.NguoiDungDAO;
import DAO.PhanQuyenDAO;
import DTO.NguoiDung;
import DTO.PhanQuyen;
import DataConnection.DataProvider;
public class NguoiDungBUS {
	public static NguoiDung LoadNguoiDungTheoID(int id) {
		return NguoiDungDAO.LoadNguoiDungTheoID(id);
	}
	public static String LoadTenNguoiDungTheoID(int id) {
		return NguoiDungDAO.LoadTenNguoiDungTheoID(id);
	}
	
	public static ArrayList<NguoiDung> LoadDSNguoiDung(){
		return NguoiDungDAO.LoadDSNguoiDung();
	}

	
	
	private static boolean KiemTraCMNDHopLe(String cmnd) {
		boolean result = true;
		for(int i = 0; i < cmnd.length(); i++) {
			char c = cmnd.charAt(i);
			if( !( c >= '0' && c <= '9' ) ) {// c nằm ngoài khoản (0,9)
				return false;
			}
		}
		return result;
	}
	
	private static boolean KiemTraMatKhauHopLe(String mk) {
		boolean result = true;
		for(int i = 0; i < mk.length(); i++) {
			char c = mk.charAt(i);
			if( !(( c >= '0' && c <= '9' )  || (c >= 'a' && c <= 'z')  || (c >= 'A' && c <= 'Z'))) {// c là kí tự đặc biệt.
				return false;
			}
		}
		return result;
	}
	
	public static int ThemNguoiDungMoi(String HoTen, String Cmnd, String Sdt, String DiaChi, String TaiKhoan, String MatKhau, String PhanQuyen) {
		if(HoTen.isBlank()) {
			JOptionPane.showMessageDialog(null, "Tên người dùng không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		if(KiemTraCMNDHopLe(Cmnd) == false) {
			JOptionPane.showMessageDialog(null, "Số CMND không hợp lệ!","Warning", JOptionPane.WARNING_MESSAGE);
			return -2;
		}
		if(Cmnd.length() < 10 || Cmnd.length() > 20) {
			JOptionPane.showMessageDialog(null, "Số chữ số của CMND nằm trong khoản 10 -> 20 chữ số!","Warning", JOptionPane.WARNING_MESSAGE);
			return -2;
		}
		
		if(Sdt.isBlank()) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
			return -3;
		}
		if(KiemTraCMNDHopLe(Sdt) == false) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!","Warning", JOptionPane.WARNING_MESSAGE);
			return -3;
		}
		if(DiaChi.isBlank()){
			JOptionPane.showMessageDialog(null, "Địa chỉ không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
			return -4;
		}
		if(TaiKhoan.isBlank()) {
			JOptionPane.showMessageDialog(null, "Tài khoản không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
			return -5;
		}
		if(NguoiDungDAO.KiemTraTenTaiKhoanTonTai(TaiKhoan)) {
			JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại!\nVui lòng chọn tên khác!","Warning", JOptionPane.WARNING_MESSAGE);
			return -5;
		}
		if(MatKhau.isBlank()) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
			return -6;
		}
		if(KiemTraMatKhauHopLe(MatKhau) == false) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ!","Warning", JOptionPane.WARNING_MESSAGE);
			return -6;
		}
		PhanQuyen phanQuyen = PhanQuyenDAO.loadPhanQuyenTheoTen(PhanQuyen);
		NguoiDung nguoiDung = new NguoiDung(0, HoTen, Cmnd, Sdt, DiaChi, TaiKhoan, MatKhau, 1, phanQuyen.getId());
		if(NguoiDungDAO.ThemNguoiDungMoi(nguoiDung) == 1) {
			JOptionPane.showMessageDialog(null, "Thêm thành công!", "Information!",JOptionPane.INFORMATION_MESSAGE);
		}
		return 1;
	}
	

	public static int CapNhatNguoiDung(int id,String HoTen, String Cmnd, String Sdt, String DiaChi, String TaiKhoan, String MatKhau, String PhanQuyen) {
		if(HoTen.isBlank()) {
			JOptionPane.showMessageDialog(null, "Tên người dùng không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		if(KiemTraCMNDHopLe(Cmnd) == false) {
			JOptionPane.showMessageDialog(null, "Số CMND không hợp lệ!","Warning", JOptionPane.WARNING_MESSAGE);
			return -2;
		}
		if(Cmnd.length() < 10 || Cmnd.length() > 20) {
			JOptionPane.showMessageDialog(null, "Số chữ số của CMND nằm trong khoản 10 -> 20 chữ số!","Warning", JOptionPane.WARNING_MESSAGE);
			return -2;
		}
		
		if(Sdt.isBlank()) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
			return -3;
		}
		if(KiemTraCMNDHopLe(Sdt) == false) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!","Warning", JOptionPane.WARNING_MESSAGE);
			return -3;
		}
		if(DiaChi.isBlank()){
			JOptionPane.showMessageDialog(null, "Địa chỉ không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
			return -4;
		}
//		if(TaiKhoan.isBlank()) {
//			JOptionPane.showMessageDialog(null, "Tài khoản không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
//			return -5;
//		}
//		if(NguoiDungDAO.KiemTraTenTaiKhoanTonTai(TaiKhoan)) {
//			JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại!\nVui lòng chọn tên khác!","Warning", JOptionPane.WARNING_MESSAGE);
//			return -5;
//		}
		if(MatKhau.isBlank()) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
			return -6;
		}
		if(KiemTraMatKhauHopLe(MatKhau) == false) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ!","Warning", JOptionPane.WARNING_MESSAGE);
			return -6;
		}
		PhanQuyen phanQuyen = PhanQuyenDAO.loadPhanQuyenTheoTen(PhanQuyen);
		NguoiDung nguoiDung = new NguoiDung(id, HoTen, Cmnd, Sdt, DiaChi, TaiKhoan, MatKhau, 1, phanQuyen.getId());
		if(NguoiDungDAO.CapNhatNguoiDung(nguoiDung) == 1) {
			JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "Information!",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Cập nhật thất bại!", "Warning!", JOptionPane.WARNING_MESSAGE);
		}
		return 1;
	}
	
	public static int XoaNguoiDung(int id) {
		if(id < 0) {
			JOptionPane.showMessageDialog(null, "Id không hợp lê!", "Warning!", JOptionPane.WARNING_MESSAGE);
		}
		else {
			if(NguoiDungDAO.XoaNguoiDung(id) >= 1) {
				JOptionPane.showMessageDialog(null, "Xóa thành công!", "Information!", JOptionPane.INFORMATION_MESSAGE);
				return 1;
			}
			else {
				JOptionPane.showMessageDialog(null, "Cập nhật thất bại!", "Information!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		return -1;
	}
}
