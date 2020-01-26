package groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetGroupOfAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		// Checking if the string array is valid, else return empty list
		if(strs.length == 0 || strs == null){
			return new ArrayList<List<String>>();
		}
		
		// Storing the sorted string as a key and each original string get added as a value
		Map<String, List<String>> map = new HashMap<>();
		
		// Go through the whole array
		for(String word : strs){
			// For the word, make each letter into char array
			char[] charArray = word.toCharArray();
			
			// Sort the word since every anagrams will need the same key
			Arrays.sort(charArray);
			
			// Using the sorted string as a key for the map
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
}
