package practice;
/*
    time complexity : O(N^2)
    Queue 이용한 방식
 */
import java.util.*;

public class programmers_주식가격 {

    public static int[] solution(int[] prices) {
        Queue<Integer> q = new LinkedList<>();
        int[] answer = new int[prices.length];
        int index = 0;
        for (int i = 0; i < prices.length; i++) {
            q.add(prices[i]);
        }
        while (!q.isEmpty()) {
            int target = q.remove();
            // nothing to peek ; last index
            if (index == prices.length - 1) {
                break;
            }
            for(int i = index+1; i < prices.length; i++) {
                answer[index]++;
                if (target > q.peek()) {
                    break;
                }
            }
            q.poll();
            index++;

        }
        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] priceList = solution(prices);
        for(int i = 0; i < priceList.length; i++){
            System.out.println(priceList[i]);
        }
    }

}
