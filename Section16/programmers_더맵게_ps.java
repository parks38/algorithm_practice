package Section16;
/**
 * 풀이시간 : 40분
 * 시간 복잡도 : O(N)
 * 풀이 과정 : 힙
 *    PriorityQueue 를 이용하면 Arrays.sort 를 매 loop 마다 해야하는 번거로움을 없앨수 있다.
 *    수식 : 섞음 음식 스코빌 = 가장 안매운 + 두번째로 덜배운 * 2
 *
 */

import java.util.PriorityQueue;

public class programmers_더맵게_ps {

  public static int solution(int[] scoville, int K) {
    int answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i : scoville) {
      pq.add(i);
    }

    while(!pq.isEmpty()) {
      // 모든 음식의 스코빌 지수를 K 이상으로 만드지 못할 경우 return -1
      if(pq.size() == 1) {
        answer = pq.poll() < K ? -1: 1;
        break;
      }
      // 가장 덜 매운 음식이 K 보다 놓을 경우
      if(pq.peek() > K) break;
      // add 섞은 음식 스코빌 지수
      pq.offer(pq.poll() + pq.poll() * 2);
      answer++;
    }
    return answer;
  }

  public static void main(String[] args) {
    int[] scoville = {1,2,3,9,10,12};
    int K = 7;
    solution(scoville, K);
  }

}
