package Section15;
/**
 * 풀이 시간: 30분
 * 시간복잡도 : O(V+E)
 * 풀이 방식:
 *  dfs를 통해 모든 값이 더해지고 빼진 경우를 모두 탐색한여 생성된 답이 target과 일치할때마다
 *  1을 더해주어 경우의 수를 찾는다.
 */

public class programmers_타겟넘버_ps {
  public static int solution(int[] numbers, int target) {
    return dfs(numbers, 0, 0, target);
  }

  public static int dfs(int[] numbers, int sum, int curr, int target){
    if(curr == numbers.length) {
      if(target == sum) {
        return 1;
      } else {
        return 0;
      }
    }
    return dfs(numbers, sum + numbers[curr], curr+1, target) +
        dfs(numbers, sum - numbers[curr], curr+1, target);
  }

  public static void main(String[] args) {
    int[] numbers = {1,1,1,1,1};
    int target = 3;
    int ans = solution(numbers, target);
    System.out.println(ans);

  }

}
