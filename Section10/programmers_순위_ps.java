package Section10;
/*
 * 풀이 시간 : 초과
 * 시간복잡도 : O(N^3)
 *
 * 풀이 방식: 플로이드 워셜 알고리즘
 *   - 3 중 for 문으로 노드 개수가 적은 상황에서만 가능
 *   D(ab) = min(D(ab) , D(ak) + D(kb));
 *                             [출발] >[도착]
 *       도착  0  1  2  3  4      3 -> 4
 *    출발 0                      2 -> 4
 *        1  1      1  1         2 -> 3
 *        2            1         2 -> 1
 *        3                      5 -> 2
 *        4     1
 *
 *        ** K 노드가 기준일때
 *        j -> k (연결)   k-> i (연결) =>  j -> i 연결됨.
 *       도착  0  1  2  3  4      3 -> 4
 *    출발 0                      2 -> 4
 *        1  1      1  1         2 -> 3
 *        2            1         2 -> 1
 *        3                      5 -> 2
 *        4  1  1   1  1
 */

public class programmers_순위_ps {
    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] result = new int[n][n];
        for (int i = 0; i < results.length; i++) {
            result[results[i][0] - 1][results[i][1] - 1] = 1;
        }

        for (int i = 0; i < n; i++) {   // i == 정점 기준으로 구하기
            for (int j = 0; j < n; j++) {  // 출발 노드
                for (int k = 0; k < n; k++) {  // 도착 노드
                        // j -> i && i -> k == j -> k
                    if (result[j][i] == 1 && result[i][k] == 1) {
                        result[j][k] = 1;
                    }
                }
            }
        }

        // 각 노드들의 연결 확인하기
        for (int i = 0; i < n; i++) {
            int connection = 0;
            for (int j = 0; j < n; j++) {
                // 연결 노드 있음
                if (result[i][j] == 1 || result[j][i] == 1) connection++;
            }
            // 다른 노드들과 연결 확인 (total = 4)
            if (connection == n - 1) answer++;
        }
        return answer;
    }
    public static void main(String args[]){
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(solution(5, results));
    }
}

