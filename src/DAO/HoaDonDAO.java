package DAO;

import javax.swing.JTable;

import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import DTO.Khach;
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
}
