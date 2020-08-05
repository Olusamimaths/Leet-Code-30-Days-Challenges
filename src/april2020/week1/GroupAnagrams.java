package april2020.week1;

import java.util.*;

public class GroupAnagrams {
    public String sortString(String input) {
        // convert to charArray
        char[] array = input.toCharArray();
        // sort the array
        Arrays.sort(array);
        // convert the array to a string
        return String.valueOf(array);
    }

    /**
     *
     * @param String strs : example
     * @return List<List<String>> list: List containing list of grouped anagrarms
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * Output:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        // sort the strings and map the sorted string to
        // every other string that matches it in the array (when sorted too) - these are anagrams
        for(String string : strs) {
            String sortedString = sortString(string);
            // if the sorted string is seen for the first time
            // create an ArrayList mapping
            if(map.get(sortedString) == null) {
                map.put(sortedString, new ArrayList<String>());
            }
            map.get(sortedString).add(string);
        }

        // Loop through the values of the map, and add them to the list
        // that is the group of anagrams
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap<>();
        // a count array for the 26 letters of the alphabet
        int[] count = new int[26];
        // loop through for each string
        for(String s : strs) {
            // initialize count of letters in the string to 0
            Arrays.fill(count, 0);
            // count each char, starting at 0 for 'a'
            for(char c : s.toCharArray()) count[c - 'a']++;

            // build a string in the format #2#1#0#0#0.....#0
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }

            String key = sb.toString();
            // put into map just like in former implementation abouve
            if(!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        // shorter way to convert map values to array list
        return new ArrayList(map.values());
    }
}
