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

import BUS.LoaiKhachBUS;
import BUS.PhongBUS;
import DAO.LoaiPhongDAO;
import DTO.LoaiPhong;
import WSPACE.wsCaiDat;

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

public class ThemLoaiKhach extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenLoai;
	private JButton btnThem;
	private JButton btnHuy;
	private JTextField txtPhuThu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemLoaiKhach frame = new ThemLoaiKhach();
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
	public ThemLoaiKhach() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				HomePage.pnMenu.setVisible(true);
			}
		});
		
		setResizable(false);
		setTitle("HoApp - Thêm khách mới");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 357);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.desktop);
		contentPane.setBorder(null);
		contentPane.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		contentPane.setBackground(SystemColor.text);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th\u00EAm lo\u1EA1i kh\u00E1ch");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(161, 10, 162, 28);
		contentPane.add(lblNewLabel);
		
		Label label = new Label("T\u00EAn lo\u1EA1i");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(94, 62, 101, 33);
		contentPane.add(label);
		
		txtTenLoai = new JTextField();
		txtTenLoai.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTenLoai.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenLoai.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTenLoai.setBounds(222, 62, 199, 33);
		contentPane.add(txtTenLoai);
		txtTenLoai.setColumns(10);
		
		
		Label label_2_1 = new Label("Ph\u1EE5 thu");
		label_2_1.setForeground(Color.BLACK);
		label_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2_1.setBounds(94, 147, 101, 33);
		contentPane.add(label_2_1);
		
		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(0, 102, 255));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThem.setBounds(94, 237, 117, 33);
		contentPane.add(btnThem);
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
		btnHuy.setBounds(299, 237, 117, 33);
		contentPane.add(btnHuy);
		
		txtPhuThu = new JTextField();
		txtPhuThu.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhuThu.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPhuThu.setColumns(10);
		txtPhuThu.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtPhuThu.setBounds(222, 147, 199, 33);
		contentPane.add(txtPhuThu);
		btnHuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
			}
		});
		
		
	}
	
	
	 
	 void btnThemClick() {
		 int result = LoaiKhachBUS.ThemLoaiKhach(txtTenLoai.getText(), txtPhuThu.getText());
		 if(result == -1) {
			 txtTenLoai.setText("");
		 }
		 else {
			 if(result == -2)
			 {
				 txtPhuThu.setText("");
			 }
			 else {
				 txtTenLoai.setText("");
				 txtPhuThu.setText("");
				 wsCaiDat.listLoaiKhach = LoaiKhachBUS.loadDSLoaiKhach();
				 HomePage.btnCaiDat.doClick();
			 }
		 }
		 
	 }
	 
	 
	 //Do lúc ta nhấn Exit Form thêm phòng mới, Homepage exit theo nên mới dùng code bên dưới
	 @Override
	public void setDefaultCloseOperation(int operation) {
		// TODO Auto-generated method stub
		 operation = 1;
		super.setDefaultCloseOperation(operation);
	}
}
