package Section09;
/*
 * 풀이 시간 : 30분 
 * 시간복잡도 : O(N)
 * 
 * 풀이 방식: 
 * 	   brown + yellow 의 합의 배수를 구해 아래 조건 확인하기 
 * 	   brown = (가로 - 2) * (세로 - 2)
 * 	   yellow = (가로 * 2) + (세로 - 2) * 2)
 *    
 */

public class programmers_카펫_ps {
	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        
        for(int i = total; i >= 3; i--) {
            if (total % i == 0) {
                if(i >= total/i) {
                    int row = i;
                    int col = total/i;
            
                    if(yellow == (row-2) * (col-2)&& brown == (row*2) + (col-2)*2) {
                        answer[0] = row;
                        answer[1] = col;
                        break;
                    }
                }
            }
            
        }
        
        return answer;
    }
	
	public static void main(String args[]) {
	      int[] ans = solution(8, 1);
	      System.out.println(ans[0] + "," + ans[1]);
	}
}
