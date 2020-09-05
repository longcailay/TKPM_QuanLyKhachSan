package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import BUS.DangNhapBUS;

import DTO.NguoiDung;


import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Label;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JButton btnDangNhap;
	private JButton btnHuy;
	private JPasswordField txtMatKhau;
	private JLabel lblThongBao;
	public static NguoiDung nguoiDung;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	public DangNhap() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				HomePage.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			}
		});		
		setResizable(false);
		setTitle("HoApp - Đăng nhập");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 440);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.desktop);
		contentPane.setBorder(null);
		contentPane.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		contentPane.setBackground(SystemColor.text);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0103ng nh\u1EADp t\u00E0i kho\u1EA3n");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(161, 10, 199, 28);
		contentPane.add(lblNewLabel);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblThongBao.setText("");
			}
		});
		txtTaiKhoan.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		txtTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTaiKhoan.setBounds(222, 91, 199, 33);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		btnDangNhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDangNhap.setBackground(new Color(0, 102, 255));
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDangNhap.setBounds(94, 317, 124, 33);
		contentPane.add(btnDangNhap);
		btnDangNhap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnDangNhapClick();
			}
		});
		
		btnHuy = new JButton("Tho\u00E1t");
		btnHuy.setForeground(SystemColor.desktop);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuy.setBackground(SystemColor.text);
		btnHuy.setBounds(304, 317, 117, 33);
		contentPane.add(btnHuy);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblThongBao.setText("");
			}
		});
		txtMatKhau.setBounds(222, 165, 199, 33);
		contentPane.add(txtMatKhau);
		
		lblThongBao = new JLabel();
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblThongBao.setBounds(94, 228, 327, 21);
		contentPane.add(lblThongBao);
		
		JLabel lblTiKhon = new JLabel("Tài khoản");
		lblTiKhon.setForeground(Color.BLACK);
		lblTiKhon.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTiKhon.setBounds(73, 96, 134, 28);
		contentPane.add(lblTiKhon);
		
		JLabel lblTiKhon_1 = new JLabel("Mật khẩu");
		lblTiKhon_1.setForeground(Color.BLACK);
		lblTiKhon_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTiKhon_1.setBounds(73, 170, 134, 28);
		contentPane.add(lblTiKhon_1);
		btnHuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
			}
		});
		
	}
	void btnDangNhapClick() {
		if(txtTaiKhoan.getText().isBlank() || txtMatKhau.getText().isBlank()) {
			lblThongBao.setText("Vui lòng nhập đầy đủ thông tin!");
		}
		else {
			nguoiDung = DangNhapBUS.LoadNguoiDungTheoTaiKhoanVaMatKhau(txtTaiKhoan.getText(), txtMatKhau.getText());
			if(nguoiDung == null) {
				lblThongBao.setText("Tài khoản hoặc mật khẩu không chính xác!");
				txtTaiKhoan.setText("");
				txtMatKhau.setText("");
			}
			else {
				//System.out.println("KK:\n" +  nguoiDung.getId() + "\nTen " + nguoiDung.getTaiKhoan());
				if(nguoiDung.getPhanQuyen() == 1) {
					phanQuyenAdmin();
				}
				if(nguoiDung.getPhanQuyen() == 2) {
					phanQuyenNhanVien();
				}
				UI.HomePage.nguoiDung = nguoiDung;
				Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
				UI.HomePage.frame.setMaximumSize(DimMax);

				UI.HomePage.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
				UI.HomePage.frame.setVisible(true);
				setVisible(false);
			}
		}
	}
	
	void phanQuyenAdmin() {
		//btnNhanVien.setBounds(0, 400, 270, 73);
		UI.HomePage.btnNhanVien.setVisible(true);
				
				
				//btnBaoCao.setBounds(0, 472, 270, 73);
		UI.HomePage.btnBaoCao.setVisible(true);
				
			
				//btnCaiDat.setBounds(0, 542, 270, 79);
		UI.HomePage.btnCaiDat.setVisible(true);
				
				//btnThanhToan.setBounds(0, 181, 270, 73);
			
				
				
		UI.HomePage.btnDangXuat.setBounds(0, 619, 270, 79);
		
		
		
	}
	
	void phanQuyenNhanVien() {//Cài đặt lại các chức năng dựa theo admin hay nhân viên
		
		//btnNhanVien.setBounds(0, 400, 270, 73);
		UI.HomePage.btnNhanVien.setVisible(false);
		
		
		//btnBaoCao.setBounds(0, 472, 270, 73);
		UI.HomePage.btnBaoCao.setVisible(false);
		
	
		//btnCaiDat.setBounds(0, 542, 270, 79);
		UI.HomePage.btnCaiDat.setVisible(false);
		
		//btnThanhToan.setBounds(0, 181, 270, 73);
	
		
		
		UI.HomePage.btnDangXuat.setBounds(0, 400, 270, 73);
		
	}
}
