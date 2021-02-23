package Section13;
import java.util.*;
/**
 *  풀이 시간 : 초과
 *  시간복잡도 : O(N)
 *  풀이 과정 :
 *  {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
 *  - 문자열 처리
 *      : {} 모두 없애주고 숫자 사이는 , 로 구분 튜플은 / 로 구분
 *  - 튜플 길이가 짧은 순서대로 배열
 *  - result : 순수 숫자 저장하는 리스트
 *       result 에 값이 없다면 다음 순서의 숫자이다. 이전에 나온 숫자들은 이미 result 에 들어가있다.
 *       2  - result : null
 *       : result.add(2)
 *       2, 1  - result : 2
 *       :result.add(1)
 *       2, 1, 3  - result : 2, 1
 *       :result.add(3)
 *       2, 1, 3, 4  - result : 2, 3
 *       : result.add(4)
 */

public class programmers_튜플_ps {
    public static int[] solution(String s){
        int[] answer  = {};

        s = s.substring(2, s.length()-2).replace("},{", "/");
        String[] strs = s.split("/");
        //[2,1,3,4 - 2,1,3 - 2,1 - 2]

        // order : 짧은 순서가 더 앞에 오도록
        //[2  2,1  2,1,3  2,1,3,4]
        Arrays.sort(strs, (a,b)->(a.length()-b.length()));

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            String[] temp = strs[i].split(",");
            for(int j = 0; j < temp.length; j++){

                if(!result.contains(Integer.parseInt(temp[j]))) {
                    //System.out.println(Integer.parseInt(temp[j]));
                    result.add(Integer.parseInt(temp[j]));
                }
            }

        }
        //Java 8: ArrayList<Integer> -> int[]
        answer = result.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String[] args) {
        //String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s = "{{20,111},{111}}";
        solution(s);
    }
}

/* * 문제 :
 *   order
 *   [2, 21, 213, 2134] 한자리씩 값을 찾게되면 :
 *   	"{{20,111},{111}}" 세자리숫자일 경우 한개씩 뽑아내게 되면 오류
 *       String[] temp = strs[i].split(",");
 *        - 20 111
 */
