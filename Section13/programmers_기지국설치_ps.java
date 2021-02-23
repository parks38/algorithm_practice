package Section13;
/**
 *  풀이 시간 : 45분
 *  시간복잡도 : O(N)
 *  풀이 과정 : 그리디 알고리즘
 *   - 주어진 기지국에서의 범위내에서 왼편을 탐색한후 남은 오른쪽 탐색
 *  #1 current = 1 이 이미 기지국에 의해서 cover 된다면
 *     current = right + 1
 *
 *  #2 기지국의 왼쪽의 범위에 대한 기지국 개수 검색
 *
 *  #3 기지국의 범위가 끝났을경우, n - current(마지막 기지국 범위 cover + 1) 범위 탐색하여
 *      기지국 개수 탐색
 *
 *   - remainder 있다면 기지국 개수 + 1 필요 (remainder 만큼 cover 하지 못했다는 의미)
 *
 */
public class programmers_기지국설치_ps {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int left = 0;
        int right = 0;
        int current = 1;

        for(int i = 0; i < stations.length; i++) {
            left = stations[i] - w;
            right = stations[i] + w;
            // current = 1 부분 이미 기지국의 범위 안에 들어와 있음
            if(current >= left) {
                current = right + 1;
            } else { // curr 부터 left까지의 왼편에 해당하는 부분의 기지국 개수
                answer += checkStation(current, left, w);
                current = right + 1;
            }
        }
        // current - n 까지의 기지국 개수 검색 (오른쪽 탐색)
        if(current <= n) {
            answer += checkStation(current, n+1, w);
        }

        return answer;
    }

    // 기지국의 개수를 구하기는 공통 메소드
    private static int checkStation(int start, int end, int w) {
        int cover = 2 * w +1;
        int result = (end - start) / cover;
        if((end-start) % cover != 0) {
            result++;
        }
        return result;
    }

    public static void main(String[] args){
        int[] stations = {4,11};
        System.out.println(solution(11, stations, 1));
    }
}
