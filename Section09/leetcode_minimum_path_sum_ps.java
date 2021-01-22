package Section09;
/**
 * 풀이 시간: 35 분  
 * 시간 복잡도 : O(N^2)
 * 풀이 방법 : DP
 *    
  int grid = [col][row]   
  
      0   1   2        0   1    2
    0 1   2   3     0  1   3    6
    1 4   5   6     1  5   8    12
    
    1.   
       0  1  2
    0  1  3  6   -> beforesum  + 현재 값
    
    
    2.    0
       0  1    -> before sum + 현재
       1  5
    
    3.    0   1   2
       0  1   3          path[1][1] = Math.min(path[0][1], path[1][0]) + gird[1][1]
       1  5   8
     
     
     
 */

public class leetcode_minimum_path_sum_ps {
	public static void  main(String[] args) 
    {     
      int cost[][] = {{1, 2, 3}, 
                      {4, 5, 6}, 
                      }; 
      System.out.print(minPathSum(cost) + "\n"); 

    } 
	
	public static int minPathSum(int[][] grid) {
        //가로 : row
        int row = grid[0].length;
        //세로 : col
        int col = grid.length;
        int[][] path = new int[col][row];
        path[0][0] = grid[0][0];
        
        // col : (i-1)(0) + (i)(0)
        for(int i = 1; i < col; i ++) {
            path[i][0] = path[i-1][0] + grid[i][0];
        }
        
        // row : (0)(i-1) + (0)(i)
        for(int i = 1; i < row; i++) {
            path[0][i] += path[0][i-1] + grid[0][i];
        }
        
        // 위아래 비교해서 가장 작은 값 더해주기 
        for(int i = 1; i < col; i++) {
            for(int j = 1; j < row; j++){

                    path[i][j] = Math.min(path[i-1][j] , path[i][j-1]) + grid[i][j];    
                
            }
        }
        return path[col-1][row-1];
    }
	
	

}
