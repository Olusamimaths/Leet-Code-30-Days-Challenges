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
     * @param String[] strs : example
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
}
