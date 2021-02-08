package Section11;
/*
 *  풀이 시간 : 초과
 *  시간복잡도 : O(n)
 *  풀이 과정 :
 *  최소 시간과 최대시간을 범위로 이분 탐색
 *  ex.
 *  mid 30 초 -> estimatePeople = 30/7 + 30/10 = 4 +3 (7)
 *  30초 동안 총 7 명의 사람 보기 가능
 *  int n = 6 > estimatePeople (left 탐색) (1-29초 사이 재탐색)
 */
import java.util.*;
public class programmers_입국심사_ps {
    public static long solution(int n, int[] times) {

        Arrays.sort(times); // 크기 순으로 정렬

        long left = 1;
        long right = (long) n * times[times.length-1];
        long answer = right;
        while(left <= right){
            long mid = (left + right) / 2;
            long estimatePeople = 0;
            for(int i = 0; i < times.length; i++){
                estimatePeople += mid / times[i];
            }
            if(estimatePeople < n){ // 해당시간안에 입국 심사 끝낼수 없음 (right 재탐색)
                left = mid + 1;

            }
            else{// 해당 시간안에 끝낼수 있음. (left 재탐색)
                right = mid -1;
                answer = mid;

            }
        }

        return answer;
    }


    public static void main(String args[]){
        int[] times = {7, 10};
        System.out.println(solution(6, times));
    }
}
