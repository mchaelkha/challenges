package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three3Sum {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> solutions = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                            boolean isUnique = true;
                            for (List<Integer> s : solutions) {
                                if (s.containsAll(list)) {
                                    isUnique = false;
                                }
                            }
                            if (!isUnique)
                                break;
                            solutions.add(list);
                        }
                    }
                }
            }
            return solutions;
        }
    }
}
