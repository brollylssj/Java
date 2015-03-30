import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


public class Menu extends JFrame implements ActionListener{
	// 20 5:24
	
	 private JMenuBar menuBar;
	 private JMenu menuPlik,menuNarzedzia,menuPomoc,menuOpcje,menuV;
	 private JMenuItem mOtworz,mZapisz,mWyjscie,mNarz1,mNarz2,mOprogramie,mOpcja1,mOpcja2,mOpcjaX,mpKopiuj,mpWklej,mpDolacz;
	 private JTextArea notatnik;
	 private JButton bSzukaj;
	 private JTextField tSzukany;
	 private JPopupMenu popup;
	 private JComboBox ComboBox;
	
	public Menu()
	{
		setSize(700,700);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		// zamiast add dajemy set
		
		menuBar = new JMenuBar();
		menuPlik = new JMenu("Plik");
		menuNarzedzia = new JMenu("Narzedzia");
		menuPomoc = new JMenu("Pomoc");
		
		
		setJMenuBar(menuBar);
		menuBar.add(menuPlik);
		menuBar.add(menuNarzedzia);
		menuBar.add(menuPomoc);
		
		
		// itemy do menu Plik
		mOtworz = new JMenuItem("Otwórz");
		mWyjscie = new JMenuItem("Wyjscie");
		mZapisz = new JMenuItem("Zapisz");
		// dodanie itemow do menu
		menuPlik.add(mOtworz);
		menuPlik.add(mZapisz);
		menuPlik.addSeparator();
		menuPlik.add(mWyjscie);
		
		// itemy do narzedzia
		
		mNarz1 = new JMenuItem("Narzedzie1");
		mNarz2 = new JMenuItem("Narzedzie2");
		//dodanie itemow do menu
		menuNarzedzia.add(mNarz1);
		menuNarzedzia.add(mNarz2);
		
		// pod menu 
		
		menuOpcje = new JMenu("Opcje");
		mOpcja1 = new JMenuItem("opcja 1");
		mOpcja2 = new JMenuItem("opcja 2");
		
		menuOpcje.add(mOpcja1);
		menuOpcje.add(mOpcja2);
		
		// do narzedzi dodajemy menu opcje
		menuNarzedzia.add(menuOpcje);
		
		
		
		// dodajmy teraz do opcji 1 opcje x
		
		menuV = new JMenu ("MenuV");
		mOpcjaX = new JMenuItem("Opcja X");
		
		menuV.add(mOpcjaX);
		menuOpcje.add(menuV);
		
		//itemy do menu Pomoc
		
		mOprogramie = new JMenuItem("O Programie");
		// dodanie do pomocy itemow
		menuPomoc.add(mOprogramie);
		
		
		// wyjscie
		mWyjscie.addActionListener(this);
		
		// skrót klawiatarówy do mWyscie
		mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
		
		
		mOprogramie.addActionListener(this);
	
		
		mNarz2.addActionListener(this);
		
		
		mOtworz.addActionListener(this);
		mZapisz.addActionListener(this);
		
		// pole tekstowe 
		
		notatnik = new JTextArea();
		// wkladam notatnik do scroll panela by tekst nie znika³
		JScrollPane scrollPane = new JScrollPane(notatnik);
		scrollPane.setBounds(50, 500, 100, 20);
		add(scrollPane);
		
		
		// przycisk szukaj;
		
		tSzukany = new JTextField();
		tSzukany.setBounds(50,50,400,400);
		add(tSzukany);
		
		bSzukaj = new JButton("Szukaj");
		bSzukaj.setBounds(200, 500, 100, 20);
		add(bSzukaj);
		bSzukaj.addActionListener(this);
		
		
//		popup = new JPopupMenu();
//		mpKopiuj = new JMenuItem("Kopiuj");
//		mpKopiuj.addActionListener(this);
//		
//		mpWklej = new JMenuItem("Wklej");
//		mpWklej.addActionListener(this);
//		
//		mpDolacz = new JMenuItem("Dolacz");
//		mpDolacz.addActionListener(this);
//		
//		
//
//		popup.add(mpKopiuj);
//		popup.add(mpDolacz);
//		popup.add(mpDolacz);
//		
//		notatnik.setComponentPopupMenu(popup);
		
		
		// combobox
		
		ComboBox = new JComboBox();
		ComboBox.setBounds(500, 50, 100, 20);
		ComboBox.addItem("czarny");
		ComboBox.addItem("czerwony");
		ComboBox.addItem("zielony");
		ComboBox.addItem("niebieski");
		add(ComboBox);
		ComboBox.addActionListener(this);
		
	}
	

	public static void main(String[] args) {
		
		Menu window = new Menu();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		Object source =e.getSource();
		
		if (source ==bSzukaj)
		{
			String tekst = notatnik.getText();
			String szukane = tSzukany.getText();
			String wystapienia ="";
			int i = 0;
			int index;
			int startIndex =0;
			
			// czemu rozny od -1 jak znajdziemy na pozycji 1 to musimy zaczac 
			while((index = tekst.indexOf(szukane, startIndex))!= -1)
			{
				// omin wyszukanie jak cos znajdziesz
				startIndex = index + szukane.length();
				i++;
				// pokazuje indexy
				wystapienia = wystapienia +" "+index;
			}
			
			JOptionPane.showMessageDialog(null, szukane + "wystapilo "+i+" razy" +wystapienia+1);
		}
		
		else if (source ==ComboBox)
		{
			// przelacz na string co wybrales
			String color = ComboBox.getSelectedItem().toString();
			if (color.equals("zielony"))
				notatnik.setForeground(Color.GREEN);
			else if(color.equals("czarny"))
				notatnik.setForeground(Color.BLACK);
			else if(color.equals("czerwony"))
				notatnik.setForeground(Color.RED);
			else if(color.equals("niebieski"))
				notatnik.setForeground(Color.BLUE);
		}
		
		else if (source == mOtworz)
		{
			
			
			JFileChooser fc = new JFileChooser();
			if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				File plik = fc.getSelectedFile();
				
				//JOptionPane.showMessageDialog(null, "wybrales plik " + plik.getAbsolutePath());
				// scaner bd lapal plik
				
				try {
					Scanner scan = new Scanner(plik);
					
					// dopuki scaner ma znak 
					while(scan.hasNext())
					{
						notatnik.append(scan.nextLine() + "\n");
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		
		
		else if(source == mZapisz)
		{
			JFileChooser fc = new JFileChooser();
			if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				File plik=fc.getSelectedFile();
				//JOptionPane.showMessageDialog(null, "Wybrany plik to: " +plik);
				
				try
				{
					PrintWriter pw = new PrintWriter(plik);
					Scanner skaner = new Scanner(notatnik.getText());
					while(skaner.hasNext())
					{
						pw.println(skaner.nextLine() +"\n");
					}
					
					pw.close();
				} 
				catch (FileNotFoundException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		else	if(source == mWyjscie)
		{
			// okno czy chcesz napewno zamknac
			 int odpowiedz = JOptionPane.showConfirmDialog(null, "Czy na pewno wyjs","Wyjscie",JOptionPane.YES_NO_OPTION);
			if(odpowiedz == JOptionPane.YES_OPTION)
				dispose();
			 if(odpowiedz == JOptionPane.NO_OPTION);
			JOptionPane.showMessageDialog(null, "Bardzo nam mi³o ze jeszcze sie bawisz");
		}
			
		
		
		else	if(source == mOprogramie)
		{
			JOptionPane.showMessageDialog(this, "Program demonstruje wykorzystanie \n dsadsa","tytul",JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		else if (source == mNarz2)
		{
			String sMetry = JOptionPane.showInputDialog("Podaj dlugosc w metrach");
			double metry = Double.parseDouble(sMetry);
			double stopy = metry/0.3048;
			String sStopy = String.format("%.2", stopy);
			JOptionPane.showMessageDialog(null, metry+" metrow = "+sStopy +" stóp");
		}
		
		
	}
	
	

}
