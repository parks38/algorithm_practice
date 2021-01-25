package Section09;
/*
 * 풀이 시간 : 45분 
 * 시간복잡도 : O(N^2)
 * 
 * 풀이 방식: DFS
 * 	   computer             link 
 *      A   B   C           A   B   C  
 *   A  1   1   0        A  f   f   f
 *   B  1   1   0        B  f   f   f    
 *   C  0   0   1        C  f   f   f
 *   
 *    DFS : x < n search (가로로) &&  y < search (세로로)
 *    
 *    Link
 *      A  B  C    visited[i][j] == false -> true 
 *   A  t  f  f
 *   B  f  f  f
 *   C  f  f  f 
 *   
 *    Link
 *      A  B  C    visited[i][j] == false -> true 
 *   A  t  f  f    visited[j][i] == false -> true 
 *   B  f  f  f    - link : A - B 이면 반대로 B - A 도 성립 
 *   C  f  f  f 
 */

public class programmers_네트워크_ps {
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[][] visited = new boolean[n][n]; //visited 확인 
        for(int i = 0; i < n; i++){
            if(!visited[i][i]){
                answer++;
                dfs(computers, visited, i,n);
            }
        }
        return answer;
    }
    
    public static void dfs(int[][] computers, boolean[][] visited, int x, int n) {
        for(int y = 0; y < n; y++ ){
            if(computers[x][y] == 1 && !visited[x][y]) {
                visited[x][y] = true;
                visited[y][x] = true;
                dfs(computers, visited, y, n);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(3, computers));
    }
    
}
