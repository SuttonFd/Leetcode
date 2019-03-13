package xin.suttonprog.Arrays;

/**
 * TODO...
 *
 * @author codingZhengsz
 * @since 2019-03-13 11:00
 **/
public class _167TwoSumII_InputArrayIsSorted {

    /**
     * 二分法搜索
     * 时间复杂度：O(nlogn)
     * Runtime:80ms faster than 10.33%
     * Memory Usage:36.1 MB,less than 69.90%
     */
    public static int[] twoSum_Solution1(int[] numbers, int target) {
        int[] ans = {0,0};
        for(int i=0;i<numbers.length;i++){
            int l = i,r = numbers.length - 1;
            while(l < r) {
                if(numbers[l] + numbers[r] == target){
                    ans[0] = l + 1;
                    ans[1] = r + 1;
                    return ans;
                }else{
                    r--;
                }
            }
        }
        return ans;
    }

    /**
     * 两个指针，一个指向开头，一个指向尾部，然后向中间遍历
     * 如果指向的两个数的和为target，返回两个指针
     * 如果指向的两个数的和小于target，指向开头的指针右移一位
     * 如果指向的两个数的和大于target，指向尾部的指针左移一位
     * 时间复杂度：O(n)
     * Runtime：0ms,faster than 100.00%
     * Memory Usage:35.7MB,less than 92.19%
     */
    public static int[] twoSum_Solution2(int[] numbers, int target) {
        int[] ans = {0,0};
        int l = 0,r = numbers.length - 1;
        while( l < r ) {
            int sum = numbers[l] + numbers[r];
            if(sum == target){
                ans[0] = l + 1;
                ans[1] = r + 1;
                return ans;
            } else if(sum < target){
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 18;
        int[] ans = twoSum_Solution2(nums,target);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
