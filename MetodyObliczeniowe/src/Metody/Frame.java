package Metody;
import java.awt.EventQueue;

import javax.swing.JApplet;
import javax.swing.JFrame;


 class MyFrame extends JFrame
{
	public MyFrame()
	{
		super("MetodyObliczeniowe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300,300);
		setLocation(500,300);
		
	}
}
 
 class JComboBox extends JApplet{
	 JLabel jlab;
 }
 

public class Frame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new MyFrame();
			}
			
		});
		}

	}
