package xin.suttonprog.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author codingZhengsz
 * @since 2019-03-16 19:17
 **/
public class _39CombinationSum {

    /**
     * 使用DFS的方法，进行深度优先收缩
     *
     * 2  2  2  2
     * 3  3  3  3
     * 6  6  6  6
     * 7  7  7  7
     *
     * Runtime: 7 ms, faster than 96.04%
     * Memory Usage: 39.2 MB, less than 63.03%
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfsHelper(candidates,0,0,target,result,temp);
        return result;
    }

    public void dfsHelper(int[] candidates,int start,int sum,int target,List<List<Integer>> result,List<Integer> temp) {
        // 剪枝
        if(sum > target) {
            return;
        }
        // 保存后剪枝
        if(sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            temp.add(candidates[i]);
            dfsHelper(candidates,i,sum+candidates[i],target,result,temp);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(new _39CombinationSum().combinationSum(candidates, target).toString());
    }
}
