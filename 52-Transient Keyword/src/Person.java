
import java.io.Serializable;


public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient int id;
	private String name;
	
	private static int count;
	
	// nie musimy serializowac transient niewidoczne

	public Person(int id,String name) {

		this.id = id;
		this.name=name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Person.count = count;
	}

	
	
	
}
