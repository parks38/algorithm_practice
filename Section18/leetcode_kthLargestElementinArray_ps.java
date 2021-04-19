package Section18;
/**
 * 풀이 시간 : 10분
 * 시간복잡도 : O(N)
 * 풀이 과정 :
 *  Integer 배열 정렬 이용해서 내림차순 나열 후 kth element 리턴값.
 *  Collections / Comparator .reverseOrder() 함께 이용 가능
 */

import java.util.Arrays;
import java.util.Collections;

public class leetcode_kthLargestElementinArray_ps {

  public static int solution(int[] nums, int k) {
    Integer[] arrNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    Arrays.sort(arrNums, Collections.reverseOrder());
    return arrNums[k-1];
  }

  public static void main(String[] args) {
    int[] nums = {3,2,1,5,6,4};
    int k = 2;
    System.out.println(solution(nums, k));
  }

}
