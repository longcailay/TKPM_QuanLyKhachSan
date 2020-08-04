package DTO;

public class PhieuThueChiTiet{
	private int id;
	private String tenPhong;
	private int soNgay;
	private float donGia;
	private float phuThu;
	private float tien;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public int getSoNgay() {
		return soNgay;
	}
	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public float getPhuThu() {
		return phuThu;
	}
	public void setPhuThu(float phuThu) {
		this.phuThu = phuThu;
	}
	public float getTien() {
		return tien;
	}
	public void setTien(float tien) {
		this.tien = tien;
	}
	public PhieuThueChiTiet(int id, String tenPhong, int soNgay, float donGia, float phuThu, float tien) {
		super();
		this.id = id;
		this.tenPhong = tenPhong;
		this.soNgay = soNgay;
		this.donGia = donGia;
		this.phuThu = phuThu;
		this.tien = tien;
	}
	public PhieuThueChiTiet() {
		super();
		this.tien = 0.0f;
	}
	
}
