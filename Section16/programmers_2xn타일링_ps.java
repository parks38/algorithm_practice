package Section16;
/**
 * 풀이시간 : 30분
 * 시간 복잡도 : O(N)
 * 풀이 과정 : DP (피보나치 수열)
 *    [i] = [i-2] + [i-1]
 *    1 - 1
 *    2 - 2 (+1)
 *    3 - 3 (+2)
 *    4 - 5 (+3)
 *    5 - 8 (+5)
 *    6 - 13
 */

public class programmers_2xn타일링_ps {
  public static int solution(int n) {
    int[] sum = new int[n+1];
    sum[1] = 1;
    sum[2] = 2;
    for(int i = 3; i <= n; i++) {
      sum[i] = (sum[i-2] + sum[i-1]) % 1000000007;
    }
    return sum[n];
  }
  public static void main(String[] args) {
    System.out.println(solution(6));
  }
}
