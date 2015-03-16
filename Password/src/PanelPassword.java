import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class PanelPassword extends JDialog implements ActionListener
{
	private JLabel lUser,lHaslo;
	private JPasswordField tHaslo;
	private JTextField tUser;
	private JButton bOK,bCancel;
	// ustawiono na true jesli OK false jesli Cancel
	private boolean okData;
	
	// obiekt nadrzedny
	public PanelPassword(JFrame owner)
	{
		super(owner,"Wprowadzanie has³a",true);// true -dialog modalny trzeba go obsluzyc
		setSize(300,200);
		setLayout(null);
		
		
		lUser = new JLabel("User",JLabel.RIGHT);
		lUser.setBounds(0, 0, 100, 20);
		add(lUser);
		
		tUser = new JTextField();
		tUser.setBounds(120,0,100,20);
		add(tUser);
		
		
		lHaslo = new JLabel("Password",JLabel.RIGHT);
		lHaslo.setBounds(0, 40, 100, 20);
		add(lHaslo);
		
		tHaslo = new JPasswordField();
		tHaslo.setBounds(120,40,100,20);
		add(tHaslo);
		
		bOK = new JButton("OK");
		bOK.setBounds(20, 100, 100, 20);
		add(bOK);
		bOK.addActionListener(this);
		
		
		bCancel = new JButton("Cancel");
		bCancel.setBounds(140, 100, 100, 20);
		add(bCancel);
		bCancel.addActionListener(this);
		
		
		
		
		
	}
	// metody zwracajace nazwe urzytkownika i haslo;
	
	
	public String getUser()
	{
		return tUser.getText();
	}
	
	public String getHaslo()
	{
		return new String(tHaslo.getPassword());
	}
	
	public boolean isOK()
	{
		return okData;
	}
	
	public void setFocus()
	{
		tUser.requestFocusInWindow();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		
		if(source ==bOK)
		{
			okData =true;
		}
		else
		{
			okData=false;
		}
		
		setVisible(false);

		
	}

}
