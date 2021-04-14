package Section17;
/*
  다음 큰 수를 찾을 때
  for(int i = n+1; i <= 1000000; i++) {
  을 이용하여 차례대로 n 보다 1 큰수부터 탐색하며
  조건 1 과 조건 3 을 모두 함께 만족하는 수를 찾을 수 있으며
  if(nextValCount == countCurr)
  을 통해 2 진수로 변환 했을때 같은 1의 개수를 찾아 조건 2를 만족하는 수를 찾는다.
 */

public class programmers_다음큰숫자_ps {
  public static int solution(int n) {
    String currentBin = Integer.toBinaryString(n);
    int countCurr = count(currentBin);
    // 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 & 조건 3
    for(int i = n+1; i <= 1000000; i++) {
      String nextVal = Integer.toBinaryString(i);
      int nextValCount = count(nextVal);
      //조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같음.
      if(nextValCount == countCurr) return i;
    }
    return -1;
  }

  public static int count(String binaryCode) {
    int count = 0;
    for(int i = 0; i < binaryCode.length(); i++) {
      char curr = binaryCode.charAt(i);
      if(curr == '1') count++;
    }
    return count;
  }
  public static void main(String[] args) {
    System.out.println(solution(78));

  }
}
