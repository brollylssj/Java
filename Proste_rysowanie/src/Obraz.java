import javax.swing.JPanel;


public class Obraz extends JPanel {
	public Easy_Draw()
	{
		super("program obrazkowy");
		JPanel obrazPanel = new ObrazPanel();
		add(obrazPanel);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
