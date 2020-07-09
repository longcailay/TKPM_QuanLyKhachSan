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

import BUS.PhongBUS;
import DAO.LoaiPhongDAO;
import DTO.LoaiPhong;
import DTO.Phong;
import WSPACE.wsQuanLyPhong;

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
import java.util.ArrayList;
import java.awt.Label;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class SuaPhong extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenPhong;
	private JComboBox cmbLoaiPhong;
	private JEditorPane edpGhiChu;
	private JButton btnSua;
	private JButton btnHuy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuaPhong frame = new SuaPhong();
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
	public SuaPhong() {
		setResizable(false);
		setTitle("HoApp - Sửa phòng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 475);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.desktop);
		contentPane.setBorder(null);
		contentPane.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		contentPane.setBackground(SystemColor.text);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("S\u1EEDa ph\u00F2ng");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(186, 10, 162, 28);
		contentPane.add(lblNewLabel);
		
		Label label = new Label("Tên phòng");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(94, 62, 101, 33);
		contentPane.add(label);
		
		txtTenPhong = new JTextField();
		txtTenPhong.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTenPhong.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenPhong.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTenPhong.setBounds(222, 62, 199, 33);
		contentPane.add(txtTenPhong);
		txtTenPhong.setColumns(10);
		txtTenPhong.setText(wsQuanLyPhong.lblPhong.getText());
		txtTenPhong.setEditable(false);
		
		Label label_2 = new Label("Ghi chú");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(94, 160, 101, 33);
		contentPane.add(label_2);
		
		cmbLoaiPhong = new JComboBox();
		cmbLoaiPhong.setBounds(222, 111, 199, 33);
		contentPane.add(cmbLoaiPhong);
		loadLoaiPhong();
		
		Label label_2_1 = new Label("Loại phòng");
		label_2_1.setForeground(Color.BLACK);
		label_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2_1.setBounds(94, 111, 101, 33);
		contentPane.add(label_2_1);
		
		edpGhiChu = new JEditorPane();
		edpGhiChu.setToolTipText("");
		edpGhiChu.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0))));
		edpGhiChu.setBounds(94, 199, 327, 125);
		contentPane.add(edpGhiChu);
		
		btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(0, 102, 255));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSua.setBounds(94, 368, 117, 33);
		contentPane.add(btnSua);
		btnSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSuaClick();
			}
		});
		
		
		btnHuy = new JButton("Hủy");
		btnHuy.setForeground(SystemColor.desktop);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnHuy.setBackground(SystemColor.text);
		btnHuy.setBounds(304, 368, 117, 33);
		contentPane.add(btnHuy);
		btnHuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
			}
		});
		
		loadThongTinPhongDangSua();
		
	}
	
	 void loadLoaiPhong() {
		 ArrayList<LoaiPhong> listLoaiPhong = LoaiPhongDAO.loadDSLoaiPhong();
		 for(LoaiPhong loaiPhong: listLoaiPhong) {
			 cmbLoaiPhong.addItem(loaiPhong.getTenLoai());
		 } 
	 }
	 
	 void loadThongTinPhongDangSua() {
		 Phong phong = PhongBUS.LayThongTinPhongTheoTenPhong(wsQuanLyPhong.lblPhong.getText());
		 cmbLoaiPhong.setSelectedItem(phong.getLoaiPhong());
		 edpGhiChu.setText(phong.getGhiChu());
	 }
	 
	 void btnSuaClick() {
		 if(PhongBUS.SuaPhong(txtTenPhong.getText(), cmbLoaiPhong.getSelectedItem().toString(), edpGhiChu.getText()) != -1) {
			 JOptionPane.showMessageDialog(null, "Sửa thành công!", "Information", JOptionPane.INFORMATION_MESSAGE);
			 txtTenPhong.setText("");
			 edpGhiChu.setText("");
			 wsQuanLyPhong.btnChiTietPhong.doClick();
			 wsQuanLyPhong.btnTimKiem.doClick();
			 setVisible(false);
			 dispose();
		 }else {
			 txtTenPhong.setText("");
		 }
	 }
	 
	 
	 @Override
	public void setDefaultCloseOperation(int operation) {
		// TODO Auto-generated method stub
		 operation = 1;
		super.setDefaultCloseOperation(operation);
	}
}
