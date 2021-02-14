package Section12;
/*
 *  풀이 시간 : 40분
 *  시간복잡도 : O(N)
 *  풀이 과정 :
 *      s = 110010101001
 *      -> s.replace("0", "")
 *      1 => 6개 110
 *      s = 110
 *      0을 모두 없앤 이후에 해당 1의 개수를 toBinaryString을 이용하여 변환
 */

public class programmers_이진변환반복하기_ps{

        public int[] solution(String s) {
            int[] answer = new int[2];
            int cnt = 0;
            int zero = 0;
            while (!s.equals("1")) {
                cnt++;
                int one = 0;
                /* for(int i = 0; i < s.length(); i++){
                     if(s.charAt(i) == 0){
                         zero++;
                     } else {
                         one++;
                     }
                   } */
                String result = s.replaceAll("0", "");
                zero += s.length() - result.length();
                s = Integer.toBinaryString(result.length());

            }
            answer[0] = cnt;
            answer[1] = zero;
            return answer;
        }
}
