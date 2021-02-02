package Section10;
/*
 *  풀이 시간 : 초과
 *  시간복잡도 : O(N^2)
 *  가장 최적의 이동횟수를 찾아야 하는 문제
 *  1. 해당 글자 up / down
 *  2. cursor 움직이는 경우
 *     - J E R O E N : 일렬로 cursor 옮기면서 글자위치 더해주면 됨.
 *     - A B A A A A B A : B -> A * 5 -> B 를 탐색하기 보다
 *                         B <- A <- A <- B(현재) 탐색하는 것이 최소의 거리
 *
 *      Math.min(cursor, i + nameLength - next + i);
 */

public class programmers_조이스틱_ps {
    public static void main(String[] args) {
        solution("JAN");
    }

    public static int solution(String name) {
        int answer = 0;
        int nameLength = name.length();
        int cursor = nameLength - 1;
        for (int i = 0; i < nameLength; i++) {
            // A부터 시작 or Z 부터 뒤에서 부터
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            int next = i + 1;
            // 앞으로 나올 A 가 몇개인지 tracking
            while (next < nameLength && name.charAt(next) == 'A') {
                next++;
            }
            // 일열로 cursor을 옯겼을 경우
            // cursor을 앞뒤로 옮겨갔을 경우
            cursor = Math.min(cursor, i + nameLength - next + i);
        }
        answer += cursor;

        return answer;
    }

}
