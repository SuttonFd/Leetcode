package xin.suttonprog.Arrays;

/**
 * @author codingZhengsz
 * @since 2019-03-14 11:05
 **/
public class _53MaximumSubarray {

    /**
     * 使用动态规划的方式解决这道题
     * Runtime: 5 ms, faster than 100.00%
     * Memory Usage: 39.5 MB, less than 66.41%
     * O(n)
     */
    public static int maxSubArray1(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return 0;
        }
        int[] tmp = new int[nums.length];
        tmp[0] = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            if(tmp[i-1] <= 0) {
                tmp[i] = nums[i];
            }else{
                tmp[i] = tmp[i-1] + nums[i];
            }
            if(tmp[i] > max) {
                max = tmp[i];
            }
        }
        return max;
    }

    /**
     * another solution using the divide and conquer approach
     * 分治法
     * 一个子串的最大和是其左子串最大和，右子串最大和和包含中间数的最大和三者的最大和
     * 分了之后进行合并，计算包含中间那个数的最大和
     * Runtime: 7 ms, faster than 52.76%
     * Memory Usage: 39.1 MB, less than 85.65%
     * O(nlogn)
     */
    public int maxSubArray2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        return divide(nums,0,nums.length-1);
    }

    public int divide(int[] nums,int start,int end) {
        if(start >= end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        int leftMax = divide(nums,start,mid-1);
        int rightMax = divide(nums,mid+1,end);
        int midL = nums[mid];
        for(int i=mid-1,sum=nums[mid];i>=start;i--){
            sum+=nums[i];
            midL=midL>sum?midL:sum;
        }
        int midR = midL;
        for(int i=mid+1,sum=midR;i<=end;i++){
            sum += nums[i];
            midR=midR>sum?midR:sum;
        }
        return Math.max(leftMax,Math.max(rightMax,midR));
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new _53MaximumSubarray().maxSubArray2(nums));
    }

}
