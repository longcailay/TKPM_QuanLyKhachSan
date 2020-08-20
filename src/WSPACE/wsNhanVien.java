package WSPACE;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.NguoiDungBUS;
import BUS.PhanQuyenBUS;
import DTO.Khach;
import DTO.NguoiDung;
import DTO.PhieuThue;
import UI.ThemNguoiDung;
import UI.ThemPhongMoi;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import UI.CapNhatNguoiDung;
import UI.HomePage;
public class wsNhanVien extends JPanel{
	public static JPanel panel;
	private JTable tbNguoiDung;
	private JButton btnThemMoiLoaiKhach;
	private JButton btnCapNhat;
	private JButton btnXoa;
	private ArrayList<NguoiDung> lsNguoiDung = NguoiDungBUS.LoadDSNguoiDung();
	public static NguoiDung nguoiDung = null;
	public static String phanQuyen = null;
	public wsNhanVien() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_2_1 = new JLabel("Danh sách nhân viên");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnThemMoiLoaiKhach = new JButton("Thêm mới");
		btnThemMoiLoaiKhach.setForeground(Color.WHITE);
		btnThemMoiLoaiKhach.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnThemMoiLoaiKhach.setBackground(Color.BLUE);
		btnThemMoiLoaiKhach.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnThemMoiLoaiKhachClick();
			}
		});
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setForeground(Color.BLACK);
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCapNhat.setBackground(Color.ORANGE);
		btnCapNhat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCapNhatClick();
			}
		});
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXoa.setBackground(Color.RED);
		btnXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnXoaClick();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(251)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(720, Short.MAX_VALUE)
							.addComponent(btnThemMoiLoaiKhach, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(242)
							.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(108)
							.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnThemMoiLoaiKhach, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addGap(81)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(119, Short.MAX_VALUE))
		);
		
		tbNguoiDung = new JTable();
		tbNguoiDung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rowTBNguoiDungClick();
			}
		});
		tbNguoiDung.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"STT", "H\u1ECD t\u00EAn", "CMND", "S\u0110T", "\u0110\u1ECBa ch\u1EC9", "T\u00E0i kho\u1EA3n", "Ph\u00E2n quy\u1EC1n"
			}
		));
		tbNguoiDung.getColumnModel().getColumn(0).setMaxWidth(30);
		scrollPane.setViewportView(tbNguoiDung);
		setLayout(groupLayout);
		
		
		loadDanhSachNguoiDung();
	}
	
	void loadDanhSachNguoiDung() {
		int r = 0;
		int c = 0;
		r = tbNguoiDung.getRowCount();
		c = tbNguoiDung.getColumnCount();
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				tbNguoiDung.setValueAt(null, i, j);
			}
		}
		int row = 0;
		for(NguoiDung NguoiDung: lsNguoiDung) {
			tbNguoiDung.setValueAt(row + 1, row, 0);
			tbNguoiDung.setValueAt(NguoiDung.getHoTen(), row, 1);
			tbNguoiDung.setValueAt(NguoiDung.getCmnd(), row, 2);
			tbNguoiDung.setValueAt(NguoiDung.getSdt(), row, 3);
			tbNguoiDung.setValueAt(NguoiDung.getDiaChi(), row, 4);
			tbNguoiDung.setValueAt(NguoiDung.getTaiKhoan(), row, 5);
			if(NguoiDung.getPhanQuyen() == 1) {
				tbNguoiDung.setValueAt("Admin", row, 6);
			}
			if(NguoiDung.getPhanQuyen() == 2) {
				tbNguoiDung.setValueAt("Nhân viên", row, 6);
			}
			row++;
		}
	}
	void btnThemMoiLoaiKhachClick() {
		ThemNguoiDung nd = new ThemNguoiDung();
		nd.setVisible(true);
	}
	void btnCapNhatClick() {
		if(nguoiDung != null) {
			CapNhatNguoiDung cnnd = new CapNhatNguoiDung();
			cnnd.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần cần cập nhật!", "Warning!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	void btnXoaClick() {
		if(nguoiDung != null) {
			NguoiDungBUS.XoaNguoiDung(nguoiDung.getId());
			HomePage.btnNhanVien.doClick();
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần cần xóa!", "Warning!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	void rowTBNguoiDungClick(){
		int row = -1;
		row = tbNguoiDung.getSelectedRow();
		if(row <= lsNguoiDung.size() - 1) {
			int id = lsNguoiDung.get(row).getId();
			String hoTen = (String)tbNguoiDung.getValueAt(row, 1);
			String cmnd = (String)tbNguoiDung.getValueAt(row, 2);
			String sdt = (String)tbNguoiDung.getValueAt(row, 3);
			String diaChi = (String)tbNguoiDung.getValueAt(row, 4);
			String taiKhoan = (String)tbNguoiDung.getValueAt(row, 5);
			phanQuyen = (String)tbNguoiDung.getValueAt(row, 6);
			
			nguoiDung = new NguoiDung(id, hoTen, cmnd, sdt, diaChi, taiKhoan, "", 1, PhanQuyenBUS.loadPhanQuyenTheoTen(phanQuyen).getId());
		}
		else {
			nguoiDung = null;
			phanQuyen = null;
		}
	}
}
