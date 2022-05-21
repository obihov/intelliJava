package javaobinnaPractice;

public class BigONation {
    static int i = 0;

    public static void main(String[] args) {

        @SuppressWarnings("")
        int value = DeepSquareRoot(4);
        System.out.println(value);
    }

    public static int DeepSquareRoot(int number) {


        int[] base = new int[]{2, 3, 5, 7, 8};
        //int calculateSquare = 0;

        while (i < base.length) {
            int currentBase = base[i];
            do {
                number = number / currentBase;
            } while(number % currentBase == 0);

            if (number % currentBase != 0) {
                i++;
                DeepSquareRoot(number);
            }
        }

        return number;


        /*
        144/2 = 72
        72/2 = 36
        36/2 = 18
        18/2 = 9 (is 2/3/5/7/8 ? yes, then stop, return result)
        9/3 = 3 (is 2/3/5/7/8 ? yes, then stop)
        4(2) + 1(3) = 8 + 3

        2/3/5/7/8
         */

    }

}
