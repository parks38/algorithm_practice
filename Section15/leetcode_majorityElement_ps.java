package Section15;
/**
 * 풀이시간 : 15분
 * 시간 복잡도 : O(N)
 * 공간 복잡도 : O(N)
 * 풀이 과정 :
 *    나오는 값을 key로 count 와 함께 매핑하여 n/2 보다 큰 수의 값을 찾는다.
 *    HashMap<nums[i]의 val, count>
 */

import java.util.HashMap;
import java.util.Iterator;

public class leetcode_majorityElement_ps {

  public static int majorityElement(int[] nums) {
    HashMap<Integer, Integer> counts = new HashMap<>();
    int result = 0;
    for(int i = 0; i < nums.length; i ++) {
      if(counts.containsKey(nums[i])) {
        counts.put(nums[i], counts.get(nums[i]) + 1);
      } else {
        counts.put(nums[i], 1);
      }
    }
    Iterator<Integer> keys = counts.keySet().iterator();
    for(Integer key : counts.keySet()) {
      if(counts.get(key) > nums.length/2) {
        result = key;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {3,3,4};
    System.out.println(majorityElement(nums));
  }
  /**
   *  이외의 solution :
   *  Arrays.sort(nums);
   *  return nums[nums.length/2];
   *  233
   *  1112222
   */
}
