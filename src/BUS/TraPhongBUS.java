package BUS;

import javax.swing.JOptionPane;
import DAO.TraPhongDAO;

public class TraPhongBUS {
	public static int TraPhong(int idPhong) {
		if(idPhong < 0) {
			JOptionPane.showMessageDialog(null, "idPhong không hợp lê!", "Error!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		else {
			return TraPhongDAO.TraPhong(idPhong);
		}
	}
	
	public static int layIDPhieuThue(int idPhong) {//lấy id phiếu thuê của phòng đang trả
		if(idPhong < 0) {
			JOptionPane.showMessageDialog(null, "idPhong không hợp lê!", "Error!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		else {
			return TraPhongDAO.layIDPhieuThue(idPhong);
		}
	}
}
