package xin.suttonprog.Arrays;

import java.util.Arrays;

/**
 * TODO...
 *
 * @author codingZhengsz
 * @since 2019-03-07 10:55
 **/
public class ThreeSumClosest {


    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(closest - target);
        for(int i=0;i<nums.length;i++){
            int l = i + 1,r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int diffNew = Math.abs(sum - target);
                if(diffNew < diff) {
                    closest = sum;
                    diff = diffNew;
                }
                if(sum == target) {
                    return closest;
                }else if(sum > target) {
                    r--;
                } else {
                    l ++;
                }
            }
        }
        return closest;
    }


    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
//        int[] nums = {1,1,-1,-1,3};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }

}
