package winter_vacation;

import java.beans.IntrospectionException;
import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main17
 * @Description:
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * @author: 呆呆
 * @date: 2020/1/28
 */
public class Main17 {
    // 用哈希解决
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            if (map.containsKey(target-nums[i])){
                int[] ret = new int[2];
                ret[0] = i;
                ret[1] = map.get(target - nums[i]);
                return ret;
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException();
    }
}
