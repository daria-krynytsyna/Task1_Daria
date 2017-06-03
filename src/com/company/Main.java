package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /* Item 1 */
        //   getGreetings(args[0]);

        /* Item 2 */
        //   invertCmd(args);

        /* Item 3 */
        //   randomGenerateToPrint();

        /* Item 4 */
        //   compareStr(args[1]);

        /* Item 5 */
        //   sumMultDigits(args);

        /* Item 6 */
        System.out.println("Введите n целых чисел через пробел и нажмите <Enter>:");
        Scanner scan = new Scanner(System.in);
        String[] digits = scan.nextLine().split(" ");
        scan.close();

        int digitsInt[] = new int[digits.length];
        for (int ind = 0; ind < digits.length; ind++) {
            digitsInt[ind] = Integer.parseInt(digits[ind]);
        }

        // Item 6.1
        //evenOddNumbers(digitsInt);

        // Item 6.2
        //minMaxValue(digitsInt);

        // Item 6.3 and 6.4
        //divide3Or95And7(digitsInt);

        // Item 6.5
        //notRepeatDigits(digitsInt);

        //Item 6.6
        //getLuckyNumbers(digits);

        //Item 6.7
        getHalfSumElements(digitsInt);
    }

    // get elements = 1/2 sum of neighboring elements
    private static void getHalfSumElements(int[] digitsInt) {
        String strHalfSum = "";
        for (int i = 1; i < digitsInt.length - 1; i++) {
           if (digitsInt[i] == 0.5 * (digitsInt[i-1]+digitsInt[i+1])) {
               strHalfSum += " " + digitsInt[i];
           }
        }
        System.out.println("0.5 sum of neighboring elements:" + strHalfSum);
    }

    // Lucky numbers
    private static void getLuckyNumbers(String[] digits) {
        String strLuckyNum = "";

        for (int i = 0; i < digits.length; i++) {
            int sum1 = 0;
            int sum2 = 0;
            byte[] a = digits[i].getBytes();
            if (a.length % 2 == 0) {
                for (int j = 0; j < a.length / 2; j++) {
                    sum1 += a[j];
                    sum2 += a[a.length - j - 1];
                }
                    if (sum1 == sum2) {
                        strLuckyNum += " " + digits[i];
                    }

            } else {
                System.out.println("Number of digits is odd");
            }
        }
        System.out.println("Lucky Numbers = " + strLuckyNum);
    }

    // numbers with not repeated digits
    private static void notRepeatDigits(int[] digitsInt) {
        String strNotRepeatDigit = "";
        for (int i = 0; i < digitsInt.length; i++) {
            if ((digitsInt[i] >= 100) && (digitsInt[i] <= 999)) {
                int one = digitsInt[i] / 100;
                int number = digitsInt[i] % 100;
                int two = number / 10;
                int three = number % 10;

                if ((one != two) && (one != three) && (two != three)) {
                    strNotRepeatDigit += " " + digitsInt[i];
                }
            } else {
                System.out.println("Please enter three-digits number");
            }
        }
        System.out.println("Not repeat digits:" + strNotRepeatDigit);
    }

    // Numbers divided by 3 or 9 / 5 and 7
    private static void divide3Or95And7(int[] digitsInt) {
        String strDigits3Or9 = "";
        String strDigits5And7 = "";
        for (int i = 0; i < digitsInt.length; i++) {
            if ((digitsInt[i] % 3 == 0) || (digitsInt[i] % 9 == 0)) {
                strDigits3Or9 += " " + digitsInt[i];
            }
            if ((digitsInt[i] % 5 == 0) && (digitsInt[i] % 7 == 0)) {
                strDigits5And7 += " " + digitsInt[i];
            }
        }
        System.out.println("Digits % 3 or % 9 :" + strDigits3Or9);
        System.out.println("Digits % 5 and % 7 :" + strDigits5And7);
    }

    // 6.2 Min and max values of arrays
    private static void minMaxValue(int[] digitsInt) {
        Arrays.sort(digitsInt);
        System.out.println("Min = " + digitsInt[0]);
        System.out.println("Max = " + digitsInt[digitsInt.length - 1]);
    }

    // 6.1 Enter to console even and odd numbers
    private static void evenOddNumbers(int[] digits) {
        String evenStr = "";
        String oddStr = "";

        for (int y = 0; y < digits.length; y++) {
            if (digits[y] % 2 == 0) {
                evenStr += " " + digits[y];
            } else {
                oddStr += " " + digits[y];
            }
        }
        System.out.println("Even numbers:" + evenStr);
        System.out.println("Odd numbers:" + oddStr);
    }

    // sum and multiplication of integer numbers from command line
    private static void sumMultDigits(String[] args) {
        int sum = 0;
        int mult = 1;

        for (String x : args) {
            System.out.println("x = " + x);
            sum += Integer.parseInt(x);
            mult *= Integer.parseInt(x);
        }
        System.out.println("sum = " + sum);
        System.out.println("mult = " + mult);
    }

    // compare string from command line with pattern string
    private static void compareStr(String arg) {
        String _pattern1 = "Sample1";
        String _pattern2 = "Sample2";

        if (_pattern1.equals(arg)) {
            System.out.println("Strings are the same: String1 = " + arg + ", String2 = " + _pattern1);
        } else {
            System.out.println("Strings are differ: String1 = " + arg + ", String2 = " + _pattern1);
        }

        if (_pattern2.equals(arg)) {
            System.out.println("Strings are the same: String1 = " + arg + ", String2 = " + _pattern2);
        } else {
            System.out.println("Strings are differ: String1 = " + arg + ", String2 = " + _pattern2);
        }
    }

    // random generator; print on one line and on many lines
    private static void randomGenerateToPrint() {
        Random randomGenerator = new Random();
        for (int i = 1; i <= 10; i++) {
            int randomInt = randomGenerator.nextInt(99);
            System.out.println(i + ": = " + randomInt);
        }
        for (int i = 1; i <= 10; i++) {
            int randomInt = randomGenerator.nextInt(99);
            System.out.print(randomInt + " ");
        }
    }

    // invert command line
    private static void invertCmd(String[] args) {
        System.out.println(Arrays.toString(args));
        for (int i = 0; i < (args.length - 1) / 2; i++) {
            String temp = args[i];
            args[i] = args[args.length - 1 - i];
            args[args.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(args));
    }

    // print greeting from command line
    private static void getGreetings(String arg) {
        System.out.println("Hello, " + arg + "!");
    }


}
