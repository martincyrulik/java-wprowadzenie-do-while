/**
 * Dla dowolnej liczby całkowitej podziel ją przez 2, wynik dzielenia (bez reszty) przypisz
 * do tej liczby, resztę wyświetl. Wykonuj dopóki liczba będzie równa 0;
 *
 * np. dla 21
 * 21/2 = 10 reszta 1
 * 10/2 = 5, reszta 0
 * 5/2 = 2 reszta 1
 * 2/2 = 1 reszta 0
 * 1/2 = 0 reszta 1
 * Wyświetl: 10101
 *
 * np. dla 7
 * 7/2 = 3 reszta 1
 * 3/2 = 1 reszta 1
 * 1/2 = 0 reszta 1
 * Wyświetl: 111
 *
 * np. dla 25
 * 25/2 = 12 reszta 1
 * 12/2 = 6 reszta 0
 * 6/2 = 3 reszta 0
 * 3/2 = 1 reszta 1
 * 1/2 = 0 reszta 1
 * Wyświetl: 10011
 */

public class DisplayRemainder {
    public static void main(String[] args) {

        int n = 25;

        do {
            if ((n % 2) == 0 ) {
                System.out.print(0);
            } else {
                System.out.print(1);
            }
            n = n / 2;
        } while (n != 0);
    }
}
