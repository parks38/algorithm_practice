package Section17;
/*
  풀이방법 :
   - HashpMap Set 으로 나오는 숫자의 unique number 와 나오는 frequency tracking
   - Collection 을 통해 정렬
        o2.getValue() - 01.getValue() 으로 내림차순 정렬

 */

import java.util.*;
import java.util.Map.Entry;

public class leetcode_topKFrequentElements_ps {
  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> count = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
      int curr = nums[i];
      if(count.containsKey(curr)) {
        int currVal = count.get(curr);
        count.put(curr, currVal + 1);
      } else {
        count.put(curr, 1);
      }
    }

    int[] answer = new int[k];

    List<Entry<Integer, Integer>> list =
        new ArrayList<Entry<Integer, Integer>>( count.entrySet());

    Collections.sort( list, new Comparator<Entry<Integer, Integer>>() {
      public int compare(Map.Entry<Integer, Integer>  o1,
          Map.Entry<Integer, Integer> o2) {
        if(o1.getValue() == o2.getValue()) return o2.getKey() - o1.getKey();
        else return o2.getValue() - o1.getValue();
      }
    });

    for(int i = 0; i < k; i++) {
      answer[i] = list.get(i).getKey();
    }

    return answer;

  }

  public static void main(String[] args) {
    int[] nums = {1,1,1,2,2,3};
    int k = 2;
    topKFrequent(nums, k);
  }

}
