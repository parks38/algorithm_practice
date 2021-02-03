package Section10;
/*
    풀이 시간 : 초과
    시간 복잡도:  O(V+E)
    풀이 과정:
    begin에 대한 모든 한자리만 차이나는 단어들이 target이 될떄까지의 list를 생성하여
    begin -> target 까지의 가장 짧은 거리를 리턴해 준다.
                    hit
                    hot
             dot             lot
       dog        lot          .... 생략
   log    cog        log
   cog          dog      cog
                cog
  */

public class programmers_단어변환_ps {

    public static int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        int answer = words.length + 1;
        for (int i = 0; i < words.length; i++) {
            if (checkWord(begin, words[i]) == 1) {
                answer = Math.min(answer, dfs(words[i], target, i, words, visited, 1));
            }
        }
        if (answer == words.length + 1) {
            return 0;
        }
        return answer;
    }

    public static int dfs(String begin, String target, int index, String[] words, boolean[] visited, int cnt) {
        if (begin.equals(target)) {
            return cnt;
        }
        if (visited[index]) {
            return cnt;
        }
        visited[index] = true;
        int steps = 0;
        for (int i = 0; i < words.length; i++) {
            if (checkWord(begin, words[i])==1 && !visited[i]) {
                steps = dfs(words[i], target, i, words, visited, cnt + 1);
            }
        }
        return steps;
    }

    public static int checkWord(String str1, String str2) {
        int cnt = 0;
        for (int i = 0; i < str1.length() && cnt < 2; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution("hit", "cog", words));
    }


}
