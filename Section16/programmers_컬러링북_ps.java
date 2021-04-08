package Section16;
/**
 * 풀이 시간: 시간초과
 * 시간복잡도 : O(V+E)
 * 풀이 방식:
 *  배열의 영역을 구하는 문제
 *  하나의 색칠이 되어있는 박스에 상하좌우 방향으로 연결돼 있는 박스가 존재 한다면
 *  dfs를 통해 해당 영역의 몇개의 박스로 구성돼 있는지 확인.
 *   - 색이 있고 방문하지 않은 영역을 찾아 dfs
 *   - picture 값으로 같은 영역을 구해야 하므로 isVisited 라는 배열로
 *     방문한 곳인지 확인.
 *   - dx, dy 는 상하좌우의 좌표를 구할 수 있도록 해주는 배열
 */

import java.util.Arrays;

public class programmers_컬러링북_ps {
  public static int[] dx = {-1, 1, 0, 0}; // 좌우
  public static int[] dy = {0,0,-1,1}; //상하
  public static int temp_cnt;

  public static int[] solution(int m, int n, int[][] picture) {
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    temp_cnt = 0;


    boolean[][] isVisitied = new boolean[m][n];

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(picture[i][j] != 0 && !isVisitied[i][j]) {
          // 영역 update
          numberOfArea++;
          dfs(i, j, picture, isVisitied);
        }
        // 가장 큰 영역의 넓이 계산
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, temp_cnt);
        // 해당 영역의 넓이 초기
        temp_cnt = 0;
      }
    }
    int[] answer = new int[2];
    answer[0] = numberOfArea;
    answer[1] = maxSizeOfOneArea;

    return answer;
  }

  public static void dfs(int x, int y, int[][] picture, boolean[][] isVisited) {
    if(isVisited[x][y]) return;

    isVisited[x][y] = true;
    temp_cnt++;

    //상하 좌우 탐색
    for(int i = 0 ; i < 4; i++) {
      int tempX = x + dx[i];
      int tempY = y + dy[i];

      //배열에서 벗어나면 continue
      if(tempX < 0 || tempX >= picture.length || tempY < 0 || tempY >= picture[0].length) continue;

      //현재 좌표에 상하좌우 연결되는 색이 있다면 dfs 로 통해 몇개로 구성돼 있는지 확인
      if(picture[x][y] == picture[tempX][tempY] && !isVisited[tempX][tempY]) {
        dfs(tempX, tempY, picture, isVisited);
      }

    }
  }


  public static void main(String[] args) {
    int[][] picture = {{1,1,1,0},{1,2,2,0}, {1,0,0,1}, {0,0,0,1}, {0,0,0,3}, {0,0,0,3}};
    int[] answ = solution(6,4, picture);
    System.out.println(Arrays.toString(answ));
  }

}
