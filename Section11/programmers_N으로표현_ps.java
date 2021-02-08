package Section11;
/*
 *  풀이 시간 : 초과
 *  시간복잡도 : O(V+E)
 *  풀이 과정 : Dynamic Programming
 *  5   5
 *  55  5+5 5-5 5/5 5*5
 *  555 55+5 55-5 55/5 55*5 (5+5)+5 (5-5)+5 (5*5)+5 (5/5)+5 ...
 *  ....
 *  555555555
 */

public class programmers_N으로표현_ps {
    private static int answer;

    public static int solution(int N, int number) {
        dfs(N, 0, 0, number);
        return answer;
    }

    public static void dfs(int n, int index, int num, int number) {
        // 8 - 1~9 까지 본인을 뺀수 만큼
        if (index > 9)
            return;
        if (num == number) {
            if (index < answer || answer == -1) { // 원하는 답이 나왔을 경우
                answer = index;
            }
            return;
        }
        int nn=0;
        for (int i = 0; i < 9; i++) {
            nn=nn*10+n;
            dfs(n, index + 1+i, num + nn, number); // +
            dfs(n, index + 1+i, num - nn, number); // -
            dfs(n, index + 1+i, num * nn, number); // *
            dfs(n, index + 1+i, num / nn, number); // /
        }
    }

    public static void main(String args[]){
        System.out.println(solution(5, 12));
    }
}
