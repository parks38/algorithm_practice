package Section07;

/**
 * 풀이 시간: 초과 
 * 시간 복잡도 : O(N*M) space: O(n*m)
 * 풀이 방법 : Dynamic Programming
 * 
 *     original matrix
 *     
 * 	   [0]   [1]   [2]   [3]   [4]
 * [0]  1     0     1     0     0
 * [1]  1     0     1     1     1
 * [2]  1     1     1     1     1
 * [3]  1     0     0     1     0
 * 
 * 
 *       Dynamic Programming
 *     
 * 	   [0]   [1]   [2]   [3]   [4]
 * [0]  1     0     1     0     0
 * [1]  1     1     1     1     1
 * [2]  1     2     1     2     2
 * [3]  1     0     0     1     0
 *         
 */

public class leetcode_MaximumSquare_ps {
	public static void main(String args[]) {
		maximalSquare(new char[][]{
	                {'1','0','1','1'},
	                {'1','1','0','1'},
	                {'1','1','1','1'}});

		maximalSquare(new char[][]{
	                {'1','0','1','0','0'},
	                {'1','0','1','1','1'},
	                {'1','1','1','1','1'},
	                {'1','0','0','1','0'}});

		
	}
	
    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = 0; 
        // extra space dp 정보를 담을 matrix
        int[][] dp = new int[rows + 1][cols + 1];
        int maxSum = 0;
        if(rows > 0) cols = matrix[0].length;
        for(int i = 1; i <= rows; i++){
             for(int j = 1; j <= cols; j++){
                 // top left pointer
                if(matrix[i-1][j-1] == '1') {
                	// 질문...
                	// ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1

                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    // 가장 큰 숫자가 가장 큰 square의 length 크기이기 때문에 tracking 해준다. 
                    maxSum = Math.max(maxSum, dp[i][j]);
                }
            }  
        }
        return maxSum * maxSum;
    }
}
