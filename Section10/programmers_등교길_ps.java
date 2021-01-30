package Section10;
/*
 * 풀이 시간 : 30 분
 * 시간복잡도 : O(N^2)
 *
 * 풀이 방식: Dynamic Programming
      0  1      2      3        4
   0  0  0      0      0        0
   1  0  1     1(0+1) 1(0+1) 1(0+1)
   2  0 1(0+1) 0 (-1) 1(0+1) 2(1+1)
   3  0 1(0+1) 1(1+0) 2(1+1) 4(2+2)  = 4
 */

public class programmers_등교길_ps {
    public static void main(String args[]){
        int[][] puddles = {{2, 2}};
        System.out.println(solution(4,3,puddles));
    }
    public static int solution(int m, int n, int[][] puddles) {

        int[][] dp = new int[n+1][m+1];

        // 웅덩이 표시해주기
        for(int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }

        dp[1][1] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(dp[i][j] == -1){
                    // 웅덩이로는 지나갈수 없기 때문에 0 route
                    dp[i][j] = 0;
                } else if (i == 1 && j == 1){
                    continue;
                } else {
                    // 해당 값 = 위에 값 + 왼쪽값 % 1000000007;
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]);
                }


            }
        }
        return dp[n][m]%1000000007;
    }
}
