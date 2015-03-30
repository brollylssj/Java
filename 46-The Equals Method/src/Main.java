class Person
{
	private int id;
	private String name;
	
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person person1 = new Person(5,"John");
		Person person2 = new Person(5, "John");
		
		System.out.println(person1.equals(person2)); //6:45
		
		
		double value1 = 7.2;
		double value2 = 7.2;
		
		System.out.println(value1 == value2);
		
		String strin1 = "HALO";
		String strin2 = "HALO";
		System.out.println(strin1.equalsIgnoreCase(strin2));
		System.out.println(new Object());
		
	}

}
