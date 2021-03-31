package Section16;
/**
 * 풀이시간 : 시간 초과
 * 시간 복잡도 : O(N^2)
 * 풀이 과정 :
 *    Stack<Integer> multiples : 문자열을 반복해서 출력해야할 횟수를 담은 스택
 *    Stack<String> charSet : [] 안의 문자열을 담은 세부 문자열
 *    2[abc]
 *    multiples : 2
 *    charset : abc
 *
 *    2[a3[bc]]
 *    multiples : 2 3
 *    charset : a bc
 *    이런 경우 미리 charSet stack에 들어가 있던 a 가
 *    3[bc] 를 진행 할 동안 먼저 StringBuilder comb 에 같이 더해진다 = abcbcbc
 *    2[a3[bc]] 를 구한때는 charSet 스택에 pop 할 값이 없기 때문에
 *    abcbcbc 를 multiples에 있는 2 만큼 돌린다.
 */

import java.util.Stack;

public class leetcode_decodeString_ps {

  public static String decodeString(String s) {
    Stack<String> charSet = new Stack<>();
    Stack<Integer> multiples = new Stack<>();

    String result = "";
    int index = 0;

    while(index < s.length()) {
      if(Character.isDigit(s.charAt(index))) {
        int count = 0;
        while(Character.isDigit(s.charAt(index))) {
          count = 10 * count + (Character.getNumericValue(s.charAt(index)));
          index++;
        }
        multiples.push(count);
      } else if (s.charAt(index) == '[') {
        charSet.push(result); // abc2[a] 이런 경우
        result = "";
        index++;
      } else if (s.charAt(index) == ']') {

        StringBuilder comb = new StringBuilder(charSet.pop());
        int count = multiples.pop();
        // 2[a3[bc]] = bcbc - abcbcabcbc
        // result = ""
        for(int i = 0; i < count; i++) {
          comb.append(result);
        }
        result = comb.toString();
        index++;
      } else {
        result += s.charAt(index);
        index++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    //2[abc]3[cd]
    //3[a2[c]]
    System.out.println(decodeString("3[a2[c]]"));
  }

}
