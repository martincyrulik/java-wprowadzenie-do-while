/**
 * Gramy w szachy. Zadajemy rozmieszczenie figur swoich i przeciwnika,
 * bez ich rozróżniana na pionki. skoczki, wieże itd. Napisz algorytm,
 * który sprawdzi jakie możliwości zbicia przeciwnika ma hetman
 * - zadajemy położenie hetmana na szachownicy na początku działania programu.
 *
 * wprowadź pionki przeciwnika,
 * wprowadź swoje pionki (bez rozróżniana)
 * poszukaj jakich przeciwników ma w zasięgu hetman i wyświetl ich pozycje
 * sprawdź czy algorytm działa poprawnie gdy pionki inne niż hetman zmienią położenie.
 *
 *  Tablica fig to nasza tablica wyjściowa. Dla ułatwienia:
 *  * - wartości 0 - tu puste miejsca na szachownicy,
 *  * - wartości 1 - to miejsca figur przeciwnika,
 *  * - wartości 2 - to miejsca naszych figur,
 *  * - wartość 3 - to miejsce hetmana na szachownicy
 *  * Hetman może poruszać sie po lini prostej -
 *  * - poziomo - czyli albo na lewo albo na prawo
 *  * - pionowo - czyli albo do góry albo na dół
 *  i po liniach ukośnych:
 *  - NE - na północny wschód
 *  - SE - na południowy wschód
 *  - NW - na północny zachód
 *  - SW - na południowy zachód
 *  * Aby rozpocząć poszukiwania ewentualnych figur przeciwnika do zbicia -
 *  * najpierw musimy określić położenie hetmana na szachownicy.
 *
 */


public class Hetman {
    public static void main(String[] args) {

        int[][] fig = {
                {1,0,1,1,1,1,0,0},  //0 wiersz
                {1,0,0,0,1,0,1,0},  //1 wiersz
                {1,0,1,0,2,1,0,1},  //2 wiersz
                {0,1,0,1,0,2,0,2},  //3 wiersz
                {0,2,0,2,0,0,0,2},  //4 wiersz
                {2,2,2,0,2,0,0,0},  //5 wiersz
                {0,0,2,2,3,0,0,2},  //6 wiersz
                {0,0,0,0,2,2,0,0}   //7 wiersz
        };

        //najpierw określimy położenie hetmana na szachownicy
        int rowIndex = 0;   //wiersz w którym jest hetman
        int colIndex = 0;   //kolumna w której znajduje się nasz hetman
        int i = 0;  //wiersze

        do {
            int j = 0; //zaczynamy poszukiwania hetmana od zerowej kolumny
            do {
                if (fig[i][j] == 3) {
                    rowIndex = i;   //Znaleźliśmy hetmana
                    colIndex = j;   // w wierszu rowIndex i kolumnie colIndex
                }
                j++;
            } while (j < fig[i].length);
            i++;
        } while (i < fig.length);

        //wyświetlamy pozycję hetmana na szachownicy
        System.out.println("Pozycja hetmana na szachownicy: [" + rowIndex + "][" + colIndex + "]");

        //Szukamy teraz jakie ma hetman możliwości do zbicia
        //przeciwnika w liniach prostych:
        //lewo - prawo
        //góra - dół

        //---------------Szukamy figur do zbicia w poziomie-----------------
        //Możliwe ruchy hetmana w lewo
        boolean doZbicia = false;   //na starcie nie mamy jeszcze nic do zbicia
        i = rowIndex;   //wyjściowa pozycja - (wiersz)
        int j = colIndex;   //hetmana na szachownicy  - (kolumna)
        int index = 0;  //  inicjalizujemy kolumnę w której będzie potencjalnie figura do zbicia
        do {
            if ((fig[i][j]) == 1) {
                doZbicia = true;    //jest figura do zbicia
                index = j;          //i mamy też kolumnę w której się znajduje
            }
            j--;
        } while (j+1 > 0 && fig[i][j+1] != 1 && fig[i][j+1] != 2);
        System.out.print("Możliwe figury do zbicia w poziomie: ");
        if (doZbicia == true) {
            System.out.print("[" + rowIndex + "][" + index + "] ");
        }

        //Możliwe ruchy hetmana w prawo
        doZbicia = false;   //na starcie nie mamy jeszcze nic do zbicia
        i = rowIndex;   //wyjściowa pozycja - (wiersz)
        j = colIndex;   //hetmana na szachownicy  - (kolumna)
        index = 0;  //  inicjalizujemy kolumnę w której będzie potencjalnie figura do zbicia
        do {
            if ((fig[i][j]) == 1) {
                doZbicia = true;    //jest figura do zbicia
                index = j;          //i mamy też kolumnę w której się znajduje
            }
            j++;
        } while (j < fig[i].length && fig[i][j-1] != 1 && fig[i][j-1] != 2);
        if (doZbicia == true) {
            System.out.print("[" + rowIndex + "][" + index + "] ");
        }
        System.out.println();

        //---------------Szukamy figur do zbicia w pionie-----------------
        //Możliwe ruchy hetmana w górę szachownicy
        doZbicia = false;   //na starcie nie mamy jeszcze nic do zbicia
        i = rowIndex;   //wyjściowa pozycja - (wiersz)
        j = colIndex;   //hetmana na szachownicy  - (kolumna)
        index = 0;  //  inicjalizujemy wiersz w której będzie potencjalnie figura do zbicia
        do {
            if ((fig[i][j]) == 1) {
                doZbicia = true;    //jest figura do zbicia
                index = i;          //i mamy też kolumnę w której się znajduje
            }
            i--;
        } while (i+1 > 0 && fig[i+1][j] != 1 && fig[i+1][j] != 2);
        System.out.print("Możliwe figury do zbicia w pionie: ");
        if (doZbicia == true) {
            System.out.print("[" + index + "][" + j + "] ");
        }

        //Możliwe ruchy hetmana w dół
        doZbicia = false;   //na starcie nie mamy jeszcze nic do zbicia
        i = rowIndex;   //wyjściowa pozycja - (wiersz)
        j = colIndex;   //hetmana na szachownicy  - (kolumna)
        index = 0;  //  inicjalizujemy kolumnę w której będzie potencjalnie figura do zbicia
        do {
            if ((fig[i][j]) == 1) {
                doZbicia = true;    //jest figura do zbicia
                index = i;          //i mamy też kolumnę w której się znajduje
            }
            i++;
        } while (i < fig.length && fig[i-1][j] != 1 && fig[i-1][j] != 2);
        if (doZbicia == true) {
            System.out.print("[" + index + "][" + j + "] ");
        }
        System.out.println();

        //---------------------------------------------------------------------------------------
        //---------------Szukamy figur do zbicia po liniach skośnych-----------------
        //Możliwe ruchy hetmana NE - na północny wschód
        doZbicia = false;   //na starcie nie mamy jeszcze nic do zbicia
        i = rowIndex;   //wyjściowa pozycja - (wiersz)
        j = colIndex;   //hetmana na szachownicy  - (kolumna)
        int indexOfRow = 0;  //  inicjalizujemy wiersz
        int indexOfCol = 0;  //  i kolumnę w której będzie potencjalnie figura przeciwnika do zbicia
        do {
            if ((fig[i][j]) == 1) {
                doZbicia = true;    //jest figura do zbicia
                indexOfRow = i;          //mamy jej wiersz
                indexOfCol = j;          //i kolumnę w której się znajduje
            }
            i--;    //kierunek NE - wiersze dekrementujemy
            j++;    //a kolumny inkrementujemy
        } while ((i+1 > 0 && j < fig[i].length) && fig[i+1][j-1] != 1 && fig[i+1][j-1] != 2);
        System.out.print("Możliwe figury do zbicia po liniach ukośnych: ");
        if (doZbicia == true) {
            System.out.print("[" + indexOfRow + "][" + indexOfCol + "] ");
        }

        //Możliwe ruchy hetmana NW - na północny zachód
        doZbicia = false;   //na starcie nie mamy jeszcze nic do zbicia
        i = rowIndex;   //wyjściowa pozycja - (wiersz)
        j = colIndex;   //hetmana na szachownicy  - (kolumna)
        indexOfRow = 0;  //  inicjalizujemy wiersz
        indexOfCol = 0;  //  i kolumnę w której będzie potencjalnie figura przeciwnika do zbicia
        do {
            if ((fig[i][j]) == 1) {
                doZbicia = true;    //jest figura do zbicia
                indexOfRow = i;          //mamy jej wiersz
                indexOfCol = j;          //i kolumnę w której się znajduje
            }
            i--;    //kierunek NW - wiersze dekrementujemy
            j--;    //i kolumny dekrementujemy
        } while ((i+1 > 0 && j+1 > 0) && fig[i+1][j+1] != 1 && fig[i+1][j+1] != 2);
        if (doZbicia == true) {
            System.out.print("[" + indexOfRow + "][" + indexOfCol + "] ");
        }

        //Możliwe ruchy hetmana SW - na południowy zachód
        doZbicia = false;   //na starcie nie mamy jeszcze nic do zbicia
        i = rowIndex;   //wyjściowa pozycja - (wiersz)
        j = colIndex;   //hetmana na szachownicy  - (kolumna)
        indexOfRow = 0;  //  inicjalizujemy wiersz
        indexOfCol = 0;  //  i kolumnę w której będzie potencjalnie figura przeciwnika do zbicia
        do {
            if ((fig[i][j]) == 1) {
                doZbicia = true;    //jest figura do zbicia
                indexOfRow = i;          //mamy jej wiersz
                indexOfCol = j;          //i kolumnę w której się znajduje
            }
            i++;    //kierunek SW - wiersze inkrementujemy
            j--;    //a kolumny dekrementujemy
        } while ((i < fig.length && j+1 > 0) && fig[i-1][j+1] != 1 && fig[i-1][j+1] != 2);
        if (doZbicia == true) {
            System.out.print("[" + indexOfRow + "][" + indexOfCol + "] ");
        }

        //Możliwe ruchy hetmana SE - na południowy wschód
        doZbicia = false;   //na starcie nie mamy jeszcze nic do zbicia
        i = rowIndex;   //wyjściowa pozycja - (wiersz)
        j = colIndex;   //hetmana na szachownicy  - (kolumna)
        indexOfRow = 0;  //  inicjalizujemy wiersz
        indexOfCol = 0;  //  i kolumnę w której będzie potencjalnie figura przeciwnika do zbicia
        do {
            if ((fig[i][j]) == 1) {
                doZbicia = true;    //jest figura do zbicia
                indexOfRow = i;          //mamy jej wiersz
                indexOfCol = j;          //i kolumnę w której się znajduje
            }
            i++;    //kierunek SE - wiersze inkrementujemy
            j++;    //i kolumny inkrementujemy
        } while ((i < fig.length && j < fig[i].length) && fig[i-1][j+1] != 1 && fig[i-1][j+1] != 2);
        if (doZbicia == true) {
            System.out.print("[" + indexOfRow + "][" + indexOfCol + "] ");
        }
    }
}
