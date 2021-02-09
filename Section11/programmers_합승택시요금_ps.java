package Section11;
/*
 *  풀이 시간 : 초과
 *  시간복잡도 : O(N^3)
 *  풀이 과정 : 플로이드 와샬 - 다익스트라로도 풀이 가능
 *  모든 값에서의 각각의 최소 값을 구한후에
 *  s -> i -> a
 *  s -> i -> b (최소 거리 구하기)
 *  최대값 제한 사항 :
 *  // 요금 f는 1 이상 100,000 이하인 자연수입니다.
 *  //지점갯수 n은 3 이상 200 이하인 자연수입니다.
 */

public class programmers_합승택시요금_ps {
    // private static int INF = (int)1e9; > ERROR!

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int max = n * 100000;
        int answer = max;
        int[][] map = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j =1; j <= n; j++){
                if(i == j) map[i][i] = 0;
                else map[i][j] = max;
            }
        }
         for(int i = 0 ; i < fares.length; i++){
            map[fares[i][0]][fares[i][1]] = fares[i][2];
            map[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++ ){
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);

                }
            }
        }

        for(int i = 1; i <= n; i++){
            answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
        }


        return answer;
    }



    public static void main(String[] args) {
        System.out.println(
                solution(6, 4, 6, 2, new int[][] { {4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25} })
        );
        System.out.println(
                solution(7, 3, 4, 1, new int[][] { {5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6} })
        );
        System.out.println(
                solution(6, 4, 5, 6, new int[][] { {2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9} })
        );
    }
}
