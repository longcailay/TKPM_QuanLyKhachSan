package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.ChiTietPhong;
import DTO.Phong;
import DAO.PhongDAO;
public class PhongBUS {
	public static ArrayList<Phong> LoadDSPhong(){
		return PhongDAO.LoadDSPhong();
	}
	
	public static ArrayList<Phong> LoadDSPhongTheoLoaiPhongVaTinhTrang(String lp, int tt){
		return PhongDAO.LoadDSPhongTheoLoaiPhongVaTinhTrang(lp, tt);
	}
	
	public static ChiTietPhong LoadChiTietPhong(int idPhong) {
		return PhongDAO.LoadChiTietPhong(idPhong);
	}
	
	private static boolean KiemTraTenPhongHopLe(String tenPhong) {
		boolean result = true;
		for(int i = 0; i < tenPhong.length(); i++) {
			char c = tenPhong.charAt(i);
			c = Character.toUpperCase(c);
			if( !( (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') ) ) {// c nằm ngoài khoản (0,9) và (A,Z) và (a,z)
				return false;
			}
		}
		return result;
	}
	
	public static int ThemPhongMoi(String tenPhong, String ghiChu, String tenLoaiPhong) {
		if(tenPhong.isBlank()){
			JOptionPane.showMessageDialog(null, "Tên phòng không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		
		if(!KiemTraTenPhongHopLe(tenPhong)) {
			JOptionPane.showMessageDialog(null, "Tên phòng chỉ bao gồm kí tự (a -> z và A-> Z) và số (0 -> 9)!","Warning", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		if(tenPhong.length() > 10) {
			JOptionPane.showMessageDialog(null, "Tên phòng quá dài! (> 10 kí tự)","Warning", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		Phong phong = PhongDAO.LayThongTinPhongTheoTenPhong(tenPhong);
		if(phong != null) {//Tên phòng này đã tồn tại trong CSDL (dù đã đánh dấu bị xóa (tình trạng = -1))
			JOptionPane.showMessageDialog(null, "Tên phòng đã tồn tại hoặc không phù hợp!","Warning", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		
		return PhongDAO.ThemPhongMoi(tenPhong, ghiChu, tenLoaiPhong);
	}
	
	public static int XoaPhong(String tenPhong) {
		if(tenPhong.isEmpty()) {//Cái này không cần thiết lắm
			JOptionPane.showMessageDialog(null, "Tên phòng không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		return PhongDAO.XoaPhong(tenPhong);
	}
	
	public static int SuaPhong(String tenPhong, String loaiPhong, String ghiChu) {
		if(tenPhong.isBlank()) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng cần sửa!","Warning!", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		if(PhongDAO.LayThongTinPhongTheoTenPhong(tenPhong) == null) {
			JOptionPane.showMessageDialog(null, "Phòng này không tồn tại trong CSDL!", "Warnig", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		
		return PhongDAO.SuaPhong(tenPhong, loaiPhong, ghiChu);
	}
	
}

