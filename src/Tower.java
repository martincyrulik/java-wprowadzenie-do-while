/**
 * Gramy w szachy. Zadajemy rozmieszczenie figur swoich i przeciwnika,
 * bez ich rozróżniana na pionki. skoczki, wieże itd. Napisz algorytm,
 * który sprawdzi jakie możliwości zbicia przeciwnika ma wieża.
 * - zadajemy położenie wieży na szachownicy na początku działania programu.
 * - wprowadź pionki przeciwnika,
 * - wprowadź swoje pionki (bez rozróżniana)
 * - poszukaj jakich przeciwników ma w zasięgu wieża i wyświetl ich pozycje
 * - sprawdź czy algorytm działa poprawnie gdy pionki inne niż wieża zmienią położenie.
 * Tablica fig to nasza tablica wyjściowa. Dla ułatwienia:
 * - wartości 0 - tu puste miejsca na szachownicy,
 * - wartości 1 - to miejsca figur przeciwnika,
 * - wartości 2 - to miejsca naszych figur,
 * - wartość 3 - to miejsce wieży na szachownicy
 * Wieża może poruszać sie jedynie po lini prostej -
 * - poziomo - czyli albo na lewo albo na prawo
 * - pionowo - czyli albo do góry albo na dół
 * Aby rozpocząć poszukiwania ewentualnych figur przeciwnika do zbicia -
 * najpierw musimy określić jej położenie na szachownicy.
 */


public class Tower {
    public static void main(String[] args) {
        int[][] fig = {
                {0,0,0,0,1,0,0,0},
                {1,1,1,1,0,0,0,1},
                {0,0,1,0,1,0,1,0},
                {1,0,0,0,0,0,0,0},
                {0,0,0,2,0,1,2,0},
                {0,0,2,0,0,2,0,0},
                {2,2,0,0,0,2,2,2},
                {2,0,0,0,3,0,2,0}
        };

        //szukamy wieży na szachownicy - musimy określić jej położenie - wiersz i kolumnę
        int rowIndex = 0;   //inicjalizacja zmiennej określającej wiersz w którym jest wieża
        int colIndex = 0;   //inicjalizacja zmiennej określającej kolumnę w której jest wieża
        int i = 0;  //indeks 1 wiersza szachownicy
        do {
            int j = 0;  //indeks 1 kolumny szachownicy
            do {
                if (fig[i][j] == 3) {
                    rowIndex = i;
                    colIndex = j;
                }
                j++;
            } while (j < fig[i].length);
            i++;
        } while (i < fig.length);
        System.out.println("Położenie wieży na szachownicy: fig" + "[" + rowIndex + "][" + colIndex + "]" );

        //szukamy położenia figur przeciwnika do zbicia na prawo od wieży
        boolean jestZbicie = false;
        i = rowIndex;
        int j = colIndex;
        int index = 0;  //inicjalizacja kolumny w której znajdzie się figura przeciwnika do zbicia
        do {
            if (fig[i][j] == 1) {
                index = j;
                jestZbicie = true;
            }
            j++;
        } while (j <= ((fig[i].length) - 1) && fig[i][j-1] != 1 && fig[i][j-1] != 2);
        System.out.print("Pozycje pionków do zbicia w poziomie: ");
        if (jestZbicie == true) {
            System.out.print("fig[" + i + "][" + index + "] ");
        }

        //szukamy położenia figur przeciwnika do zbicia na lewo od wieży
        i = rowIndex;
        j = colIndex;
        jestZbicie = false;
        index = 0;  //inicjalizacja kolumny w której znajdzie się figura przeciwnika do zbicia
        do {
            if (fig[i][j] == 1) {
                index = j;
                jestZbicie = true;
            }
            j--;
        } while (j >= 0 && fig[i][j+1] != 1 && fig[i][j+1] != 2);
            if (jestZbicie == true) {
                System.out.print("fig[" + i + "][" + index + "] ");
            }
        System.out.println();

        //szukamy położenia figur przeciwnika do zbicia w górę od wieży
        i = rowIndex;
        j = colIndex;
        jestZbicie = false;
        index = 0;  //inicjalizacja wiersza w której znajdzie się figura przeciwnika do zbicia
        do {
            if (fig[i][j] == 1) {
                index = i;
                jestZbicie = true;
            }
            i--;
        } while (i >= 0 && fig[i+1][j] != 1 && fig[i+1][j] != 2);
        System.out.print("Pozycje pionków do zbicia w pionie: ");
        if (jestZbicie == true) {
            System.out.print("fig[" + index + "][" + j + "] ");
        }

        //szukamy położenia figur przeciwnika do zbicia w dół od wieży
        i = rowIndex;
        j = colIndex;
        jestZbicie = false;
        index = 0;  //inicjalizacja wiersza w której znajdzie się figura przeciwnika do zbicia
        do {
            if (fig[i][j] == 1) {
                index = i;
                jestZbicie = true;
            }
            i++;
        } while (i-1 < fig.length - 1 && fig[i-1][j] != 1 && fig[i-1][j] != 2);
        if (jestZbicie == true) {
            System.out.print("fig[" + index + "][" + j + "]");
        }
    }
}
