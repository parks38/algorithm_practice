package Section09;
import java.util.*;

public class programmers_가장먼노드_정답만 {
	   public static void main(String[] args) {
	       int[][] computers = {{3,6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
	       System.out.println(solution(6, computers));
	    }
	    
	    public static int solution(int n, int[][] edge) {
	        int answer = 0;
	        boolean[][] visited = new boolean[n][n];
	        int[] list = new int[n];
	        
	        for(int i = 0 ;i < edge.length; i++){
	            // i = 0 1
	            //    [3,7]  -> visited[3,7]&& visited[7,3] = true;
	            visited[edge[i][0]-1][edge[i][0]-1] = true;
	            visited[edge[i][1]-1][edge[i][1]-1] = true;
	            visited[edge[i][0]-1][edge[i][1]-1] = true;
	            visited[edge[i][1]-1][edge[i][0]-1] = true;
	        }
	        for(int i = 0; i < n; i++){
	        	// 마지막 값만 찾으면 됨. 
	            for(int j = n-1; j >= i ; j--){
	               if(i <= j && visited[i][j]){
	                  list[i] = j+1;
	                  break;
	               }
	            }
	        }
	        
	        for(int i = 0; i < list.length; i++) {
	            int lastIndex = list[i];
	            // 그 열의 마지막 자리수가 더이상 연결노드가 없고
	            // 본인의 열에 해당하는 노드라면 answer++
	            if(lastIndex == list[lastIndex-1] && list[i] == i+1){
	             answer++;
	            }
	        }
	         
	        return answer;
	   }
	    
}
