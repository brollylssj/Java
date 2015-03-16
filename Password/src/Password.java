import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Password extends JFrame implements ActionListener {

	private JPasswordField pass;
	private JLabel lhaslo;
	private JButton bShow,baddUsser;
	private JTextArea notatnik;
	private JScrollPane scroll;
	
	// zmienna do nowego okna
	private PanelPassword PanelPassword;
	
	
	public Password()
	{
		setSize(400, 600);
		setTitle("Password");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lhaslo = new JLabel("Has³o");
		lhaslo.setBounds(30, 50, 50, 20);
		add(lhaslo);
		pass = new JPasswordField();
		pass.setBounds(70, 50, 100, 20);
		add(pass);
		pass.addActionListener(this);
		
		bShow = new JButton("Show password");
		bShow.setBounds(180, 50, 150, 20);
		add(bShow);
		bShow.addActionListener(this);
		
		// pole tekstowe
		notatnik = new JTextArea();
		//zawinjanie wierszy w notataniku!
		notatnik.setWrapStyleWord(true);
		scroll = new JScrollPane(notatnik);
		scroll.setBounds(2, 120, 396, 400);
		add(scroll);
		
		//dodaj urzytkownika
		baddUsser = new JButton("Add User");
		baddUsser.setBounds(180, 20, 150, 20);
		add(baddUsser);
		baddUsser.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Password app = new Password();
		app.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object source = e.getSource();
		
		if(source == bShow)
		{
				JOptionPane.showMessageDialog(null, "Twoje has³o to "+String.valueOf(pass.getPassword()));
			
				
		}
		
		else if (PanelPassword == null)
		{
			PanelPassword = new PanelPassword(this);
		}
			PanelPassword.setVisible(true);
			PanelPassword.setFocus();
			
			if(PanelPassword.isOK())
			{
				notatnik.append(PanelPassword.getUser()+" ");
				notatnik.append(PanelPassword.getHaslo() +"\n");
			}
		
	}

}
