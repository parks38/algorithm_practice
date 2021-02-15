package code_up_100제;
import java.util.*;
/*
    격자판의 세로(h), 가로(w), 막대의 개수(n), 각 막대의 길이(l),
    막대를 놓는 방향(d:가로는 0, 세로는 1)과
    막대를 놓는 막대의 가장 왼쪽 또는 위쪽의 위치(x, y)가 주어질 때,

    격자판을 채운 막대의 모양을 출력하는 프로그램을 만들어보자.
    [출력 예시]
    1 1 0 0 0
    0 0 1 0 1
    0 0 1 0 1
    0 0 1 0 1
    0 0 0 0 1
 */

public class 설탕과자뽑기 {
    private static int[][] answer;
    private static int h;
    private static int w;

    public static void main(String args[]) {
        h = 5;
        w = 5;

        answer = new int[h][w];
        // 길이, 방향(0 가로 1 세로), x, y
        solution(2, 0, 1, 1);
        solution(3, 1, 3, 2);
        solution(4, 1, 5, 2);

        System.out.println(Arrays.toString(answer));


    }

    public static void solution(int l, int d, int x, int y) {
        if (d == 0) { //가로
            for (int i = x-1; i < (x + l)-1; i++) {
                answer[y-1][i] = 1;
            }
        } else { //세로
            for (int j = y-1; j < (y + l)-1; j++) {
                answer[j][x-1] = 1;
            }

        }
    }
}
