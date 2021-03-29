package Section16;
/**
 * 풀이시간 : 50분
 * 시간 복잡도 : O(V+E)
 * 풀이 과정 :
 *    dfs 를 이용한 모든 경우의 수 탐색
 *    2, 3, 6, 7
 *    2-2-2-2   2-2-2   2-2   2 ... continue
 *    2-2-2-3   2-2-3   2-3
 *    2-2-2-6   2-2-6   2-6
 *    2-2-2-7   2-2-7   2-7
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_combinationSum_ps {
  private static List<List<Integer>> answer;
  private static List<Integer> result;

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    answer = new ArrayList<>();
    result = new ArrayList<>();
    Arrays.sort(candidates);
    dfs(candidates, target, 0, 0);
    return answer;
  }

  public static void dfs(int[] candidates, int target, int total, int index) {
    if (total == target) {
      answer.add(new ArrayList<>(result));
      return;
    }
    if(total > target) {
      return;
    }
    for(int i = index; i < candidates.length; i++) {
      result.add(candidates[i]);
      dfs(candidates, target, total + candidates[i], i);
      result.remove(result.size()-1);
    }
  }

  public static void main(String[] args) {
    int[] candidates = {2, 3, 6, 7};
    int target = 7;
    List<List<Integer>> answer = combinationSum(candidates, target);
    System.out.println(answer);
  }

}
