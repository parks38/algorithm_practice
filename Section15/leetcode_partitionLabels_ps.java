package Section15;
/**
 * 풀이 시간: 30분
 * 시간복잡도 : O(N)
 * 풀이 방식:
 *  1. 문자의 마지막 Index 위치를 map 에 저장
 *  2. string 의 문자를 매핑되있는 마지막 index 위치로 변환
 *  3. 만약 마지막 알파벳의 마지막 위치 == 문자열에서의 위치
 *      && 마지막 위치 == 지금까지의 문자열중 가장 높은 lastIndex, 파티션을 나눠준다.
 *
 *  <Better Solution>
 *  1. int[] last = new int[26];
 *  for (int i = 0; i < S.length(); ++i)
 *        last[S.charAt(i) - 'a'] = i;
 *
 *  2. j = Math.max(j, last[S.charAt(i) - 'a']);
 *  -- space complexity O(1) 만쓰고 구현 가능하다.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode_partitionLabels_ps {
  public static List<Integer> partitionLabels(String s) {
    List<Integer> answer = new ArrayList<>();
    HashMap<Character, Integer> count = new HashMap<>();
    for(int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      count.put(current, i);
    }

    int[] lastList = new int[s.length()];
    for(int i = 0; i < s.length(); i++) {
      int lastIndex = count.get(s.charAt(i));
      lastList[i] = lastIndex;
    }
    int start = 0;
    int max = 0;
    for(int i = 0; i < lastList.length; i++) {
      max = Math.max(max, lastList[i]);
      if(lastList[i] == i && max == lastList[i]){
        answer.add(i-start +1);
        start = i + 1;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
  }

}
