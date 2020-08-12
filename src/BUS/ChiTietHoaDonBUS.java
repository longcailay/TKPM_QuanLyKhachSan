package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDon;

public class ChiTietHoaDonBUS {
	public static ArrayList<ChiTietHoaDon> LoadDSchiTietHoaDonTheoIDhoaDon(int idHoaDon) {
		if(idHoaDon < 0) {
			JOptionPane.showMessageDialog(null, "idHoaDon không hợp lệ!", "Error!", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		else {
			return ChiTietHoaDonDAO.LoadDSchiTietHoaDonTheoIDhoaDon(idHoaDon);
		}
	}
}
