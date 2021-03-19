package Section15;
/**
 *  풀이 시간 : 15분
 *  시간복잡도 : O(N^2)
 *  풀이 방법 :
 *     - 문자가 A인지 아닌지 확인한 후에 A부터 얼마나 떨어져있는지 확인
 *     - cursor 규칙 :
 *          cursor default 값은 일렬로 움직일경우.
 *          일열로 cursor을 움직이는게 더 빠른지 뒤로 탐색하는것이 더 빠른지 확인하며
 *          cursor steps 더해줌.
 *
 */

public class programmers_조이스틱_ps {
    public static int solution(String name) {
        int steps = 0;
        int cursor = name.length()-1;
        for(int i = 0; i < name.length(); i++) {

            char current = name.charAt(i);
            if(current!='A'){
                steps += Math.min(current - 'A', 'Z' - current + 1);
            }
            int temp = i + 1;
            while(temp < name.length() && name.charAt(temp) =='A') {
                temp++;
            }

            cursor = Math.min(cursor, i + name.length() - temp +i);

        }
        steps += cursor;

        return steps;
    }
    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
    }
}
