package BUS;


import DAO.DangNhapDAO;
import DTO.NguoiDung;

public class DangNhapBUS {
	public static NguoiDung LoadNguoiDungTheoTaiKhoanVaMatKhau(String TaiKhoan, String MatKhau) {
		NguoiDung result = null;
		if(TaiKhoan.isBlank() || MatKhau.isBlank()) {
			return result;
		}
		else {
			result = DangNhapDAO.LoadNguoiDungTheoTaiKhoanVaMatKhau(TaiKhoan, MatKhau);
		}
		
		return result;
	}
}
