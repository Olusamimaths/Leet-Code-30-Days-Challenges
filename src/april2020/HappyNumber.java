package april2020;
import java.util.Set;
import java.util.HashSet;

/**
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 */

public class HappyNumber {
    static int getSumOfDigits(int n) {
        if(n <= 1) return n;
        int sum = 0;
        int digit = 0;
        while(n != 0) {
            digit = n%10;
            sum += digit*digit;
            n /= 10;
        }
        return sum;
    }
    static boolean isHappy(int n) {
        boolean happy = false;
        Set<Integer> set = new HashSet<>();
        int size = 0;
        int prevSize = 0;

        while(!happy){
            //get the size
            prevSize = size;
            n = getSumOfDigits(n);
            // insert the sum of the squares to the digits to the set
            set.add(Integer.valueOf(n));
            // get a new size
            size = set.size();
            // if the set contains 1, the number is happy
            // please break, will you? :)
            if(set.contains(1)) {
                happy = true;
                break;
            }
            // if the set does not contain 1 and the size has not changed, that means
            // we have reached an endless cycle, break!!!
            else if(prevSize == size) {
                happy = false;
                break;
            }
        }
        return happy;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}

