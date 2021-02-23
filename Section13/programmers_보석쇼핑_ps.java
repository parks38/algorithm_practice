package Section13;
/**
 *  풀이 시간 : 초과
 *  시간복잡도 : O(N)
 *  풀이 과정 : 투 포인터
 *  - hashset 이용해서 보석의 종류 찾기
 *  - hashmap : 보석의 종류와 개수 저장
 *  - map의 크기와 set의 크기가 같은 경우(map에 모든 보석 종류가 존재하는 경우)
 *      거리, 시작, 끝을 변수에 담아준다
 *  - 현재 길이가 최소길이보다 크거나 end가 배열의 끝에 다아있다면
 *      start에 포함된 보석을 제거하고 start를 오른쪽으로 1칸 이동
 */

import java.util.*;

public class programmers_보석쇼핑_ps {
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        // 보석의 종류
        HashSet<String> set = new HashSet<String>();
        for (String a : gems) {
            set.add(a);
        }
        Queue<String> q = new LinkedList<>();
        // 보석의 종류 , 보석의 개수
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int length = Integer.MAX_VALUE;
        int idx = 0;
        int start = 0;

        for (int i = 0; i < gems.length; i++) {

            // 배열을 돌면서 hashMap 에 없다면 값을 추가해고
            // 있다면 개수를 하나 추가해준다.
            if (!map.containsKey(gems[i]))
                map.put(gems[i], 1);
            else
                map.put(gems[i], map.get(gems[i]) + 1);

            // 큐에 보석을담아 준다.
            q.add(gems[i]);

            // 큐안에서 첫번째 위치하는 보석의 개수가
            // 1개를 초과한다면 앞에 위치한 보석은 큐에서 제거하고 -> startPoint++;
            while (true) {
                String temp = q.peek();
                if (map.get(temp) > 1) {
                    map.put(temp, map.get(temp) - 1);
                    q.poll();
                    idx++;
                } else {
                    break;
                }
            }
            if (map.size() == set.size() && length > q.size()) {
                length = q.size();
                start = idx;
            }
        }
        answer[0] = start + 1;
        answer[1] = start + length;
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        return new int[] { start + 1, start + length };
    }

    public static void main(String[] args) {
        String [] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        solution(gems);
    }

}
