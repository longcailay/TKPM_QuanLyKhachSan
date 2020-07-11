package DTO;

import java.util.ArrayList;
import java.util.Date;

public class PhieuThue {
	private int id;
	private Date NgayThue;
	private Date NgayKetThuc;
	private int tinhTrang;/*-1. đã bị xóa, 0. Đang thuê phòng và chưa thanh toán,  1. Đã trả phòng và đã thanh toán,  2. Đã trả phòng và chưa thanh toán*/
	private int idPhong;
	private int idNguoiDung;
	private String tenPhong;
	private ArrayList<Khach> danhSachKhach;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getNgayThue() {
		return NgayThue;
	}
	public void setNgayThue(Date ngayThue) {
		NgayThue = ngayThue;
	}
	public Date getNgayKetThuc() {
		return NgayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public int getIdPhong() {
		return idPhong;
	}
	public void setIdPhong(int idPhong) {
		this.idPhong = idPhong;
	}
	public int getIdNguoiDung() {
		return idNguoiDung;
	}
	public void setIdNguoiDung(int idNguoiDung) {
		this.idNguoiDung = idNguoiDung;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public ArrayList<Khach> getDanhSachKhach() {
		return danhSachKhach;
	}
	public void setDanhSachKhach(ArrayList<Khach> danhSachKhach) {
		this.danhSachKhach = danhSachKhach;
	}
	public PhieuThue(int id, Date ngayThue, Date ngayKetThuc, int tinhTrang, int idPhong, int idNguoiDung,
			String tenPhong, ArrayList<Khach> danhSachKhach) {
		this.id = id;
		NgayThue = ngayThue;
		NgayKetThuc = ngayKetThuc;
		this.tinhTrang = tinhTrang;
		this.idPhong = idPhong;
		this.idNguoiDung = idNguoiDung;
		this.tenPhong = tenPhong;
		this.danhSachKhach = danhSachKhach;
	}
	public PhieuThue() {
		// TODO Auto-generated constructor stub
	}
	
	
}
