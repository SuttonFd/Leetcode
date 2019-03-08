package xin.suttonprog.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 15.3Sum,O(n^2)
 * @author codingZhengsz
 * @since 2019-03-06 09:35
 **/
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            // 去重，如果选的这个数跟之前已选的数相同，说明这个数的所有情况已经存在
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while(r > l) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[r]);
                    ans.add(nums[l]);
                    list.add(ans);
                    // 去重
                    while(l < r && nums[l] == nums[l+1])   l++;
                    while(l+1 < r && nums[r] == nums[r-1])  r--;
                }
                if(sum >= 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {-2,0,1,1,2};
        System.out.println(threeSum(nums));
    }

}
