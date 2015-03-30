package mikrofalowka;

import java.util.Scanner;
/**
 * 
 * @author Tomasz Hanusiak
 * Klasa reprezentujaca Mikrofalowke
 *
 */

 class Mikrofalowka {
	

	private Scanner scanner;

/**
 * Metoda wyswietla glowne menu mikrofalowki
 */
	 void mainMenu ()
	{
		System.out.println("Menu Mikrofalowki");
		
		System.out.println("     1. Moc");
        System.out.println("     2. Czas");
        System.out.println("     3. Opcje zaawansowane");
        System.out.println("     0. Zakoncz");
		
	}
	/**
	 * Metoda realizuje podane przez urzytkownika akcje
	 */	
	 void menu()
	{
		
		
		mainMenu();
		scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		
		switch (choice) {
		case 1:
			menuMoc();
			break;
			
		case 2:
			menuCzas();
			break;
		case 3:
			menuOZ();
			break;
			
		case 0:
			System.out.println("Zakonczono uzywanie mikrofalowki");
			break;

		default:
			System.out.println("Wybrano niepoprawna opcje wybierz jeszcze raz");
			menu();
			break;
		}
		
	}
	
	/**
	 * Meotoda rozwija menu moc
	 */
	 void menuMoc()
	{
		System.out.println("Wybierz Moc która ci odpowiada");
		
		System.out.println("     1. 150W");
        System.out.println("     2. 180W");
        System.out.println("     3. 200W");
        System.out.println("     4. 220W");
        System.out.println("     0. Powrót");
        
        
        scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Ustawiono 150W");
			menu();
			break;
			
		case 2:
			System.out.println("Ustawiono 180W");
			menu();
			break;
		case 3:
			System.out.println("Ustawiono 200W");
			menu();
			break;
		case 4:
			System.out.println("Ustawiono 220W");
			menu();
			break;
		case 0:
			menu();
			break;

		default:
			System.out.println("Wybrano niepoprawna opcje wybierz jeszcze raz");
			menuMoc();
			break;
		}
        
		
		
	}
	
	/**
	 * Metoda rozwijajaca menu czas
	 */
	void menuCzas()
	{
System.out.println("Okreœl czas");
		
		System.out.println("     1. 10sek");
        System.out.println("     2. 20sek");
        System.out.println("     3. 30sek");
        System.out.println("     4. 1min");
        System.out.println("     5. Wprowadz niestandardowy czas");
        
        System.out.println("     0. Powrót");
        
        
        scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Ustawiono 10sek");
			menu();
			break;
			
		case 2:
			System.out.println("Ustawiono 20sek");
			menu();
			break;
		case 3:
			System.out.println("Ustawiono 30sek");
			menu();
			break;
		case 4:
			System.out.println("Ustawiono 1min");
			menu();
			break;
		case 5:
			System.out.println("Podaj czas");
			Scanner time = new Scanner(System.in);
			String timeN = time.nextLine();
			System.out.println("Ustawiono "+timeN);
			
			menu();
			break;
		case 0:
			menu();
			break;

		default:
			System.out.println("Wybrano niepoprawna opcje wybierz jeszcze raz");
			menuCzas();
			break;
		}
	}
	
	/**
	 * Metoda rozwijajaca metode opcje zaawansowane
	 */
	
	 void menuOZ()
	{
		System.out.println("Wybierz Opcje ktora ci odpowiada");
		
		System.out.println("     1. Grill");
        System.out.println("     2. Odmrazanie");
        System.out.println("     3. Odgrzewanie");
        System.out.println("     4. Pieczenie");
        System.out.println("     0. Powrót");
        
        
        scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Ustawiono Grill");
			menu();
			break;
			
		case 2:
			menuOdmrazanie();
			break;
		case 3:
			System.out.println("Ustawiono Odgrzewanie");
			menu();
			break;
		case 4:
			System.out.println("Ustawiono Pieczenie");
			menu();
			break;
		case 0:
			menu();
			break;

		default:
			System.out.println("Wybrano niepoprawna opcje wybierz jeszcze raz");
			menuOZ();
			break;
		}
        
		
		
	}
	
	/**
	 * Metoda rozwijajaca menu Odmrazanie
	 */
	
	 void menuOdmrazanie()
	{
		System.out.println("Wybierz opcje ktora ci odpowiada");
		
		System.out.println("     1. Szybkie odmrazanie");
        System.out.println("     2. Odmrazanie artykolow miesnych");
        System.out.println("     3. Dlugie odmrazanie");
        System.out.println("     0. Powrót");
        
        
        scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Ustawiono Szybkie odmrazanie");
			menu();
			break;
			
		case 2:
			System.out.println("Ustawiono Odmrazanie artykolow miesnych");
			menu();
			break;
		case 3:
			System.out.println("Ustawiono Dlugie odmrazanie");
			menu();
			break;

		case 0:
			menuOZ();
			break;

		default:
			System.out.println("Wybrano niepoprawna opcje wybierz jeszcze raz");
			menuOdmrazanie();
			break;
		}
        
		
		
	}


}
