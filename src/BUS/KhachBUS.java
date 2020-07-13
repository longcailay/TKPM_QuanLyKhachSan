package BUS;

import javax.swing.JOptionPane;

import DAO.KhachDAO;


public class KhachBUS {
	public static int XoaKhachTheoID(int idKhach) {
		if(idKhach < 0) {
			JOptionPane.showMessageDialog(null, "idKhach không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return 0;
		}
		return KhachDAO.XoaKhachTheoID(idKhach);
	}
}
