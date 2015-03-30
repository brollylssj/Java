
public abstract class Machine 
{

	private int ID;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public abstract void start();
	public abstract void shutdown();
	
	public void run()
	{
		start();
		shutdown();
	}
	
}
