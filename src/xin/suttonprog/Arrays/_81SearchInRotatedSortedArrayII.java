package xin.suttonprog.Arrays;

/**
 * 81. Search in Rotated Sorted Array II
 *
 * @author codingZhengsz
 * @since 2019-03-11 10:35
 **/
public class _81SearchInRotatedSortedArrayII {

    /**
     * 首先查找数组的中间值
     * 1. 如果中间这个数小于最右边的，说明右边子数组是有序的，而且最右边这个数是右边子数组最大的数
     *   将右边子数组的边值跟target比较。
     *   如果中间这个数小于target并且最右的数大于target，说明这个target在右半区
     *   否则在左半区。
     * 2. 如果中间这个数大于最右边的，说明左边子数组是有序的，而且中间这个数是右边子数组最大的数
     *   将左边子数组的边值跟target比较
     *   如果中间这个数大于target并且最左边的数小于target，说明这个target在左半区
     *   否则在右半区。
     * 3. 由于存在可重复的数，比如
     *    [3,1,1]，target=3 的中间数为1，右边数为1，目标值在左半区
     *    [0,0,5,0],target=5 的中间数为0，右边数为0，目标值在右半区
     *    两者相等时，而目标值可能在左半区也可能在右半区。
     *    可以在两者相等的时候，将right，即最右的数向左移动一位，然后继续循环
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return true;
            } else if(nums[mid] < nums[right]) {
                if(nums[mid] < target && nums[right] >= target) {
                    left = mid +1;
                }else {
                    right = mid - 1;
                }
            } else if(nums[mid] > nums[right]){
                if(nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                right --;
            }
        }
        return false;
    }

}
