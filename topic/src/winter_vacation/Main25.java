package winter_vacation;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main25
 * @Description:
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * @author: 呆呆
 * @date: 2020/2/5
 */
public class Main25 {
    // 1.循环
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());
        for (int n : nums){
            int size = list.size();
            for (int i = 0;i < size;i++){
                List<Integer> sub = new ArrayList<>(list.get(i));
                sub.add(n);
                list.add(sub);
            }
        }
        return list;
    }
}
