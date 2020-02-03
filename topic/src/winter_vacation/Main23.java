package winter_vacation;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main23
 * @Description:
 * 给定一个整数数组，你需要寻找一个连续的子数组，
 * 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 * @author: 呆呆
 * @date: 2020/2/3
 */
public class Main23 {
    public int findUnsortedSubarray1(int[] nums) {
        int[] s = nums.clone();
        Arrays.sort(s);
        int start = s.length;
        int end = 0;
        for (int i = 0;i < s.length;i++){
            if (s[i] != nums[i]){
                start = Math.min(start,i);
                end = Math.max(end,i);
            }
        }
        if (end - start < 0){
            return 0;
        }
        return (end - start)+1;
    }

    public int findUnsortedSubarray(int[] nums) {
        int max = nums[0];
        int min = nums[nums.length-1];
        int r = -1;
        int l = 0;
        for (int i = 0;i < nums.length;i++){
            if (max > nums[i]){
                r = i;
            }else {
                max = nums[i];
            }
            if (min < nums[nums.length-i-1]){
                l = nums.length-i-1;
            }else {
                min = nums[nums.length-i-1];
            }
        }
        return r-l+1;
    }
}
