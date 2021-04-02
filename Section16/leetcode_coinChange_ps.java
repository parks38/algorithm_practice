package Section16;
/**
 * 풀이시간 : 시간초과
 * 시간 복잡도 : O(V+E)
 * 풀이 과정 :
 *   dp[amount + 1]
 *   0  1  2  3  4  5  6  7  8  9  10  11
 *   0  12 12 12 12 12 12 12 12 12 12  12
 *
 *   dp[3]
 *   coins =  [1,2,5];
 *   0  1  2  3  4  5  6  7  8  9  10  11
 *   0  1  1  12 12 12 12 12 12 12 12  12
 *   Math.min(12, dp[3-2] + 1 (2 코인))
 *   : 2 인 코인을 하나 쓰게 되면 값이 3-2 = 1 이기 때문에
 *     dp[1] 을 통해 값이 1 일때 몇개의 코인인 필요한지 확인.
 *     코인이 1 일때와 2 일때를 탐색할 텐데 1일경우는 코인 3개 필요 2일때는 2개 필요
 *     Math.min을 통해 2개의 코인이 값으로 들어간다.
 *
 *   dp[11]
 *   coins =  [1,2,5];
 *   0  1  2  3  4  5  6  7  8  9  10  11
 *   0  1  1  2  2  1  2  2  3  3  2   *
 *   coin -> 5 일때
 *   11 - 5 = 6 --> dp[6] + 1 = 2 + 1 = 3
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_coinChange_ps {

  public static int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    // fill all elements in dp with amount + 1
    // amount + 1 인 이유는 coins 를 써서 없애는 방식을 하기 때문에
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;

    if(amount == 0)  return 0;
    for(int i = 0; i <= amount; i++) {
      for(int coin : coins) {
        if(coin <= i) {
          //dp[i-money] 까지의 coin + 1 coin
          dp[i] = Math.min(dp[i], dp[i-coin] + 1);
        }
      }
    }

    if(dp[amount] == amount + 1) {
      return -1;
    }

    return dp[amount];
  }
  public static void main(String[] args) {
    int[] coins = {1,2,5};
    int target = 11;
    System.out.println(coinChange(coins, target));
  }

}
