import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;


public class CelcToFar extends JFrame implements ActionListener {
	
	
	
	private JLabel lCel,lFar;
	private JTextField tCel,tFar;
	private JButton bKonwertuj, bExit;
	private JCheckBox ChHuge;
	private double tempCel,tempFar;
	private ButtonGroup bgRozmiar;
	private JRadioButton Rsmall,Rmedium,Rlarge;
	
	private JRadioButton FartoCel,CeltoFar;
	private ButtonGroup Panel;
	
	
	private JSlider sCel,sFar;
	private int temCel,temFar;
	
	CelcToFar()
	{
		setSize(500,300);
		setTitle("Przeliczanie");
		setLayout(null);
		
		lCel= new JLabel("Stopnie Celcjusza:");
		lCel.setBounds(20, 20, 150, 20);
		add(lCel);
		
		
		
		tCel = new JTextField();
		tCel.setBounds(170, 20, 150, 20);
		// pokazuje napis po najezdzie myszka na to
		tCel.setToolTipText("Podaj temperature w Celcjuszach");
		add(tCel);
		tCel.addActionListener(this);
		
		
		
		lFar = new JLabel("Stopnie Fahrenhajta:");
		lFar.setBounds(20, 70, 150, 20);
		add(lFar);
		
		tFar = new JTextField();
		tFar.setBounds(170,70, 150, 20);
		add(tFar);
		tFar.addActionListener(this);
		
		
		
		bKonwertuj = new JButton("Konwertuj");
		bKonwertuj.setBounds(20, 100, 140,20);
		add(bKonwertuj);
		bKonwertuj.addActionListener(this);
		
		
		bExit = new JButton("Exit");
		bExit.setBounds(180, 100, 140, 20);
		bExit.setForeground(Color.red);
		add(bExit);
		bExit.addActionListener(this);
		
		
		
		ChHuge = new JCheckBox("Wielkie litery");
		ChHuge.setBounds(200, 220, 150, 20);
		add(ChHuge);
		
		//zakomentowane by zrobic po konwertuj
		//ChHuge.addActionListener(this);
		
		
		// grupowanie radiobuutonow
		
		bgRozmiar = new ButtonGroup();
		
		Rsmall = new JRadioButton("Ma³y",true);
		Rsmall.setBounds(50, 150, 100, 20);
		bgRozmiar.add(Rsmall);
		add(Rsmall);
		Rsmall.addActionListener(this);
		
		Rmedium = new JRadioButton("Sredni",false);
		Rmedium.setBounds(150, 150, 100, 20);
		bgRozmiar.add(Rmedium);
		add(Rmedium);
		Rmedium.addActionListener(this);
		
		Rlarge = new JRadioButton("duzy",false);
		Rlarge.setBounds(250, 150, 100, 20);
		bgRozmiar.add(Rlarge);
		add(Rlarge);
		Rlarge.addActionListener(this);
		
		
		
		
		// konwersja z far na celc i wicewersa
		
		Panel = new ButtonGroup();
		
		
		CeltoFar = new JRadioButton("Celcjusz-> Fahrenheit",true);
		CeltoFar.setBounds(20,180,150,20);
		Panel.add(CeltoFar);
		add(CeltoFar);
		
		
		FartoCel = new JRadioButton("Fahrenheit -> Celcjusz",false);
		FartoCel.setBounds(200, 180, 150, 20);
		Panel.add(FartoCel);
		add(FartoCel);
		
		
		//suwak
		
		sCel = new JSlider(0,100,0);
		sCel.setBounds(330, 10, 150, 50);
		sCel.setMajorTickSpacing(20);
		sCel.setMinorTickSpacing(5);
		sCel.setPaintTicks(true);
		sCel.setPaintLabels(true);
		add(sCel);
		
		
		sFar = new JSlider(30,111,30);
		sFar.setBounds(330, 70, 150, 50);
		sFar.setMajorTickSpacing(20);
		sFar.setMinorTickSpacing(5);
		sFar.setPaintTicks(true);
		sFar.setPaintLabels(true);
		add(sFar);
		
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CelcToFar aplication = new CelcToFar();
		aplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplication.setVisible(true);
		
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object source = e.getSource();
		if(source == bExit)
			dispose();

		
		else if( source == bKonwertuj)
		{
			
			
			if(CeltoFar.isSelected())
			{
				tempCel = Double.parseDouble(tCel.getText());
				tempFar = 32.0 + (9.0/5) * tempCel;
				// ustawiam stringa na double konwersja w chuj
				tFar.setText(String.valueOf(tempFar));
			}
			
			if(FartoCel.isSelected())
			{
				tempFar = Double.parseDouble(tFar.getText());
				tempCel = (tempFar - 32)*5.0/9.0;
				// ustawiam stringa na double konwersja w chuj
				tCel.setText(String.valueOf(tempCel));
			}
			
			
			if(ChHuge.isSelected()== true)
			{
				tFar.setFont(new Font("SansSerif",Font.BOLD,18));
			}
			else
			{
				tFar.setFont(new Font("SansSerif",Font.PLAIN,12));
			}
			
		
		}
		
	
	
		else if (source == Rsmall)
		{
			 tFar.setFont(new Font("SansSerif",Font.PLAIN,12));
		}
		 else if (source == Rmedium)
			{
				 tFar.setFont(new Font("SansSerif",Font.PLAIN,14));
			}
		 else if (source == Rlarge)
			{
				 tFar.setFont(new Font("SansSerif",Font.PLAIN,20));
			}
	}

}
