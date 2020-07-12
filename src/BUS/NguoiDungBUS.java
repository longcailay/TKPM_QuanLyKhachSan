package BUS;

import DAO.NguoiDungDAO;
import DTO.NguoiDung;
public class NguoiDungBUS {
	public static NguoiDung LoadNguoiDungTheoID(int id) {
		return NguoiDungDAO.LoadNguoiDungTheoID(id);
	}
}
