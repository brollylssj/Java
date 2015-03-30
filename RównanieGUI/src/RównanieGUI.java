import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class RównanieGUI extends JFrame implements ActionListener {
	
	private JTextField tA, tB, tC, tWynik;
	private JLabel lA,lB,lC;
	JLabel lequation;
	private JButton bExit,bRozwiaz;
	
	public RównanieGUI()
	{
		setSize(330,200);
		setTitle("Rozwiaz rownanie kwadratowe");
		setLayout(null);
		
		
		lequation = new JLabel("Równianie kwadratowe:");
		lequation.setBounds(90, 1, 200, 20);
		add(lequation);
		
		
		//pole tekstowe A
		lA = new JLabel("a",JLabel.RIGHT);
		lA.setBounds(60, 30, 20, 20);
		add(lA);
		tA = new JTextField();
		tA.setBounds(80, 30, 40, 20);
		add(tA);
		tA.setToolTipText("Podaj wyk³adnik a");
		
		//pole tekstowe b
		
		lB = new JLabel("b",JLabel.RIGHT);
		lB.setBounds(120, 30, 20, 20);
		add(lB);
		
		
				tB = new JTextField();
				tB.setBounds(140, 30, 40, 20);
				add(tB);
				tB.setToolTipText("Podaj wyk³adnik B");
				
				//pole tekstowe C
				
				lC = new JLabel("c",JLabel.RIGHT);
				lC.setBounds(180, 30, 20, 20);
				add(lC);
				
				
				tC = new JTextField();
				tC.setBounds(200, 30, 40, 20);
				add(tC);
				tC.setToolTipText("Podaj wyk³adnik C");
				
				
				// button wyjscie
				bExit = new JButton("Koniec");
				bExit.setBounds(180, 100, 100, 20);
				bExit.addActionListener(this);
				add(bExit);
				
				
				// button rozwiaz
				bRozwiaz = new JButton("Rozwiaz");
				bRozwiaz.setBounds(60, 100, 100, 20);
				bRozwiaz.addActionListener(this);
				add(bRozwiaz);
				
				
				
				// pole tekstowe wyniku
				
				tWynik = new JTextField();
				tWynik.setBounds(80, 70, 160, 20);
				tWynik.addActionListener(this);
				add(tWynik);
				
		
	}

	public static void main(String[] args) {
		
		
		RównanieGUI aplication = new RównanieGUI();
		aplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplication.setVisible(true);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if( source == bExit)
		{
			dispose();
		}
		
		else if ( source == bRozwiaz)
		{
			try{
				
			int a= Integer.parseInt(tA.getText());
			int b= Integer.parseInt(tB.getText());
			int c= Integer.parseInt(tC.getText());
			
			Rownanie rownanie = new Rownanie(a,b,c);
			String rozwiazanie = rownanie.make();
			tWynik.setText(rozwiazanie);
			
			}catch(NumberFormatException exec)
			{
				tWynik.setText("Nieodpowiedna dana");
			}
			
			
			
			
		}
		
	}
	
	
	

}
