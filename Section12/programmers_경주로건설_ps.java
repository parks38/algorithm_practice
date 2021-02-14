package Section12;
import java.util.*;
/*
 *  풀이 시간 : 시간 초과
 *  시간복잡도 : O(|V|^2) ; 인접 행렬
 *  풀이 과정 : BFS
 *      - 최소비용 경로 탐색
 *      - 경로를 바꾸거나 꺽으면 + 600원 / 직진 + 100원
 *      - 새롭게 방문 했을때 지금까지의 비용이 더 저렴하다면 갱신
 *      - (n-1)(n-1) 지점까지 값 탐색
 */


public class programmers_경주로건설_ps {
    private static int size;
    private static int answer = Integer.MAX_VALUE;

    public static int solution(int[][] board){
        size = board.length;
        // 첫 노드 ( x좌표, y 좌표, 방향, 가격)
        bfs(0,0,-1,0, board);
        return answer;
    }

    public static void bfs(int x, int y, int dir, int price, int[][] board){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,dir, price));

        while(!q.isEmpty()) {
            Node curr = q.remove();
            int currX = curr.x;
            int currY = curr.y;
            int currDir = curr.dir;
            int currPrice = curr.price;

            int[] dirx = {-1, 1 ,0, 0}; // 상히좌우
            int[] diry = {0, 0, 1, -1}; // 상하좌우

            // 종료 지점 : (n-1)(n-1) 도착
            if(currX == size-1 && currY == size -1){
                answer = Math.min(answer, currPrice);
            }

            // 4 방향 탐색
            for(int i = 0; i < 4; i++) {
               int newX = currX + dirx[i];
               int newY = currY + diry[i];
               int newDir = i ;
               int newPrice = currPrice;

               // 범위를 벗어날 경우 -> 벽이 아닐 경우
               if(newX < 0 || newY < 0 || newX >= size || newY >= size) continue;

               // 방향에 따른 값 update
               if(currDir == -1){
                   newPrice += 100; // 처음 직진
               } else if ((currDir == newDir)) {
                   newPrice += 100; // 같은 방향
               } else {
                   newPrice += 600; // 방향 꺽기
               }
               // 처음 방문하거나 값이 더 작은 경우 update
               if(board[newX][newY] == 0 || board[newX][newY] >= newPrice) {
                    board[newX][newY] = newPrice;
                    q.add(new Node(newX, newY, i, newPrice));
                    //System.out.println(newX + ", " + newY + ", " + newDir + ", " + newPrice);
               }

            }

        }
    }

    public static void main(String[] args){
        int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0}
                        ,{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
        System.out.println(solution(board));
    }
}
class Node {
    int x,y,dir,price;

    Node(int x, int y, int dir, int price){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.price = price;
    }
}
