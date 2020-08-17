package BUS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import DAO.BaoCaoDAO;
import DTO.BaoCao;
import DTO.LoaiPhong;
import DTO.Phong;

public class BaoCaoBUS {
	public static ArrayList<BaoCao> BaoCaoDoanhThuTheoLoaiPhong(int thang, String nam) {// thang co format la yyyy-MM-01
		ArrayList<BaoCao> result = new ArrayList<BaoCao>();
		String Thang =  nam + "-" + thang + "-" + "01";
		ArrayList<LoaiPhong> lsLoaiPhong = LoaiPhongBUS.loadDSLoaiPhong();
		float tong = 0.0f;
		float giaTri = 0.0f;
		for(LoaiPhong lp: lsLoaiPhong) {
			giaTri = BaoCaoDAO.BaoCaoDoanhThuTheoLoaiPhong(lp.getId(), Thang);
			BaoCao baoCao = new BaoCao(lp.getTenLoai(), giaTri, 0.0f);
			result.add(baoCao);
			tong += giaTri;
		}
		
		if(tong > 0.0f) {
			for(int j =  0; j < result.size(); j++) {
				double tiLe = (result.get(j).getGiaTri()/tong)*100;
				tiLe = Math.ceil(tiLe*100)/100;//làm tròn số
				result.get(j).setTiLe((float)tiLe);
			}
		}
		return result;
	}
	
	
	public static ArrayList<BaoCao> BaoCaoMatDoSuDungPhong(int thang, String nam) {// thang co format la yyyy-MM-01
		ArrayList<BaoCao> result = new ArrayList<BaoCao>();
		String Thang =  nam + "-" + thang + "-" + "01";
		ArrayList<Phong> lsPhong = PhongBUS.LoadDSPhong();
		float tong = 0.0f;
		float giaTri = 0.0f;
		for(Phong p: lsPhong) {
			giaTri = BaoCaoDAO.BaoCaoMatDoSuDungPhong(p.getId(), Thang);
			BaoCao baoCao = new BaoCao(p.getTenPhong(), giaTri, 0.0f);
			result.add(baoCao);
			tong += giaTri;
		}
		
		//Sắp xếp báo cáo theo giá trị giảm dần, những báo cáo có giá trị = 0 sẽ bị loại bỏ
		//(những phòng không sử dụng trong tháng sẽ bị loại bỏ khỏi báo cáo)
		for(int i = 0; i < result.size() - 1; i++) {
			for (int j = i + 1; j < result.size();j++) {
				if(result.get(i).getGiaTri() < result.get(j).getGiaTri()) {
					Collections.swap(result,i,j);
				}
			}
		}
		List<BaoCao> temp = new ArrayList<BaoCao>();
		for(int i = 0; i < result.size(); i++) {
			if(result.get(i).getGiaTri() == 0.0f) {
				temp = result.subList(0, i);
				break;
			}
		}
		result = new ArrayList<BaoCao>(temp);
		
		
		if(tong > 0.0f) {
			for(int j =  0; j < result.size(); j++) {
				double tiLe = (result.get(j).getGiaTri()/tong)*100;
				tiLe = Math.ceil(tiLe*100)/100;//làm tròn số
				result.get(j).setTiLe((float)tiLe);
			}
		}
		return result;
	}
}
