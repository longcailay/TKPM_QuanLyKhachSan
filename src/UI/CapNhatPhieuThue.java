package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;

import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.Scrollable;
import javax.swing.SpinnerDateModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.Button;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JScrollPane;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BUS.KhachBUS;
import BUS.LoaiKhachBUS;
import BUS.LoaiPhongBUS;
import BUS.PhieuThueBUS;
import BUS.PhongBUS;
import DAO.PhieuThueDAO;
import DTO.Khach;
import DTO.LoaiKhach;
import DTO.PhieuThue;
import WSPACE.wsQuanLyPhong;
import WSPACE.wsThuePhong;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SpinnerModel;



public class CapNhatPhieuThue extends JFrame {

	protected JPanel contentPane;
	protected JTextField txtHoten;
	protected JTextField txtSoCMND;
	protected JTextField txtDiaChi;
	protected JComboBox cmbLoaiKhach;
	protected JLabel lblPhong;
	protected JSpinner spnNgayThue;
	protected JTable tbDanhSachKhach;
	protected JScrollPane scrollPane;
	
	protected JButton btnThem;
	protected JButton btnXoa;
	protected JButton btnCapNhat;
	protected JButton btnOK;
	protected JButton btnXacNhan;
	protected JButton btnHuy;

	protected JPanel panel;
	protected String tenPhong = "";//Cái này là tạm thời
	protected PhieuThue phieuThue = wsThuePhong.phieuThue;
	protected ArrayList<Khach> listKhach = wsThuePhong.listKhach;
	protected ArrayList<Khach> listKhachBanDau = wsThuePhong.listKhach;//Dùng để xóa danh sách khách hiện tại
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatPhieuThue frame = new CapNhatPhieuThue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CapNhatPhieuThue() {
		setTitle("HoApp - Cập nhật phiếu thuê" + phieuThue.getId());
		setResizable(false);
		setBounds(100, 100, 1093, 516);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) Color.LIGHT_GRAY));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 308, 478);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Khách hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(84, 26, 125, 32);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 78, 67, 20);
		panel.add(lblNewLabel_1);
		
		txtHoten = new JTextField();
		txtHoten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtHoten.setBounds(10, 108, 288, 32);
		panel.add(txtHoten);
		txtHoten.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Loại khách");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 162, 85, 20);
		panel.add(lblNewLabel_1_1);
		
		txtSoCMND = new JTextField();
		txtSoCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoCMND.setColumns(10);
		txtSoCMND.setBounds(10, 282, 288, 32);
		panel.add(txtSoCMND);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(10, 367, 288, 32);
		panel.add(txtDiaChi);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Số CMND");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 252, 67, 20);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Địa chỉ");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(10, 337, 67, 20);
		panel.add(lblNewLabel_1_1_2);
		
		btnThem = new JButton("Thêm");
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(0, 0, 255));
		btnThem.setBounds(106, 432, 85, 21);
		panel.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnThemClick();
			}
		});
		
		
		btnOK = new JButton("OK");
		btnOK.setForeground(Color.WHITE);
		btnOK.setBackground(new Color(0, 0, 255));
		btnOK.setBounds(106, 432, 85, 21);
		panel.add(btnOK);
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnOKClick();
			}
		});
		btnOK.setVisible(false);
		
		cmbLoaiKhach = new JComboBox();
		cmbLoaiKhach.setBounds(10, 192, 288, 32);
		panel.add(cmbLoaiKhach);
		
		JLabel lblDanhSchKhch = new JLabel("Cập nhật phiếu thuê");
		lblDanhSchKhch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDanhSchKhch.setBounds(585, 23, 225, 32);
		contentPane.add(lblDanhSchKhch);
		
		
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Ngày bắt đầu");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(467, 78, 105, 20);
		contentPane.add(lblNewLabel_1_2);
		
		spnNgayThue = new JSpinner(new SpinnerDateModel());
		spnNgayThue.setEnabled(false);
		spnNgayThue.setValue(phieuThue.getNgayThue());
		spnNgayThue.setFont(new Font("Tahoma", Font.BOLD, 15));
		spnNgayThue.setBounds(570, 75, 178, 27);
		contentPane.add(spnNgayThue);
		
		JSpinner spnNgayKetThuc = new JSpinner(new SpinnerDateModel());
		if(phieuThue.getNgayKetThuc() != null) {
			System.out.println("dd");
			spnNgayKetThuc.setValue(phieuThue.getNgayKetThuc());
		}
		else {
			spnNgayKetThuc = new JSpinner();
		}
		spnNgayKetThuc.setEnabled(false);
		spnNgayKetThuc.setFont(new Font("Tahoma", Font.BOLD, 15));
		spnNgayKetThuc.setBounds(879, 75, 178, 27);
		contentPane.add(spnNgayKetThuc);
		
		
		lblPhong = new JLabel(phieuThue.getTenPhong());
		lblPhong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPhong.setBounds(395, 70, 105, 32);
		contentPane.add(lblPhong);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phòng");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(331, 78, 54, 20);
		contentPane.add(lblNewLabel_1_3);
		
		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setForeground(Color.WHITE);
		btnXacNhan.setBackground(Color.BLUE);
		btnXacNhan.setBounds(585, 428, 98, 21);
		contentPane.add(btnXacNhan);
		btnXacNhan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnXacNhanClick();
			}
		});
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(331, 175, 728, 182);
		contentPane.add(scrollPane);
		
		tbDanhSachKhach = new JTable();
		scrollPane.setViewportView(tbDanhSachKhach);
		tbDanhSachKhach.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, ""},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"STT", "Kh\u00E1ch h\u00E0ng", "Lo\u1EA1i kh\u00E1ch", "CMND", "\u0110\u1ECBa ch\u1EC9"
			}
		));
		tbDanhSachKhach.getColumnModel().getColumn(0).setResizable(false);
		tbDanhSachKhach.getColumnModel().getColumn(0).setPreferredWidth(30);
		tbDanhSachKhach.getColumnModel().getColumn(0).setMaxWidth(30);
		tbDanhSachKhach.getColumnModel().getColumn(1).setResizable(false);
		tbDanhSachKhach.getColumnModel().getColumn(2).setResizable(false);
		tbDanhSachKhach.getColumnModel().getColumn(2).setMaxWidth(100);
		tbDanhSachKhach.getColumnModel().getColumn(3).setResizable(false);
		tbDanhSachKhach.getColumnModel().getColumn(3).setMaxWidth(250);
		tbDanhSachKhach.getColumnModel().getColumn(4).setResizable(false);
		tbDanhSachKhach.setBorder(new LineBorder(new Color(0, 0, 0)));
		tbDanhSachKhach.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if( tbDanhSachKhach.getSelectedRow() != -1 && tbDanhSachKhach.getSelectedRow() <= listKhach.size() - 1) {
					loadTableDanhSachKhach();
					btnCapNhat.setVisible(true);
					btnXoa.setVisible(true);
				}
				else {
					btnCapNhat.setVisible(false);
					btnXoa.setVisible(false);
				}
			}
		});
		
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(833, 144, 98, 21);
		contentPane.add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnXoaClick();
			}
		});
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setForeground(Color.WHITE);
		btnCapNhat.setBackground(new Color(222, 184, 135));
		btnCapNhat.setBounds(959, 144, 98, 21);
		contentPane.add(btnCapNhat);
		btnCapNhat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCapNhatClick();
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel(Integer.toString(phieuThue.getId()));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setBounds(808, 24, 67, 27);
		contentPane.add(lblNewLabel_2);
		
		btnHuy = new JButton("Hủy");
		btnHuy.setForeground(Color.BLACK);
		btnHuy.setBackground(Color.WHITE);
		btnHuy.setBounds(712, 428, 98, 21);
		contentPane.add(btnHuy);
		btnHuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
			}
		});
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ngày kết thúc");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(774, 78, 105, 20);
		contentPane.add(lblNewLabel_1_2_1);
		
		
		
		
		//Set cho nút xóa và cập nhật ẩn đi nếu chưa click dòng này trong danh sách khách
		btnXoa.setVisible(false);
		btnCapNhat.setVisible(false);
		
		loadCMBLoaiKhach();
		loadTableDanhSachKhach();
		taoPhieuThue();
	}
	
	protected void loadCMBLoaiKhach() {
		ArrayList<LoaiKhach> listLoaiKhach = LoaiKhachBUS.loadDSLoaiKhach();
		for(LoaiKhach loaiKhach: listLoaiKhach) {
			cmbLoaiKhach.addItem(loaiKhach.getTenLoai());
		}
	}
	
	protected void taoPhieuThue() {
		String strNgayThue = spnNgayThue.getValue().toString();
		Date dateNgayThue = null;
		DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		try {
			dateNgayThue = dateFormat.parse(strNgayThue);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phieuThue.setNgayThue(dateNgayThue);
	}
	protected boolean KiemTraCMNDHopLe(String cmnd) {
		boolean result = true;
		for(int i = 0; i < cmnd.length(); i++) {
			char c = cmnd.charAt(i);
			if( !( c >= '0' && c <= '9' ) ) {// c nằm ngoài khoản (0,9)
				return false;
			}
		}
		return result;
	}
	
	protected boolean kiemTraThongTinKhachHopLe() {
		if(txtHoten.getText().isBlank()){
			JOptionPane.showMessageDialog(null, "Tên khách không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(KiemTraCMNDHopLe(txtSoCMND.getText()) == false) {
			JOptionPane.showMessageDialog(null, "Số CMND không hợp lệ!","Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(txtSoCMND.getText().length() < 5 || txtSoCMND.getText().length() > 15) {
			JOptionPane.showMessageDialog(null, "Số chữ số của CMND nằm trong khoản 5 -> 15 chữ số!","Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(txtDiaChi.getText().isBlank()){
			JOptionPane.showMessageDialog(null, "Địa chỉ khách không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	protected void btnThemClick() {
		int slkToiDa = LoaiPhongBUS.loadLoaiPhongTheoTenPhong(lblPhong.getText()).getSoLuongKhachToiDa();
		if(listKhach.size() >= slkToiDa) {
			JOptionPane.showMessageDialog(null, "Số lượng khách của phòng tối đa không quá " + slkToiDa + " người!");
			return;
		}
		if(kiemTraThongTinKhachHopLe()) {
			int idLoaiKhach = LoaiKhachBUS.LoadMaLoaiKhachTheoTenLoaiKhach(cmbLoaiKhach.getSelectedItem().toString());
			Khach khach = new Khach(0, txtHoten.getText(), txtSoCMND.getText(), txtDiaChi.getText(), idLoaiKhach );
			listKhach.add(khach);
			loadTableDanhSachKhach();
			txtHoten.setText("");
			txtSoCMND.setText("");
			txtDiaChi.setText("");
		}
	}
	
	protected void loadTableDanhSachKhach() {
		int r = 0;
		int c = 0;
		r = tbDanhSachKhach.getRowCount();
		c = tbDanhSachKhach.getColumnCount();
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				tbDanhSachKhach.setValueAt(null, i, j);
			}
		}
		int row = 0;
		for(Khach khach: listKhach) {
			tbDanhSachKhach.setValueAt(row + 1, row, 0);
			tbDanhSachKhach.setValueAt(khach.getHoTen(), row, 1);
			tbDanhSachKhach.setValueAt(LoaiKhachBUS.LoadLoaiKhachTheoID(khach.getLoaiKhach()).getTenLoai(), row, 2);
			tbDanhSachKhach.setValueAt(khach.getCmnd(), row, 3);
			tbDanhSachKhach.setValueAt(khach.getDiaChi(),row, 4);
			row++;
		}
	}

	protected void btnXoaClick() {
		loadTableDanhSachKhach();
		listKhach.remove(tbDanhSachKhach.getSelectedRow());
		loadTableDanhSachKhach();
		tbDanhSachKhach.setSelectionMode(0);
	}
	protected void btnCapNhatClick() {
		btnThem.setVisible(false);
		panel.setBackground(Color.LIGHT_GRAY);
		btnOK.setVisible(true);
		tbDanhSachKhach.setEnabled(false);
		btnXoa.setEnabled(false);
		
		txtHoten.setText(listKhach.get(tbDanhSachKhach.getSelectedRow()).getHoTen());
		txtSoCMND.setText(listKhach.get(tbDanhSachKhach.getSelectedRow()).getCmnd());
		txtDiaChi.setText(listKhach.get(tbDanhSachKhach.getSelectedRow()).getDiaChi());
		cmbLoaiKhach.setSelectedItem(tbDanhSachKhach.getValueAt(tbDanhSachKhach.getSelectedRow(), 2));
	}
	
	protected void btnOKClick() {		
		if(kiemTraThongTinKhachHopLe()) {
			int idLoaiKhach = LoaiKhachBUS.LoadMaLoaiKhachTheoTenLoaiKhach(cmbLoaiKhach.getSelectedItem().toString());
			listKhach.get(tbDanhSachKhach.getSelectedRow()).setCmnd(txtSoCMND.getText());
			listKhach.get(tbDanhSachKhach.getSelectedRow()).setDiaChi(txtDiaChi.getText());
			listKhach.get(tbDanhSachKhach.getSelectedRow()).setHoTen(txtHoten.getText());
			listKhach.get(tbDanhSachKhach.getSelectedRow()).setLoaiKhach(idLoaiKhach);
			loadTableDanhSachKhach();
			txtHoten.setText("");
			txtSoCMND.setText("");
			txtDiaChi.setText("");
			JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "Information!", JOptionPane.INFORMATION_MESSAGE);
			tbDanhSachKhach.setSelectionMode(0);
			tbDanhSachKhach.setEnabled(true);
			btnXoa.setEnabled(true);
			btnOK.setVisible(false);
			panel.setBackground(Color.WHITE);
			btnThem.setVisible(true);
		}
	}
	
	protected void btnXacNhanClick(){
		if(phieuThue.getDanhSachKhach().size() == 0) {
			JOptionPane.showMessageDialog(null, "Phòng thuê phải có ít nhất một khách!","Warning!", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		/*Xóa khách và chi tiết phiếu thuê ban đầu*/
		PhieuThueBUS.XoaChiTietPhieuThueTheoID(phieuThue.getId());
		for(Khach khach: listKhachBanDau) {
			KhachBUS.XoaKhachTheoID(khach.getId());
		}
		//Tạo lại Khách và chi tiết phiếu thuê mới
		for(Khach khach: listKhach) {
			PhieuThueBUS.TaoChiTietPhieuThue(phieuThue.getId(), khach);
		}
		JOptionPane.showMessageDialog(null, "Cập nhật phiếu thuê thành công!","Information!", JOptionPane.INFORMATION_MESSAGE);
		
		contentPane.setVisible(false);
		dispose();
	}
}
