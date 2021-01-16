package Section8;

/*
 * 풀이 시간: 45분
 * 시간 복잡도 : O(N)
 * 공간 복잡도 : O(1) 
 * 풀이 방법 : 
 *   1. 각 문자가 마지막에 position 하는 위치를 트래킹한다.
 *   	 index: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
 *              a b a b c b a c a d  e  f e   g  d  e  h  i
 *       
 *  indexChecker : a b c d  e  f    g   h  i
 *     lastindex : 8 5 7 14 15 11  13  16 17
 *     
 *     범위 : 0-8 | 9-15 | 16 | 17
 *     output : [9, 7, 1, 1]
 *     
 *    2. if(end == index) => partition 나뉠 부분 
 *        - end : 해당 문자열에서 가장 마지막 오는 index
 *          해당 문자열의 위치가 end 와 같다면 그 이후로 오는 문자들은 새로운 단어 group. 
 */

import java.util.*;


public class leetcode_PartitionLabels_ps {
	public static void main(String args[]) {
		//String S = "ababcbacadefegdehijhklij";
		String S = "ababcbacadefegdehi";
		System.out.println(partitionLabels(S));
		
	}
	
    public static List<Integer> partitionLabels(String S) {
        List<Integer> partitionLength = new ArrayList<>();
        int[] LetterlastIndex = new int[26];
        for(int i = 0; i < S.length(); i++) {
        	// keep charachter in order 
        	LetterlastIndex[S.charAt(i) - 'a'] = i;
        }
        
        int end = 0;
    	int start = 0;
        
        for(int i = 0 ; i < S.length(); i++) {
        	end = Math.max(end, LetterlastIndex[S.charAt(i) - 'a']);
        	if(end == i) {
            	partitionLength.add(end - start + 1);
            	// 파티션 안의 string 개수 
            	
            	start = end +1; 
            	// 파티션 이후부터 재탐색 시작 부분 update 
        	}
        	
        }
        
        return partitionLength;
    }
}
