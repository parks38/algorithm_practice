package Section07;

import java.util.*;
/**
 * 풀이 시간: 50분
 * 시간 복잡도 : O(3^N * 4 ^M) -> N : letter 을 3개 가지고 있는 digits &&  M : letter 을 4개 가지고 있는 digits 
 * 풀이 방법 : BackTracking 
 * 			               digits  " 2,3 "
 * 
 *          digit                 2
 *         letters     a          b          c
 *         digit       3          3          3
 *         letters  d  e  f    d  e  f    d  e  f
 *         
 *         output   [ad, ae, af, bd, be, bf, cd, ce, cf]
 *         
 */

public class leetcode_LetterCombinationsofaPhoneNumber_ps {
	static List<String> output = new ArrayList<String>();
	static Map<String, String> phoneMap = new HashMap<String, String>();
	
	public static void main(String args[]) {
		String digits = "23";
		letterCombination(digits);
		System.out.println(output);
		
	}
	
	public static List<String> letterCombination(String digits){
		phoneMap.put("2", "abc");
		phoneMap.put("3", "def");
		phoneMap.put("4", "ghi");
		phoneMap.put("5", "jkl");
		phoneMap.put("6", "mno");
		phoneMap.put("7", "pqrs");
		phoneMap.put("8", "tuv");
		phoneMap.put("9", "wxyz");
		
		if(digits.length() != 0) backtrack("", digits);
		
		return output;
		
	}
	
	public static void backtrack (String combination, String digits_rest) {
		
		// 더이상 digits에 남은 값이 없을 경우 
		// digits에 대한 배열 combination을 output에 저장  
		if(digits_rest.length() == 0) output.add(combination);
		
		// digits에 대한 배열을 만드는 경우 
		else {
			// 주어진 digits_rest의 index = 0 추출 
			String digit = digits_rest.substring(0, 1);
			// 해당 index 에 대한 letter 조합 추출 
			String letters = phoneMap.get(digit);
			
			// 해당 digit 에 대한 letters 조합 만큼 combination 제작 
			for(int i = 0; i < letters.length(); i++) {
				//           index   0  1  2
				// phoneMap.get(2)   a  b  c 
				// phone.get(digit)의 index = i 
				String letter = phoneMap.get(digit).substring(i, i +1); 
				// 추출한 데이터로 combination 만들고 나머지 digits 탐색 
				backtrack(combination + letter, digits_rest.substring(1));
			}
		}
		
	}
}
