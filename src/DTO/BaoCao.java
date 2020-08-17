package DTO;

public class BaoCao{
	private String ten;
	private float giaTri;
	private float tiLe;
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public float getGiaTri() {
		return giaTri;
	}
	public void setGiaTri(float giaTri) {
		this.giaTri = giaTri;
	}
	public float getTiLe() {
		return tiLe;
	}
	public void setTiLe(float tiLe) {
		this.tiLe = tiLe;
	}
	public BaoCao(String ten, float giaTri, float tiLe) {
		super();
		this.ten = ten;
		this.giaTri = giaTri;
		this.tiLe = tiLe;
	}
	public BaoCao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
