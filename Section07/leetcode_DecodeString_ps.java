package Section07;

/**
 * 풀이 시간: 30분
 * 시간 복잡도 : O(2N) ???
 * 풀이 방법 : Stack 1. 숫자를 담기 2. 문자열을 담기  
 * 			두개의 stack 에 각자 숫자와 문자열을 담고 뽑아내면서 실행
 * 			숫자와 문자의 구분읜 [] 으로 가능하다.  
 * 			[ - 문자열 시작  ] - 문자열 끝 
 *         
 */

import java.util.*;

public class leetcode_DecodeString_ps {
	public static void main(String args[]) {
		String input = "2[abc]3[cd]ef";
		// output : abcabccdcdcdef
		System.out.println(decodeString(input));
		
	}
	
    public static String decodeString(String s) {
    	String answer = "";
        Stack<Integer> num = new Stack<>();
        Stack<String> chars = new Stack<>();
        int index = 0;
        
        while(index < s.length()){
            // 1. 숫자일 경우 
            if(Character.isDigit(s.charAt(index))) {
                int count = 0;
                // 숫자 자리수 트래킹을 위해 
                while(Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
                num.push(count);
            } else if (s.charAt(index) == '[') {
            // 2. 문자열 시작   
                chars.push(answer);
                answer = "";
                index++;
            } else if (s.charAt(index) == ']') {
            //3. 문자열 끝
                StringBuilder temp = new StringBuilder(chars.pop());
                int count = num.pop();
                for(int i = 0 ; i < count; i++) {
                    temp.append(answer);
                }
                answer = temp.toString();
                index++;
                
            } else {
            // 4. 문자일 경우
                answer += s.charAt(index);
                index++;
            }
        }
        return answer;
    }
}
