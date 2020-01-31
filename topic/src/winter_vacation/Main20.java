package winter_vacation;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main20
 * @Description:
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * @author: 呆呆
 * @date: 2020/1/31
 */
public class Main20 {
    public int[] searchRange(int[] nums, int target) {
        int[] rev = {-1,-1};
        int start = 0;
        int end = nums.length;
        int mid = 0;
        int p = -1;
        while (start < end){
            mid = (start+end)/2;
            if (target < nums[mid]){
                if (mid == end) break;
                end = mid;
            }else if (target > nums[mid]){
                if (mid == start) break;
                start = mid;
            }else if (target == nums[mid]){
                p = mid;
                break;
            }
        }
        if (p == -1){
            return rev;
        }else {
            int prev = mid;
            int next = mid;
            while (prev>0 &&nums[prev - 1] == target){
                prev--;
            }
            while (next < nums.length-1 && nums[next+1] == target){
                next++;
            }
            rev[0] = prev;
            rev[1] = next;
            return rev;
        }
    }
}
