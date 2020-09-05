package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.sun.net.httpserver.Authenticator.Success;

import BUS.NguoiDungBUS;
import DAO.PhanQuyenDAO;

import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.Label;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.event.WindowAdapter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

public class ThemNguoiDung extends JFrame {
	private JPanel contentPane;
	private JButton btnThem;
	private JButton btnHuy;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtHoTen;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;
	private JComboBox cmbPhanQuyen;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemNguoiDung frame = new ThemNguoiDung();
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
	public ThemNguoiDung() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				HomePage.pnMenu.setVisible(true);
			}
		});
		
		setResizable(false);
		setTitle("HoApp - Thêm nhân viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 781, 557);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.desktop);
		contentPane.setBorder(null);
		contentPane.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Th\u00F4ng tin nh\u00E2n vi\u00EAn");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(0, 102, 255));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnThemClick();
			}
		});
		
		
		btnHuy = new JButton("Hủy");
		btnHuy.setForeground(SystemColor.desktop);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnHuy.setBackground(SystemColor.text);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "T\u00E0i kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Th\u00F4ng tin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addGap(100)
									.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addGap(200))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(panel, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
									.addGap(14)))
							.addGap(0))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 757, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(25))
		);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(32, 59, 77, 17);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("CMND");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(32, 119, 77, 17);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("S\u0110T");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(32, 173, 77, 17);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(32, 219, 77, 17);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Ph\u00E2n quy\u1EC1n");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(32, 275, 92, 17);
		panel_1.add(lblNewLabel_5);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(136, 60, 219, 19);
		panel_1.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(136, 120, 219, 19);
		panel_1.add(txtCMND);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(136, 174, 219, 19);
		panel_1.add(txtSDT);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(136, 220, 219, 19);
		panel_1.add(txtDiaChi);
		
		cmbPhanQuyen = new JComboBox();
		cmbPhanQuyen.setBounds(134, 275, 221, 21);
		panel_1.add(cmbPhanQuyen);
		panel.setLayout(null);
		loadCMBPhanQuyen();
		
		
		lblNewLabel_6 = new JLabel("T\u00E0i kho\u1EA3n");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(27, 93, 80, 13);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(27, 203, 80, 13);
		panel.add(lblNewLabel_7);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(117, 92, 176, 19);
		panel.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(117, 202, 176, 19);
		panel.add(txtMatKhau);
		contentPane.setLayout(gl_contentPane);
		btnHuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
			}
		});
		
		
	}
	
	 void loadCMBPhanQuyen() {
		 ArrayList<String> tenPhanQuyen = PhanQuyenDAO.loadDSTenPhanQuyen();
		 for(String ten: tenPhanQuyen) {
			 cmbPhanQuyen.addItem(ten);
		 }
	 }
	 
	 void btnThemClick() {
		 int temp = NguoiDungBUS.ThemNguoiDungMoi(txtHoTen.getText(),txtCMND.getText(),txtSDT.getText(),txtDiaChi.getText(),txtTaiKhoan.getText(),txtMatKhau.getText(),cmbPhanQuyen.getSelectedItem().toString());
		 if(temp == 1) {
			 //JOptionPane.showMessageDialog(null, "Thêm thành công!", "Information", JOptionPane.INFORMATION_MESSAGE);
			 txtHoTen.setText("");
			 txtCMND.setText("");
			 txtSDT.setText("");
			 txtDiaChi.setText("");
			 txtTaiKhoan.setText("");
			 txtMatKhau.setText("");
			 HomePage.btnNhanVien.doClick();
		 }
		 else {
			 switch(temp) {
			 	case -1:
			 		txtHoTen.setText("");
			 		break;
			 	case -2:
			 		txtCMND.setText("");
					break;
			 	case -3:
			 		txtSDT.setText("");
					break;
			 	case -4:
			 		txtDiaChi.setText("");
					break;
			 	case -5:
			 		txtTaiKhoan.setText("");
					break;
			 	case -6:
				 	txtMatKhau.setText("");
				 	break;
			 }
		 }
		 
//		 if(NguoiDungBUS.ThemNguoiDungMoi(txtTenNguoiDung.getText(), edpGhiChu.getText(), cmbLoaiNguoiDung.getSelectedItem().toString()) != -1) {
//			 JOptionPane.showMessageDialog(null, "Thêm thành công!", "Information", JOptionPane.INFORMATION_MESSAGE);
//			 txtTenNguoiDung.setText("");
//			 edpGhiChu.setText("");
//			 WSPACE.wsQuanLyNguoiDung.btnTimKiem.doClick();
//		 }else {
//			 txtTenNguoiDung.setText("");
//		 }
	 }
	 
	 
	 @Override
	public void setDefaultCloseOperation(int operation) {
		// TODO Auto-generated method stub
		 operation = 1;
		super.setDefaultCloseOperation(operation);
	}
}
