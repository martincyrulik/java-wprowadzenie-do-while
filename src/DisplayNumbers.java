public class DisplayNumbers {
    public static void main(String[] args) {

        int[] numbers = {72, 5, -6, 22, -9};
        //int[] numbers = {72, 5, 6, 22, 9};

        int i = 0;
        do {
            System.out.println(numbers[i]);
        } while (i < numbers.length-1 && numbers[i++] > 0);
    }
}
/**
 * dł_tablicy = 5;
 *
 * i = 0
 *
 * wyświetla numbers[0]     72
 * i = 1
 *
 * wyświetla numbers[1]     5
 * i = 2
 *
 * wyświetla numbers[2]     -6
 * i = 3
 *
 *
 */
