import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class Easy_Draw extends JPanel {

	private BufferedImage image;
	
	public Easy_Draw()
	{
		super();
		File imageFile = new File("java.jpg");
		
		try{
			image = ImageIO.read(imageFile);
		}catch(IOException e){
			System.err.println("blad odczytu obrazka");
			e.printStackTrace();
		}
		Dimension dimension = new Dimension(image.getWidth(),image.getHeight());
		setPreferredSize(dimension);
		
		}
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, this);
	}
	
}
