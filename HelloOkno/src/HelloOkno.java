import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


 class MyFrame extends JFrame
{
	public MyFrame()
	{
		super("Hello World");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300,300);
		setLocation(50,30);
		
		setLayout(new FlowLayout(FlowLayout.CENTER));// ustawia Layout // left center right

//		add(new JButton("Przycisk 1"));
//		add(new JButton("Przycisk 2"));
//		add(new JButton("Przycisk 3"));
		
		setLayout(new GridLayout(2,2)); // stworz siatke pierwsze to kolumy 2 wiersze
		for(int i=0;i<10;i++)
			add(new JButton(""+(i+1)));
	}
}

public class HelloOkno {

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


