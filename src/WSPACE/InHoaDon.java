package WSPACE;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.print.PrinterException;
import java.text.AttributedString;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import DTO.ChiTietPhong;
import DTO.PhieuThueChiTiet;

import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JTextArea;
public class InHoaDon extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InHoaDon frame = new InHoaDon();
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
	public InHoaDon() {
		if(wsThanhToan.dsPTCT.size() == 0) {
			return;
		}
		else {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 865, 573);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 851, 526);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JTextArea textArea = new JTextArea();
			textArea.setBounds(10, 10, 831, 506);
			panel.add(textArea);
			
			String tenKhachSan = "\t\tVINA HOTEL\n";
			String diaChi = "Địa chỉ: 18 Lữ Gia - Phường 15 - Quận 11 - TP. Hồ Chí Minh\n";
			String dienThoai = "Điện thoại: 030 943 5151\n";
			String website = "Website: vinahotel.vn\n";
			
			String gach = "\n=====================================================\n";
			
			String hoaDon = "\n\t\tHÓA ĐƠN THANH TOÁN\n";
			String khachHang = "Khách hàng: " +   wsThanhToan.txtKhachHang.getText()  + "\n";
			String diaChiKH = "Địa chỉ: " + wsThanhToan.txtDiaChi.getText() + "\n\n";
			String pattern = "dd-MM-yyyy";
			String ngayLap =  (new SimpleDateFormat(pattern).format(new Date())).toString() +  "\t\t";
			String maHoaDon = "Mã hóa đơn: " + wsThanhToan.idHoaDon +"\n\n";
			
			
			String header = "Mã phiếu   Phòng   Số ngày   Đơn giá         Phụ thu         Tiền\n\n";
			//11,19,29,45,61
			
			String content = "";
			String temp = "                                                                                                                 ";
			
			for(PhieuThueChiTiet ptct : wsThanhToan.dsPTCT) {
				String line = "";
				line += (ptct.getId() + temp).substring(0,16);
				line += (ptct.getTenPhong() + temp);
				line = line.substring(0,26);
				line += (ptct.getSoNgay() + temp);
				line = line.substring(0,41);
				line += (ptct.getDonGia() + temp);
				line = line.substring(0,56);
				line += (ptct.getPhuThu() + temp).substring(0,69);
				line = line.substring(0,69);
				line += (ptct.getTien() + temp).substring(0,95);
				line = line.substring(0,81);
				line += "\n";
				content += line;
			}
				
			
			
			String triGia = "\n\n\t\t\tTrị giá: " + wsThanhToan.txtTriGia.getText();
			
			String text = tenKhachSan + diaChi + dienThoai + website + gach + hoaDon + khachHang + diaChiKH + ngayLap + maHoaDon + gach + header + content + gach + triGia;
			textArea.setText(text);
			
			
			try {
			    boolean complete = textArea.print();
			    if (complete) {
			        JOptionPane.showMessageDialog(null, "In hóa đơn thành công!","Information!",JOptionPane.INFORMATION_MESSAGE);
			    } else {
			    	JOptionPane.showMessageDialog(null, "In hóa đơn đã bị hủy!","Information!",JOptionPane.INFORMATION_MESSAGE);
			    }
			} catch (PrinterException pe) {
				JOptionPane.showMessageDialog(null, "In hóa đơn thất bại!","Error!",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
