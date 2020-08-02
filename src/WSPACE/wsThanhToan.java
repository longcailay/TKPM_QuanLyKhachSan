package WSPACE;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class wsThanhToan extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table_1;
	private JTextField textField_6;
	public wsThanhToan() {
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 523, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
				.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel_2 = new JLabel("Hóa đơn thanh toán");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_3_4 = new JLabel("Khách hàng/ Cơ quan");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.RED);
		textField_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		textField_4.setDisabledTextColor(Color.BLACK);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setForeground(Color.RED);
		textField_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		textField_5.setDisabledTextColor(Color.BLACK);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("Địa chỉ");
		lblNewLabel_3_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_3_4_1_1 = new JLabel("Phiếu thuê");
		lblNewLabel_3_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setEnabled(false);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Trị giá");
		lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textField_6 = new JTextField();
		textField_6.setForeground(Color.RED);
		textField_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		textField_6.setEnabled(false);
		textField_6.setDisabledTextColor(Color.BLACK);
		textField_6.setColumns(10);
		
		JButton btntLi = new JButton("Đặt lại");
		btntLi.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JButton btnHonTt = new JButton("Hoàn tất");
		btnHonTt.setForeground(Color.WHITE);
		btnHonTt.setBackground(Color.BLUE);
		btnHonTt.setFont(new Font("Tahoma", Font.BOLD, 10));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(30)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_3_4_1_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3_4_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3_4, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3_2_1_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(145)
							.addComponent(btntLi, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnHonTt, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(75)
					.addComponent(lblNewLabel_3_4, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3_4_1, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(lblNewLabel_3_4_1_1, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_2_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btntLi, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHonTt, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 phi\u1EBFu", "Ph\u00F2ng", "S\u1ED1 ng\u00E0y", "\u0110\u01A1n gi\u00E1", "Ph\u1EE5 thu", "Ti\u1EC1n"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(50);
		scrollPane_1.setViewportView(table_1);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Tên phòng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setForeground(Color.RED);
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		textField.setDisabledTextColor(Color.BLACK);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ngày thuê");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_3_2 = new JLabel("Ngày trả");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_3_3 = new JLabel("Khách");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		//jScrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Tiền phòng");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnThmVoHa = new JButton("Thêm vào hóa đơn");
		btnThmVoHa.setForeground(Color.WHITE);
		btnThmVoHa.setBackground(Color.BLUE);
		btnThmVoHa.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setForeground(Color.RED);
		textField_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		textField_1.setDisabledTextColor(Color.BLACK);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setForeground(Color.RED);
		textField_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		textField_2.setDisabledTextColor(Color.BLACK);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.RED);
		textField_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		textField_3.setEnabled(false);
		textField_3.setDisabledTextColor(Color.BLACK);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_3_5 = new JLabel("Chọn phiếu");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_2_1 = new JLabel("Thêm phiếu thuê vào hóa đơn");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(135)
					.addComponent(lblNewLabel_3_2_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(121, Short.MAX_VALUE)
					.addComponent(btnThmVoHa, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(118))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3_5, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3_2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
							.addGap(67))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_5)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addComponent(lblNewLabel_3_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_2_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnThmVoHa, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"STT", "Kh\u00E1ch h\u00E0ng", "Lo\u1EA1i kh\u00E1ch"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		table.getColumnModel().getColumn(2).setMaxWidth(400);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}
}
