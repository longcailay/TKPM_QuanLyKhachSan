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
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.Scrollable;
import javax.swing.SpinnerDateModel;
import javax.swing.border.TitledBorder;
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

import BUS.LoaiKhachBUS;
import BUS.LoaiPhongBUS;
import BUS.PhongBUS;
import DTO.Khach;
import DTO.LoaiKhach;
import DTO.PhieuThue;



public class ThuePhong extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoten;
	private JTextField txtSoCMND;
	private JTextField txtDiaChi;
	private JComboBox cmbLoaiKhach;
	private JLabel lblPhong;
	private JSpinner spnNgayThue;
	private JTable tbDanhSachKhach;
	
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnCapNhat;
	private JButton btnXacNhan;

	
	private String tenPhong = "102";//Cái này là tạm thời
	private PhieuThue phieuThue = new PhieuThue();
	ArrayList<Khach> listKhach = new ArrayList<Khach>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThuePhong frame = new ThuePhong();
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
	public ThuePhong() {
		setTitle("HoApp - Thuê phòng");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 516);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
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
		
		
		cmbLoaiKhach = new JComboBox();
		cmbLoaiKhach.setBounds(10, 192, 288, 32);
		panel.add(cmbLoaiKhach);
		
		JLabel lblDanhSchKhch = new JLabel("Phiếu thuê phòng");
		lblDanhSchKhch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDanhSchKhch.setBounds(428, 25, 190, 32);
		contentPane.add(lblDanhSchKhch);
		
		
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Ngày bắt đầu thuê");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(521, 78, 139, 20);
		contentPane.add(lblNewLabel_1_2);
		
		spnNgayThue = new JSpinner(new SpinnerDateModel());
		spnNgayThue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spnNgayThue.setBounds(657, 75, 153, 27);
		contentPane.add(spnNgayThue);
		

		
		
		lblPhong = new JLabel(tenPhong);
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
		btnXacNhan.setBounds(600, 428, 98, 21);
		contentPane.add(btnXacNhan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(331, 175, 639, 182);
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
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(749, 144, 98, 21);
		contentPane.add(btnXoa);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setForeground(Color.WHITE);
		btnCapNhat.setBackground(new Color(222, 184, 135));
		btnCapNhat.setBounds(870, 144, 98, 21);
		contentPane.add(btnCapNhat);
		
		//Set cho nút xóa và cập nhật ẩn đi nếu chưa click dòng này trong danh sách khách
		btnXoa.setVisible(false);
		btnCapNhat.setVisible(false);
		
		loadCMBLoaiKhach();
		taoPhieuThue();
	}
	
	void loadCMBLoaiKhach() {
		ArrayList<LoaiKhach> listLoaiKhach = LoaiKhachBUS.loadDSLoaiKhach();
		for(LoaiKhach loaiKhach: listLoaiKhach) {
			cmbLoaiKhach.addItem(loaiKhach.getTenLoai());
		}
	}
	
	void taoPhieuThue() {
		String strNgayThue = spnNgayThue.getValue().toString();
		Date dateNgayThue = null;
		DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		try {
			dateNgayThue = dateFormat.parse(strNgayThue);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int idPhong = PhongBUS.LayThongTinPhongTheoTenPhong(lblPhong.getText()).getId();
		int idNguoiDung = HomePage.nguoiDung.getId();
		phieuThue = new PhieuThue(0, dateNgayThue, null, 0, idPhong, idNguoiDung , lblPhong.getText(), null);
	}
	private boolean KiemTraCMNDHopLe(String cmnd) {
		boolean result = true;
		for(int i = 0; i < cmnd.length(); i++) {
			char c = cmnd.charAt(i);
			if( !( c >= '0' && c <= '9' ) ) {// c nằm ngoài khoản (0,9)
				return false;
			}
		}
		return result;
	}
	
	boolean kiemTraThongTinKhachHopLe() {
		if(txtHoten.getText().isBlank()){
			JOptionPane.showMessageDialog(null, "Tên khách không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(KiemTraCMNDHopLe(txtSoCMND.getText()) == false) {
			JOptionPane.showMessageDialog(null, "Số CMND không hợp lệ!","Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(txtSoCMND.getText().length() < 5 || txtSoCMND.getText().length() > 20) {
			JOptionPane.showMessageDialog(null, "Số chữ số của CMND nằm trong khoản 5 -> 20 chữ số!","Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(txtDiaChi.getText().isBlank()){
			JOptionPane.showMessageDialog(null, "Địa chỉ khách không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	void btnThemClick() {
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
		}
	}
	
	void loadTableDanhSachKhach() {
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
}
