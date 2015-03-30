public class Test {
/**
 * @param args
 * argumenty przekazywane do programu z linii komend
 */
public static void main(String[] args) { // args - tablica argumentow
 if (args.length > 0)
 System.out.println("Argument: " +args.length + args[0]);
 else
 System.out.println("Losowa liczba z przedzia³u <0,100): "
 + (int) (Math.random() * 100));
// (int) - konwersja typu
 }
}