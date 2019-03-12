package xin.suttonprog.Arrays;

/**
 * 35. Search Insert Position
 *
 * @author codingZhengsz
 * @since 2019-03-12 17:22
 **/
public class _35SearchInsertPosition {

    /**
     * Faster 100.00
     * Less than 5.03
     */
    public static int searchInsert(int[] nums, int target) {
        if(target == 0) {
            return 0;
        } else {
            for(int i=0;i<nums.length;i++){
                if(nums[i] == target || nums[i] > target) {
                    return i;
                }
            }
        }
        return nums.length;
    }

    /**
     * BinarySearch
     */
    public static int binarySearchInsert(int[] nums, int target) {
        int l = 0,r = nums.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l] >= target ? l : l + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 4;
        System.out.println(searchInsert(nums,target));
    }

}
