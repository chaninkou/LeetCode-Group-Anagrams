package leetcode49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GetGroupOfAnagrams {
	// Time is O(nlogn) since we need to sort every key and space is O(n) since we are keeping track of the result
	public List<List<String>> groupAnagrams(String[] strs) {
		// Checking if the string array is valid, else return empty list
		if(strs.length == 0 || strs == null){
			return new ArrayList<List<String>>();
		}
		
		// Storing the sorted string as a key and each original string get added as a value.
		Map<String, List<String>> map = new HashMap<>();
		
		// Go through the whole array
		for(String word : strs){
			// For the word, make each letter into char array
			char[] charArray = word.toCharArray();
			
			// Sort the word since every anagrams will need the same key
			Arrays.sort(charArray);
			
			// Using the sorted string as a key for the map
			// String.valueOf will cast the array to a string
			String keyWord = String.valueOf(charArray);
			
			// If its the first time seeing the key, add the key with the value of a new list
			if(!map.containsKey(keyWord)){
				map.put(keyWord, new ArrayList<String>());
			}
			
			// Add the string as value with the sorted string key every time
			// If the value is an arraylist, you could get the list and use the add method to add string
			map.get(keyWord).add(word);
		}
	
		// return all the values, a way to return values
		// map.values() is a list
		return new ArrayList<List<String>>(map.values());
	}

	// Using int[26] to store key instead of sorting the key as string
	// Since it will be a number
	public List<List<String>> groupAnagrams2(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for (String s : strs) {
			// Instead of sorting, just turn the number as key
			int[] uniqueKeyArray = new int[26];
			
			// This will only work if input are only lowercase
			for (int i = 0; i < s.length(); i++) {
				uniqueKeyArray[s.charAt(i) - 'a']++;
			}
			
			String key = Arrays.toString(uniqueKeyArray);
			
			// Make sure to create an empty list first when nothing is in
			List<String> tempList = map.getOrDefault(key, new LinkedList<String>());
			
			tempList.add(s);
			
			map.put(key, tempList);
		}
		return new LinkedList<>(map.values());
	}

}
