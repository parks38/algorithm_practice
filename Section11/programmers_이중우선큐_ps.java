package Section11;
/*
 *  풀이 시간 : 45분
 *  시간복잡도 : O(n * log(n))
 *  풀이 과정 :
 *  priorityQueue 두 개 이용 하여 min/ max update
 */
import java.util.Comparator;
import java.util.PriorityQueue;

public class programmers_이중우선큐_ps {

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder()); //max priority
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(); //min priority

        for(int i = 0 ; i < operations.length; i++){
            if(operations[i].startsWith("I")){
                maxQueue.add(Integer.parseInt(operations[i].substring(2)));
                minQueue.add(Integer.parseInt(operations[i].substring(2)));
            }else if (!maxQueue.isEmpty() && operations[i].startsWith("D 1")) {
                    int max = maxQueue.remove();
                    minQueue.remove(max);
            } else if(!maxQueue.isEmpty() && operations[i].startsWith("D -1")){
                    int min = minQueue.remove();
                    maxQueue.remove(min);
            }
        }
        if(!minQueue.isEmpty()){
            answer[0] = maxQueue.peek();
            answer[1] = minQueue.peek();
        }


        return answer;
    }

    public static void main(String args[]){
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] ans = solution(operations);
        System.out.print(ans[0]);
        System.out.print(ans[1]);
    }
}
