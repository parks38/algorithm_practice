package Section12;
import java.util.*;
/*
 *  풀이 시간 : 15분
 *  시간복잡도 : O(N)
 *  풀이 과정 :
 *      HashSet<String> 이용하여 중복이 없는 단어 리스트 생성
 *      - 만약 단어가 set에 들어가지않는다면 이미 존재하는 단어 의미
 *      char start / end - 앞단어 끝단어 확인
 *      person % n = 해당 단어가 몇번째 사람의 단어인지 확인
 *      int[] cnt = 몇번때 사람의 몇번째 단어인지 확인
 *
 */

public class programmers_영어끝말잇기_ps {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        int[] cnt = new int[n];
        int person = 0;
        HashSet<String> wordSet = new HashSet<>();

        // 첫번째 단어 미리 넣어주기 end 지정해주기 위해서
        char end = words[0].charAt(words[0].length() - 1);
        char start;
        wordSet.add(words[0]);
        cnt[0]++;

        for (int i = 1; i < words.length; i++) {
            // 몇번째 사람 지정
            person = i % n;
            // 헤당 사람의 몇번째 단어인지 지정
            cnt[person]++;
            wordSet.add(words[i]); // Set 이기 때문에 중복은 없음
            start = words[i].charAt(0);
            if (end != start || wordSet.size() != i + 1) {
                answer[0] = person + 1;
                answer[1] = cnt[person];
                break;
            }
            end = words[i].charAt(words[i].length() - 1);
        }

        return answer;
    }

}
