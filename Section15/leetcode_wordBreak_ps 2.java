package Section15;
/**
 * 풀이 시간: 45분
 * 시간복잡도 : O(N^2)
 * 풀이 방식:
 *  answer 은 word가 생성되었고 시작하는 첫번째 index 를 true 로 만들어준다.
 *  start 와 end 를 loop 하여 word안에 있는 단어가 포함되어 있는지 확인.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode_wordBreak_ps {
  public static boolean wordBreak(String s, List<String> wordDict) {
    boolean[] answer = new boolean[s.length()+1];
    Set<String> wordSet = new HashSet<>(wordDict);
    answer[0] = true;
    for(int i = 1; i <= s.length(); i++) { //end
      for(int j = 0; j < i; j++) { //start
        if(answer[j] && wordSet.contains(s.substring(j, i))) {
          answer[i] = true;
          break;
        }
      }

    }
    return answer[s.length()];

  }

  public static void main (String[] args) {
    String s = "leetcode";
    List<String> wordDict = new ArrayList<>();
    wordDict.add("leet");
    wordDict.add("code");
    wordBreak(s, wordDict);
  }

}
