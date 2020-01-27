package winter_vacation;

import java.util.Arrays;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main16
 * @Description:
 * 给定一个非空数组，返回此数组中第三大的数。
 * 如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * @author: 呆呆
 * @date: 2020/1/27
 */
public class Main16 {
    public int thirdMax(int[] nums) {
        long min = Long.MIN_VALUE;
        int one = nums[0];
        long two = min;
        long three = min;
        for (int i = 1; i <  nums.length; i++) {
            int now = nums[i];
            if (now == one || now == two || now == three) continue;
            if (now > one) {
                three = two;
                two = one;
                one = now;
            } else if (now > two) {
                three = two;
                two = now;
            } else if (now > three) {
                three = now;
            }
        }

        if (three == min) return one;  // 没有第三大的元素，就返回最大值
        return (int)three;
    }
}
