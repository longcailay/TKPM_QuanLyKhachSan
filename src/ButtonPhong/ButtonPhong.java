package ButtonPhong;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Label;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Point;
import java.awt.Color;
import javax.swing.JPanel;

public class ButtonPhong extends JButton{	
	
	//Cách access một file ảnh từ resource (folder res)
	private BufferedImage loadBufferedImage(String string)
	{
	    try
	    {
	        BufferedImage bi = ImageIO.read(this.getClass().getResource(string));
	        return bi;
	    } catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	//Icon icon = new ImageIcon(loadBufferedImage("/images/roomA.png"));
	
			//Icon icon = new ImageIcon("/images/roomA.png");
	//this.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\roomB.png"));
			//this.setText("99999999999999");
	public ButtonPhong(int id, String tenPhong, String pathImage) {
		setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setVerticalAlignment(SwingConstants.TOP);
		setName(Integer.toString(id));
		setText(tenPhong);
		setVerticalTextPosition(SwingConstants.TOP);
		Icon icon = new ImageIcon(loadBufferedImage(pathImage.toString()));
		setIcon(icon);
		setHorizontalTextPosition(SwingConstants.LEADING);
	}

	@Override
	public void doLayout() {
		super.doLayout();
		 int preferredWidth = getPreferredSize().width;
	        int actualWidth = getSize().width;

	        if (actualWidth != preferredWidth)
	        {
	            int gap = getIconTextGap() + actualWidth - preferredWidth;
	            gap = Math.max(gap, UIManager.getInt("Button.iconTextGap"));
	            setIconTextGap(gap);
	        }
	}
}
