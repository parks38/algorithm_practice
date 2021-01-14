package Section8;

/*
 * 풀이 시간: 45분
 * 시간 복잡도 : O(N)
 * 공간 복잡도 : O(1) 
 * 풀이 방법 : 
 */

import java.util.*;


public class leetcode_PartitionLabels_ps {
	public static void main(String args[]) {
		String S = "ababcbacadefegdehijhklij";
		System.out.println(partitionLabels(S));
		
	}
	
    public static List<Integer> partitionLabels(String S) {
        List<Integer> partitionLength = new ArrayList<>();
        int[] lastIndex = new int[26];
        for(int i = 0; i < S.length(); i++) {
        	// keep charachter in order 
        	lastIndex[S.charAt(i) - 'a'] = i;
        }
        
        int index = 0;
        while (index < S.length()) {
        	int end = lastIndex[S.charAt(index) - 'a'];
        	// update 
        	int j = index;
        	while(j != end ) {
        		end = Math.max(end, lastIndex[S.charAt(j++) - 'a']);
        	}
        	
        	partitionLength.add(j- index + 1);
        	// length of partition 
        	
        	index = j+1; // moving index to j's position 
        	
        }
        
        return partitionLength;
    }
}
