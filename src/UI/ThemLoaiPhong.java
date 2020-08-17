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

import BUS.LoaiPhongBUS;
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

public class ThemLoaiPhong extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenLoaiPhong;
	private JButton btnThem;
	private JButton btnHuy;
	private JTextField txtSoKhachBT;
	private Label label_2;
	private Label label_3;
	private Label label_4;
	private JTextField txtSoKhachTD;
	private JTextField txtDonGia;
	private JTextField txtPhuThu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemLoaiPhong frame = new ThemLoaiPhong();
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
	public ThemLoaiPhong() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				HomePage.pnMenu.setVisible(true);
			}
		});
		
		setResizable(false);
		setTitle("HoApp - Thêm loại phòng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 651, 522);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.desktop);
		contentPane.setBorder(null);
		contentPane.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		contentPane.setBackground(SystemColor.text);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm loại phòng");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(254, 10, 162, 28);
		contentPane.add(lblNewLabel);
		
		txtTenLoaiPhong = new JTextField();
		txtTenLoaiPhong.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTenLoaiPhong.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenLoaiPhong.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTenLoaiPhong.setBounds(344, 62, 199, 33);
		contentPane.add(txtTenLoaiPhong);
		txtTenLoaiPhong.setColumns(10);
		
		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(0, 102, 255));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnThem.setBounds(135, 414, 117, 33);
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
		btnHuy.setBounds(395, 414, 117, 33);
		contentPane.add(btnHuy);
		
		txtSoKhachBT = new JTextField();
		txtSoKhachBT.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoKhachBT.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtSoKhachBT.setColumns(10);
		txtSoKhachBT.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtSoKhachBT.setBounds(344, 131, 199, 33);
		contentPane.add(txtSoKhachBT);
		
		Label label = new Label("Tên loại phòng");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(94, 62, 139, 33);
		contentPane.add(label);
		
		Label label_1 = new Label("Số khách bình thường");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(94, 131, 229, 33);
		contentPane.add(label_1);
		
		label_2 = new Label("Số khách tối đa");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(94, 195, 229, 33);
		contentPane.add(label_2);
		
		label_3 = new Label("Đơn giá");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(94, 261, 101, 33);
		contentPane.add(label_3);
		
		label_4 = new Label("Phụ thu");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(94, 328, 101, 33);
		contentPane.add(label_4);
		
		txtSoKhachTD = new JTextField();
		txtSoKhachTD.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoKhachTD.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtSoKhachTD.setColumns(10);
		txtSoKhachTD.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtSoKhachTD.setBounds(344, 195, 199, 33);
		contentPane.add(txtSoKhachTD);
		
		txtDonGia = new JTextField();
		txtDonGia.setHorizontalAlignment(SwingConstants.CENTER);
		txtDonGia.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtDonGia.setColumns(10);
		txtDonGia.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtDonGia.setBounds(344, 261, 199, 33);
		contentPane.add(txtDonGia);
		
		txtPhuThu = new JTextField();
		txtPhuThu.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhuThu.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPhuThu.setColumns(10);
		txtPhuThu.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtPhuThu.setBounds(344, 328, 199, 33);
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
		 int result = LoaiPhongBUS.ThemLoaiPhong(txtTenLoaiPhong.getText(), txtDonGia.getText(), txtSoKhachBT.getText(), txtSoKhachTD.getText(),txtPhuThu.getText());
		 switch (result) {
			 case -1:
				 txtTenLoaiPhong.setText("");
				 break;
			 case -2:
				 txtDonGia.setText("");
				 break;
			 case - 3:
				 txtSoKhachBT.setText("");
				 break;
			 case -4:
				 txtSoKhachTD.setText("");
				 break;
			 case -5:
				 txtPhuThu.setText("");
				 break;
			default:
				txtTenLoaiPhong.setText("");
				txtDonGia.setText("");
				txtSoKhachBT.setText("");
				txtSoKhachTD.setText("");
				txtPhuThu.setText("");
				wsCaiDat.listLoaiPhong = LoaiPhongBUS.loadDSLoaiPhong();
				HomePage.btnCaiDat.doClick();
				break;
			
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
