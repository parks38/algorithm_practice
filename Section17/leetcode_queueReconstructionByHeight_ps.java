package Section17;
/*
  original : {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
  sort : 7,0 - 7,1 - 6,1 - 5,0 - 5,2 - 4,4
  1 - 7,0
  2 - 7,0 - 7,1
  3 - 7,0 -6,1 - 7,1
  4 - 5,0- 7,0 -6,1-7,1
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class leetcode_queueReconstructionByHeight_ps {
  public static int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[0] == o2[0]) return o1[1]-o2[1]; // 작은 수 먼저
        return o2[0]-o1[0]; // 큰수 먼저
      }
    });
    // 7,0 - 7,1 - 6,1 - 5,0 - 5,2 - 4,4


    List<int[]> result = new LinkedList<>();
    for (int i = 0; i < people.length; i++){
      result.add(people[i][1], people[i]);
    }
    return result.toArray(people);

  }
  public static void main(String[] args) {
    int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
    int[][] answ = reconstructQueue(people);
  }

}
