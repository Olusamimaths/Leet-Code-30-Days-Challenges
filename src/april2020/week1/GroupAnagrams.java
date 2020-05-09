package april2020.week1;

import java.util.Arrays;

public class GroupAnagrams {
    /**
     * Method 1
     * Convert each string to an array, sort the array and form new Strings
     * If the strings are equal, then they are anagrams
     * Time Complexity O(nlogn)
     * @param {String} first
     * @param {String} second
     * @return
     */
    static Boolean areAnagrams(String first, String second) {
        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        return (new String(firstArray)).equals(new String(secondArray));
    }

    /**
     * Counting the characters with 2 arrays
     * This method assumes that the set of possible characters in both strings is small
     * Time complexity O(n)
     * @param first
     * @param second
     * @return
     */
    static Boolean areAnagramsMethod2(String first, String second) {
        int NO_OF_CHARS = 256;

        // if both strings are of different length, return false
        if(first.length() != second.length()) return false;

        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();
        // create count arrays of 256 characters and fill with 0 initially
        int count1[] = new int[NO_OF_CHARS];
        Arrays.fill(count1, 0);
        int count2[] = new int[NO_OF_CHARS];
        Arrays.fill(count2, 0);

        // for each character in the input strings,
        // increment count in the corresponding count arr
        for(int i = 0; i < first.length() && i < second.length(); i++) {
            // for explanation of below read this
            // https://stackoverflow.com/questions/11069609/java-create-an-array-with-letter-characters-as-index
            count1[firstArray[i]]++;
            count2[secondArray[i]]++;
        }

        // compare count arrays
        for(int i = 0; i < NO_OF_CHARS; i++)
            if(count1[i] != count2[i]) return false;

        return true;
    }

    /**
     * Counting with just 1 array - optimization of Method 2
     * @param first
     * @param second
     * @return
     */
    static Boolean areAnagramsMethod3(String first, String second){
        int NO_OF_CHARS = 256;

        // if both strings are of different length, return false
        if(first.length() != second.length()) return false;

        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();

        int count[] = new int[NO_OF_CHARS];
        Arrays.fill(count, 0);

        // for each character in the input strings,
        // increment count in the corresponding count arr
        for(int i = 0; i < first.length() && i < second.length(); i++) {
            count[firstArray[i]]++;
            count[secondArray[i]]--;
        }

        // if there is any non-zero value in the count array, return false
        for(int i = 0; i < NO_OF_CHARS; i++)
            if(count[i] != 0) return false;

        return true;
    }

    public static void main(String[] args) {
        String first = "geeksforgeeks";
        String second = "forgeeksgeeks";
        System.out.println("Anagrams? " + areAnagramsMethod3(first, second));
    }
}
