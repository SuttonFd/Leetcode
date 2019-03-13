package xin.suttonprog.Arrays;

/**
 * TODO...
 *
 * @author codingZhengsz
 * @since 2019-03-13 10:29
 **/
public class _34FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 防止溢出求平均数
     * 1、将相同的位进行相加，结果等于两数按位与的结果的两倍；
     * 2、将不同的位进行相加，其结果等于按位异或的结果。
     */
    static int mean(int a,int b) {
        return (a & b) + ((a ^ b) >> 1);
    }

    /**
     * 将数组分为两个半区做两遍二分搜索
     * 第一遍找到左边界，如果nums[mid]小于target说明左边界在右半区，否则左边界会在左半区
     * 第二遍找到有边界，如果nums[mid]大于target说明右边界在左半区，否则右边界会在右半区
     * 时间复杂度O(log n),空间复杂度为O(1)
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        if(nums == null) {
            return ans;
        }
        int ll = 0,lr =nums.length - 1;
        while(ll <= lr) {
            int mid = mean(ll , lr);
            if(nums[mid] < target) {
                ll = mid + 1;
            } else {
                lr = mid - 1;
            }
        }
        int rl = 0,rr = nums.length - 1;
        while(rl <= rr){
            int mid = mean(rl,rr);
            if(nums[mid] > target) {
                rr = mid - 1;
            } else {
                rl = mid + 1;
            }
        }
        if(ll > rr) {
            return ans;
        }
        ans[0] = ll;
        ans[1] = rr;
        return ans;
    }

}
