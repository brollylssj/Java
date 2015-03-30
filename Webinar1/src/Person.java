import java.util.ArrayList;
import java.util.Iterator;

/**
 * Klasa Person - reprezentuje pojedyncza osobe
 * @author Brolly
 * @version 1.01
 * @see Person
 */
public class Person {
	
	private String name,surname,gender;
	int age;
	
	
	/**
	 * 
	 * @retur zwraca stringa
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * This is Constructor a Person whitch a specifited name,surname,gender,age
	 * @param name name of person
	 * @param surname surname of person
	 * @param gender gender of person
	 * @param age age of person
	 */
	public Person(String name, String surname, String gender, int age) {
		setName(name);
		setSurname(surname);
		setGender(gender);
		setAge(age);
		
		Person.people.add(this);
		
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age>0)
		this.age = age;
	}
	
	public String toString()
	{
		return getName()+ " "+ getSurname()+" "+getGender()+" "+getAge();
	}
	
	public static String getClassName()
	{
		return "Osoba";
	}
	
	public String getFullName()
	{
		return getName()+" "+getSurname();
	}

	public static ArrayList<Person> people = new ArrayList<Person>(){
		
		public void printAllPeople()
		{
			for(Person p: Person.people)
				System.out.println(p);
		}
		
	};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p1 = new Person("Jon", "Trawolta", "male", 21);
		Person p2 = new Person("Justyna", "Kowalczyk", "female", 33);
		
		System.out.println(p1.getFullName());
		System.out.println(Person.getClassName());
		
		System.out.println(p1);
		System.out.println(p2);
		
		//p1 = p2;
		
		
		

	}

}
