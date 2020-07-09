package DTO;

public class LoaiKhach {
	private int id;
	private String tenLoai;
	private double phuThu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public double getPhuThu() {
		return phuThu;
	}
	public void setPhuThu(double phuThu) {
		this.phuThu = phuThu;
	}
	public LoaiKhach(int id, String tenLoai, double phuThu) {
		this.id = id;
		this.tenLoai = tenLoai;
		this.phuThu = phuThu;
	}
	public LoaiKhach() {
	}
	
}
