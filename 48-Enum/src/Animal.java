
public enum Animal {

	CAT("AJA"),DOG("HAu"),MOUSE("Chrum");
	
	private String name;
	
	Animal(String name)
	{
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString()
	{
		return "This animal called" +name;
	}
}
