package xin.suttonprog.Arrays;

/**
 * TODO...
 *
 * @author codingZhengsz
 * @since 2019-03-09 10:52
 **/
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int count = 0;
        for(int i = 0;i<nums.length - 1;i++){
            if(nums[i] != nums[i+1]) {
                nums[count++] = nums[i];
            }
        }
        nums[count++] = nums[nums.length - 1];
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);
        for(int i=0;i<len;i++){
            System.out.println(nums[i]);
        }
    }


}
