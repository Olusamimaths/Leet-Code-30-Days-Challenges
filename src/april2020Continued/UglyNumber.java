/**
 * Write a program to check whether a given number is an ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 */
public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(isUgly(14));
    }

    public static boolean isUgly(int number) {
        if (number == 0)
            return false;
        if (number == 1)
            return true;

        if (number % 2 == 0) {
            number /= 2;
            return isUgly(number);
        }

        if (number % 3 == 0) {
            number /= 3;
            return isUgly(number);
        }

        if (number % 5 == 0) {
            number /= 5;
            return isUgly(number);
        }
        return false;
    }
}