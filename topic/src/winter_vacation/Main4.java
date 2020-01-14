package winter_vacation;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main4
 * @Description:
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 * @author: 呆呆
 * @date: 2020/1/14
 */
public class Main4 {
    // 方法一：遍历
    public int searchInsert1(int[] nums, int target) {
        for (int i = 0;i < nums.length;i++){
            if (target == nums[i]) {
                return i;
            }
            if (target < nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
    // 方法二：二分查找
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        //为什么<=而不是<，试试{1}，1
        while (left <= right)
        {
            //mid = (left + right)/2, 这种写法在left+right的时候可能内存溢出
            mid = left + (right - left);
            if (nums[mid] == target)
            {
                return mid;
            }
            else if (nums[mid] < target)
            {
                //为什么mid+1，mid-1，而不是mid
                //试试{1}，2，会死循环
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        if (mid > 0 && nums[mid] > target)
        {
            mid = mid - 1;
        }
        else if(nums[mid] < target)
        {
            mid = mid + 1;
        }
        return mid;
    }
}
