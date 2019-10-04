package groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GetGroupOfAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		if(strs.length == 0 || strs == null){
			return new ArrayList<List<String>>();
		}
		
		// Storing the sorted string as a key and each string of the array as a value
		HashMap<String, List<String>> map = new HashMap<>();
		
		for(String word : strs){
			// For the word, make each letter into char
			char[] charArray = word.toCharArray();
			
			// Sort the word since we want duplicate as the same key
			Arrays.sort(charArray);
			
			// Using the sorted string as a key for the map
			String keyWord = String.valueOf(charArray);
			
			// If its the first time, make the key with a new list
			if(!map.containsKey(keyWord)){
				map.put(keyWord, new ArrayList<String>());
			}
			
			// Add the string as value with the sorted string key everytime
			map.get(keyWord).add(word);
		}
	
		// return all the values 
		return new ArrayList<List<String>>(map.values());
	}
}
