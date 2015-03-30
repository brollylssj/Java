import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Window extends JFrame implements ActionListener{
	
	// podane by widoczne byly
	JButton bPodajDate, bexit;
	JLabel ldata;
	public Window()
	{
		setSize(800,600);
		setTitle("Okno");
		bPodajDate = new JButton("Podaj Date");
		setLayout(null);
		bPodajDate.setBounds(200,100,200,200);
		bPodajDate.setForeground(new Color(205,205,15));
		add(bPodajDate);
		bPodajDate.addActionListener(this);
		
		// przycisk exit
		 bexit = new JButton("Exit");
		
		bexit.setBounds(600, 2, 150, 50);
		bexit.setForeground(Color.RED);
		add(bexit);
		bexit.addActionListener(this);
		
		
		
		//etykieta -data
		
		ldata = new JLabel ("Data:");
		ldata.setBounds(200, 300, 400, 300);
		ldata.setForeground(Color.GREEN);
		ldata.setFont(new Font("SansSerif",Font.BOLD,20));
		add(ldata);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	
	// utworzenie obiektu w klasy moje okienko
	Window w = new Window();
	
	// zdefiniowanie reakcji po zamknieciu okienka 
	// niszczenie okienka
	w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	w.setVisible(true);
		
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object source = e.getSource();
		//bPodajDate nie jest widziany
		if(source == bPodajDate)
		//System.out.println(new Date());
		ldata.setText(new Date().toString());
		else if (source == bexit)
		dispose();
	}

}