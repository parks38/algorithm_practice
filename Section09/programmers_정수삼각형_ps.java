package Section09;
/*
 * 풀이 시간 : 35분 
 * 시간복잡도 : O(N^2)
 * 
 * 풀이 방식: Dynamic Programming 
 * 	  Top-Down 방식 dp 
 * 	   
 *    0  1  2  3  4  
 *    7
 *    10 15
 *    18 16 15
 *    20 25 20 19
 *    24 30 27 26 25
 *    
 *    i == 0 : dp[i-1][j] + triangle[i][j]
 *    i == j : dp[i-1][j-1] + triangle[i][j]
 *    가운데 값은 Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]
 *    
 */

public class programmers_정수삼각형_ps {
	    public static int solution(int[][] triangle) {
	        int answer = 0;
	        int n = triangle.length; // col
	        int m = triangle[n-1].length; //row
	        int[][] dp = new int[n][m];
	        dp[0][0] = triangle[0][0];
	        for(int i = 1; i < triangle.length; i++) {
	            for(int j = 0; j < triangle[i].length; j++){
	                if(j == 0) {
	                    dp[i][j] = dp[i-1][j] + triangle[i][j];
	                } else if (j ==i) {
	                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
	                } else {
	                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
	                }
	                answer = Math.max(answer, dp[i][j]);
	            }
	        }

	        return answer;
	    }
	    
		public static void main(String args[]) {
		      int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		      int ans = solution(triangle);
		      System.out.println(ans);
		}

}
