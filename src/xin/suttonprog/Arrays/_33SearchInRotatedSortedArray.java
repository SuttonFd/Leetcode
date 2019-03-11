package xin.suttonprog.Arrays;

/**
 * 33. Search in Rotated Sorted Array
 *
 * @author codingZhengsz
 * @since 2019-03-11 09:44
 **/
public class _33SearchInRotatedSortedArray {

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
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < nums[right]) {  // 右边有序
                if(nums[mid] < target && nums[right] >= target) {
                    left = mid +1;
                }else {
                    right = mid - 1;
                }
            } else {  // 左边有序
                if(nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
