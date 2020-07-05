package DTO;

public class Khach {
	private int id;
	private String hoTen;
	private String cmnd;
	private String diaChi;
	private int loaiKhach;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getLoaiKhach() {
		return loaiKhach;
	}
	public void setLoaiKhach(int loaiKhach) {
		this.loaiKhach = loaiKhach;
	}
	public Khach(int id, String hoTen, String cmnd, String diaChi, int loaiKhach) {
		this.id = id;
		this.hoTen = hoTen;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
		this.loaiKhach = loaiKhach;
	}
	public Khach() {
		this.id = 0;
		this.hoTen = null;
		this.cmnd = null;
		this.diaChi = null;
		this.loaiKhach = 0;
	}
}
