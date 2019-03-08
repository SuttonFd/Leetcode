package xin.suttonprog.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO...
 *
 * @author codingZhengsz
 * @since 2019-03-08 11:06
 **/
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-3;i++){
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j = i + 1;j<nums.length-2;j++){
                if(j != i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int l = j + 1,r = nums.length - 1;
                while(l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum > target) {
                        r--;
                    } else if(sum < target){
                        l++;
                    } else {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[l]);
                        ans.add(nums[r]);
                        list.add(ans);
                        l++;
                        r--;
                        while(l < r && nums[l] == nums[l-1]) l++;
                        while(l < r && nums[r] == nums[r+1]) r--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
        int target = -9;
        System.out.println(fourSum(nums,target));
    }

}
