package Section13;
import java.util.*;
/**
 * 풀이 시간 : 시간 초과
 * 시간복잡도 : O^2 (??)
 * 풀이 과정 : 원형 배열, 완전탐색 - Exhaustive Search / Brute Force
 *   첫번째 weak position을 기준으로 가장 멀리갈수있는 있는 친구의 distance부터 이용하여 반대로
 *   탐색하여 가장 적은 인원이 필요한 방법을 찾습니다.
 *   시계방향만 탐색합니다. 왜냐면 반시계방향과 똑같기 때문에.
 *   visited를 통해 몇개의 weak position을 지났는지를 체킹합니다.
 *   visited 는 이진법을 이용해서 이미 지나왔을경우 1의 자리를 늘려줍니다.
 *   (2) -> 11 |  (3) -> 111 | (4) -> 1111
 */

public class programmers_외벽점검_ps {
    private static final int INF = 987654321;
    private static int size;
    private static int[] weak_list;
    private static int[] dist_list;
    private static int minCnt;

    public static int solutions(int n, int[] weak, int[] dist) {
        Arrays.sort(dist);
        size = n;
        weak_list = weak;
        dist_list = dist;
        minCnt = INF;
        /**
         *  weak position starting index
         *  처음 index 위치 지정
         */
        for (int i = 0; i < weak_list.length; i++) {
            checker(1, i, 0);
        }
        // no visits
        if (minCnt == INF) return -1;

        return minCnt;

    }

    private static void checker(int cnt, int pos, int visited) {
        if (cnt > dist_list.length) return;
        // 이미 count가 저장된 minCnt 보다 큰 경우 더 이상 찾을 필요없음
        if (cnt >= minCnt) return;

        /**
         *  처음 지점에서 시계 방향으로 돌며
         *  친구들의 거리로 돌며 취약 지점을 몇개 점검할수있는지 체크
         */
        for (int i = 0; i < weak_list.length; i++) {
            int nextPos = (pos + i) % weak_list.length;
            int diff = weak_list[nextPos] - weak_list[pos]; //현재 거리 - 다음 거리

            //한바퀴 돌은 경우
            if (nextPos < pos) {
                diff += size; // diff = (size - pos) + nextPos
            }
            // 가장 멀리갈수 있는 친구부터의 거리 < nextPosition까지의 거리
            if (diff > dist_list[dist_list.length - cnt]) {
                break;
            }
            // 방문한 weak position 만큼 update
            // 지나온 weak point 만큼 binary value로 shift left
            visited |= 1 << nextPos;
        }

        /**
         * 모든 취약점 방문되었는지 확인
         * 전체 취약점 개수만큼 1 왼쪽으로 shift -1
         * 취약점 개수만큼 binary value ++
         * dis = 7
         * 1 3 4 9 10
         * 1 1 1 - (7)
         * */

        if (visited == (1 << weak_list.length) - 1) {
            minCnt = cnt;
            return;
        }

        //visited 하지않은 지점 존재하면 새로운 지점 탐색
        for (int i = 0; i < weak_list.length; i++) {
            // 이미 방문한 곳
            if ((visited & (1 << i)) != 0) continue;
            checker(cnt + 1, i, visited);

        }
    }

    public static void main(String[] args) {
        //int[] weak = {1, 3, 4, 9, 10};
        //int[] dist = {3, 5, 7};
        int[] weak1 = {1,5,6,10};
        int[] dist1 = {1,3,2,4};
        System.out.println(solutions(12, weak1, dist1));
    }
}
