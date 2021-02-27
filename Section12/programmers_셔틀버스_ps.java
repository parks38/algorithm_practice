package Section12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 *  - 기다리는 크루의 시간을 오름차순으로 정렬한다.
 *  - 버스의 시간을 초기화해주고,
 *  - 기다리는 크루가 있는지 확인
 *  - 기다리는 크루가 있다면, 버스 도착시간과 수용인원을 확인
 *  - 마지막 버스인지 확인
 *  - 마지막 버스가 아니라면, 기다리는 크루가 있는지 없는지 확인
 *  - 마지막 버스라면, 수용인원이 있는지 없는지 확인
 *  - 결과를 "00:00" 포맷에 맞춰서 반환
 */

public class programmers_셔틀버스_ps {

    /**
     * @param n : 금일 버스의 운행 수
     * @param t : 버스 운행 간격
     * @param m : 한번 태울수 있는 사람의 수 (버스 정원)
     * @param timetable : 줄서는 사람들의 도착시간
     * @return : 마지막으로 탈수 있는 버스의 시간
     */
    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int myTime = 0;
        // 크루의 시간 오름차순
        PriorityQueue<Integer> q = new PriorityQueue<>();
        List<Integer>[] list = new List[n];
        int busTime = 9 * 60;

        // 사람들 도착한 시간 숫자로 환산하여 큐에 저장
        for(int i = 0; i < timetable.length; i++){
            int hour = Integer.parseInt(timetable[i].split(":")[0]);
            int min = Integer.parseInt(timetable[i].split(":")[1]);
            int time = hour * 60 + min;

            q.add(time);
        }
        // 버스 운행 수
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
            // 기다리는 크루가 있는 경우
            while(!q.isEmpty()){
                int arrivedTime = q.poll();
                // 현재 도착해 있는 셔틀버스 보다 일찍 도착하거나 셔틀버스 정원이 차있지 않는 경우
                if(arrivedTime <= busTime && list[i].size() < m) {
                    // 셔틀버스 크루들 태움 -> 셔틀버스 정원 확인
                    list[i].add(arrivedTime);
                }  else {
                    q.add(arrivedTime);
                    break;
                }
                // 마지막 크루보다 일분더 일찍 와야한다.
                myTime = arrivedTime -1;
            }
            busTime += t;
        }

        //마지막 버스가 비었을 경우 마지막 버스 도착시간에 맞춰 오는데 정답
        if(list[n-1].size() < m) {
            myTime = busTime - t;
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
        System.out.println(solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
        System.out.println(solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
        System.out.println(solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
        System.out.println(solution(1, 1, 1, new String[]{"23:59"}));
        System.out.println(solution(10, 60, 45, new String[]{"23:59","23:59", "23:59", "23:59", "23:59", "23:59"
                , "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
    }

}
