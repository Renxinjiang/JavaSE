package winter_vacation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main9
 * @Description:
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * @author: 呆呆
 * @date: 2020/1/18
 */
public class Main9 {
    // 排序解决
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0;i < nums.length-1;i++){
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    // 用哈希
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i < nums.length;i++){
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
