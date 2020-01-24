package winter_vacation;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main14
 * @Description:
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 *
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。
 * 如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * @author: 呆呆
 * @date: 2020/1/24
 */
public class Main14 {
    public int pivotIndex(int[] nums) {
        int ans = -1;
        int leftsum = 0;
        int rightsum = 0;
        for (int i = 0; i < nums.length; i++) rightsum += nums[i];
        for (int i = 0; i < nums.length; i++) {
            rightsum -= nums[i];
            if (leftsum == rightsum) {
                ans = i;
                break;
            } else {
                leftsum += nums[i];
            }
        }
        return ans;
    }
}
