package leetcode49;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		String[] strs = {"eat",  "tea", "tan", "ate", "nat", "bat"};
		
		System.out.println("Input: " + Arrays.toString(strs));
		
		GetGroupOfAnagrams solution = new GetGroupOfAnagrams();
		
		System.out.println("Solution: " + solution.groupAnagrams(strs));
	}
}
