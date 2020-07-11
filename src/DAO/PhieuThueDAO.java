package DAO;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;

import DTO.Khach;
import DTO.PhieuThue;
import DataConnection.DataProvider;

public class PhieuThueDAO {
	public static int TaoPhieuThue(PhieuThue phieuThue) {
		int result;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ngayThue = sdf.format(phieuThue.getNgayThue());
		String query = "pro_TaoPhieuThue N'"+ ngayThue + "', N'" + phieuThue.getTinhTrang() + "', " + phieuThue.getIdPhong() + ", " + phieuThue.getIdNguoiDung();
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);		
		return result;
	}
	
	public static int getIDPhieuThueMax() {
		int result = -1;
		String query = "SELECT MAX(ID) FROM PHIEU_THUE";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		if(table.getRowCount() > 0) {
			result = (int) table.getModel().getValueAt(0, 0);
		}
		return result;
	}
	
	public static int TaoChiTietPhieuThue(int idPhieuthue, Khach khach ) {
		int result = -1;
		String query = "pro_TaoChiTietPhieuThue N'" + idPhieuthue + "', N'" + khach.getHoTen() + "', N'" + khach.getCmnd() + "', N'" + khach.getDiaChi() + "', " + khach.getLoaiKhach();
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);
		return result; //trả ra 2 nếu thực hiện thành công (do thêm khách trước rồi mới thêm chi tiết phiếu thuê
	}
	
	public static int CapNhatTinhTrangPhongThanhDangThue(int idPhong) {//cập nhật tình trạng phòng từ trống sang đang thuê
		int result = -1;
		String query = "UPDATE PHONG SET TinhTrang = 1 WHERE ID = " + idPhong;
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);
		return result; 
	}
	
	public static String getNgayKetThucMax(int idPhong) {
		Date temp = new Date();
		String query = "select Max(NgayKetThuc) from PHIEU_THUE where Phong = " + idPhong;
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		if(table.getRowCount() > 0) {
			temp = (Date) table.getModel().getValueAt(0, 0);
		}
		String result = null;
		if(temp != null) {
			result = temp.toString();
		}
		return result;
	}
	
}
