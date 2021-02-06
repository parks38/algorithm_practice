package Section11;
import java.util.*;
/*
 *  풀이 시간 : 50분
 *  시간복잡도 : O(N^2)
 *  풀이 과정 : DFS
 *  여행지 출발(ICN) -> 도착지의 경우의 수를 구한다.
 *  visited[] 로 방문한 곳을 트랭킹 하여 가능한 루트 구하기
 *  [routes]
     * route = ICN,SFO,ATL,ICN,ATL,SFO,
     * route = ICN,ATL,ICN,SFO,ATL,SFO,
     * route = ICN,ATL,SFO,ATL,ICN,SFO,
 *  Collection.sort 를 이용하여 순서가 가장빠른것을 찾아 출력한다.
 */
public class programmers_여행경로_ps {
    public static String route;
    public static List<String> routes = new ArrayList<>();

    public static String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                visited[i] = true;
                route = tickets[i][0] +"," ;
                dfs(tickets, tickets[i][1], visited, 1);
                visited[i] = false;
            }
        }
        Collections.sort(routes);
        String[] answer = routes.get(0).split(",");
        //System.out.println(Arrays.toString(answer) + " answer");
        return answer;
    }

    public static void dfs(String[][] tickets, String destination, boolean[] visited, int count) {
        route += destination +",";
        if (count == tickets.length) {
            routes.add(route);
            //System.out.println(route);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (destination.equals(tickets[i][0]) && visited[i] == false) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], visited, count + 1);
                visited[i] = false;
                route = route.substring(0, route.length()-4); //backtrack

            }
        }

    }

    public static void main(String args[]){
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        solution(tickets);
    }
}
