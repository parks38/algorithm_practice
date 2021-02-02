package Section10;
import java.util.*;
/*
 *  풀이 시간 : 15분
 *  시간복잡도 : O(N^2)
 *  phone_book을 순서대로 sorting 한 이후 비교
 *  - sorting 을 하게되면 접수사를 가진 번호가 최대한 가까이 배치될수도 있음
 */

public class programmers_전화번호_목록_ps {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i]) ||
                        phone_book[i].startsWith(phone_book[j])) {
                    return false;
                }
            }
        }
        return answer;
    }

}
