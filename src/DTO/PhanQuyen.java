package DTO;

public class PhanQuyen {
	private int id;
	private String ten;
	private String ghiChu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public PhanQuyen(int id, String ten, String ghiChu) {
		super();
		this.id = id;
		this.ten = ten;
		this.ghiChu = ghiChu;
	}
	public PhanQuyen() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
