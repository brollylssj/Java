package world;

public class Plant {
	//bad praktice
	public String name;

	// final is ok
	public final static int ID = 9;
	
	protected String size;
	private String type;
	
	public Plant()
	{
		this.name= "Franek";
		this.size = "medium";
	}
}
