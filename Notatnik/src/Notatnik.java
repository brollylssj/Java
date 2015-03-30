import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


public class Notatnik extends JFrame implements ActionListener {
	
	
	private JMenuBar menu;
	private JMenu menuPlik,menuOProgramie;
	private JMenuItem Open,Save,Close;
	private JTextArea PoleTekstowe;
	private JButton bSearch;
	private JTextField fSearch,fLicz;
	private JComboBox ComboBox;
	private JButton bColor;

	
	Notatnik()
	{
		setSize(600,700);
		setTitle("NoteShiftPad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		
		// menu bar
		menu =new JMenuBar();
		menuPlik = new JMenu("Plik");
		menuOProgramie = new JMenu("O Programie");
		
		setJMenuBar(menu);
		
		menu.add(menuPlik);
		menu.add(menuOProgramie);
		
		Open = new JMenuItem("Otworz");
		Save = new JMenuItem("Zapisz");
		Close = new JMenuItem("Wyjscie");
		
		menuPlik.add(Open);
		menuPlik.add(Save);
		menuPlik.addSeparator();
		menuPlik.add(Close);
		
		
		Save.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		Open.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		Close.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
		
		Save.addActionListener(this);
		Open.addActionListener(this);
		Close.addActionListener(this);
		
		
		PoleTekstowe = new JTextArea();
		
		JScrollPane sc = new JScrollPane(PoleTekstowe);
		sc.setBounds(1, 1, 599, 500);
		add(sc);
		
		bSearch = new JButton("Szukaj");
		bSearch.setBounds(190, 550, 100, 20);
		add(bSearch);
		bSearch.addActionListener(this);
		
		fSearch = new JTextField();
		fSearch.setBounds(20, 550, 150, 20);
		add(fSearch);
		
		
		
		ComboBox = new JComboBox();
		ComboBox.setBounds(380, 550, 100, 20);
		ComboBox.addItem("czarny");
		ComboBox.addItem("czerwony");
		ComboBox.addItem("zielony");
		ComboBox.addItem("niebieski");
		add(ComboBox);
		ComboBox.addActionListener(this);
		
		
		//color button
		
		bColor = new JButton("Kolor");
		bColor.setBounds(380, 520, 100, 20);
		add(bColor);
		bColor.addActionListener(this);
		
		
		// licznik
		
		fLicz = new JTextField();
		fLicz.setBounds(380, 600, 100, 20);
		add(fLicz);
		fLicz.addActionListener(this);
		
		
	}

	public static void main(String[] args) {
		
		Notatnik notatnik = new Notatnik();
		notatnik.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {


		Object source = e.getSource();
		
		if(source == Close)
			dispose();
		
		else if(source ==bColor)
		{
			Color wybrany =JColorChooser.showDialog(null, "wybor koloru", Color.GREEN);
			PoleTekstowe.setForeground(wybrany);
		}
		
		else if(source ==ComboBox)
		{
			// przelacz na string co wybrales
						String color = ComboBox.getSelectedItem().toString();
						if (color.equals("zielony"))
							PoleTekstowe.setForeground(Color.GREEN);
						else if(color.equals("czarny"))
							PoleTekstowe.setForeground(Color.BLACK);
						else if(color.equals("czerwony"))
							PoleTekstowe.setForeground(Color.RED);
						else if(color.equals("niebieski"))
							PoleTekstowe.setForeground(Color.BLUE);
		}
		
		else if (source ==PoleTekstowe)
		{
			String licz = PoleTekstowe.getText();
			int wyst;
			int i = 0;
			int index;
			int startIndex =0;
			while((index = licz.indexOf(startIndex))!= -1)
			{
				i++;
			}
			
			fLicz.setText(String.valueOf(i));
			
		}
		
		
		else if( source == bSearch)
		{
			String tekst = PoleTekstowe.getText();
			String szukane = fSearch.getText();
			String wystapienia ="";
			int i = 0;
			int index;
			int startIndex =0;
			while((index = tekst.indexOf(szukane, startIndex))!= -1)
			{
				// omin wyszukanie jak cos znajdziesz
				startIndex = index + szukane.length();
				i++;
				// pokazuje indexy
				wystapienia = wystapienia +" "+index;
			}
			
			JOptionPane.showMessageDialog(null, szukane + " wystapilo "+i+" razy");
			
		}
		
		
	}

}
