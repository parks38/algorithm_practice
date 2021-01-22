package Section09;

import java.util.*;
/*
 * 풀이 시간: 7분  
 * 시간 복잡도 : O(N^2)
 * 풀이 방법 : Nested For Loop 
 *     i       0    1   2   3   4   5   6   7
 * 	int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
 *      j           1   2   3   4   5   6   7
 *  int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
 *  
 *  Note: The length of temperatures will be in the range [1, 30000]. 
 *  Each temperature will be an integer in the range [30, 100].
 *  
 *   < Stack 이용 방법 >
 *   : Stack이용하면 FIFO (가장 최근것 접근 가능)
 *   
 *   maxVal : 76
 *   T[i] = 72 
 *    
 *    - 가장 다음으로 높은 온도를 구할시 
 *   maxVal > T[i] == answer[i] = maxVal.peek() - i;
 *   
 *   - maxVal 보다 현재 온도가 높다면 
 *   maxVal 안에 있는 value pop해서 탐색 
 *   maxVal.push(i);
 *   
 *   maxVal empty 일때까지 안에 현재 보다 높은 온도가 없다면, 뒤에서 부터 탐색했기때문에
 *   앞으로 없다는 얘기임으로 
 *   
 *   answer[i] = 0;
 *   
 *  
 */



public class leetcode_daily_temperatures_ps {
	public static void main(String args[]) {
		
		int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
		int[] output = dailyTemperatures(T);
		
		System.out.println(Arrays.toString(output));
		
	}
	public static int[] dailyTemperatures(int[] T) {
	    int size = T.length;
	    int[] answer = new int[size];
	        for(int i = 0; i < size; i++) {
	            for(int j = i+1; j < size; j++) {
	                if(T[i] < T[j] ) {
	                    answer[i] = j - i; 
	                    break;
	                }
	                    
	            }
	        }
	    return answer;
	}
	
	/*
	 *  시간 복잡도 : O(N)        
        Stack<Integer> maxVal = new Stack();
        answer[size-1] = 0;
        for(int i =T.length -1; i >= 0; i--) {
            while (!maxVal.isEmpty() && T[i] >= T[maxVal.peek()]) {
                maxVal.pop();
            }
            
            
            if(maxVal.isEmpty()) answer[i] = 0;
            else answer[i] = maxVal.peek() - i;
            
            maxVal.push(i);
        }
        return answer;
	 */
}
