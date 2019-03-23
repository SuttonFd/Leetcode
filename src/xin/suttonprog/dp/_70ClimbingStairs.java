package xin.suttonprog.dp;

/**
 * @author codingZhengsz
 * @since 2019-03-23 22:10
 **/
public class _70ClimbingStairs {

    /**
     * 使用递归的方式，每次有两个选择，两个选择之后是新的两次选择
     * 超出时间限制，无法使用
     */
    public int climbStairs_Recursive(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return climbStairs_Recursive(n-1) + climbStairs_Recursive(n-2);
    }

    /**
     * 使用动态规划的方法
     * Runtime: 2 ms, faster than 87.84%
     * Memory Usage: 36.4 MB, less than 14.76%
     */
    public int climbStairs_dp1(int n){
        int[] ans = new int[n+1];
        ans[0] = 1;
        ans[1] = 1;
        for(int i=2;i<=n;i++){
            ans[i] = ans[i-1] + ans[i-2];
        }
        return ans[n];
    }

    /**
     * 动态规划方法的节省空间算法
     * Runtime: 2 ms, faster than 87.84%
     * Memory Usage: 36.3 MB, less than 44.56%
     */
    public int climbStairs_dp2(int n){
        int[] ans = new int[3];
        ans[0] = 1;
        ans[1] = 1;
        for(int i=2;i<=n;i++){
            ans[i%3] = ans[(i-1)%3] + ans[(i-2)%3];
        }
        return ans[n%3];
    }

    /**
     * 动态规划方法的节省空间算法的新解法
     * Runtime: 2 ms, faster than 87.84%
     * Memory Usage: 36.4 MB, less than 32.13%
     */
    public int climbStairs_dp3(int n) {
        if(n < 4) return n;
        int a,b = 3,c = 5;
        for(int i= 5;i <= n; i++) {
            a = c;
            c = b + c;
            b = a;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new _70ClimbingStairs().climbStairs_dp3(3));
    }

}
