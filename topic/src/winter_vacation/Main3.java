package winter_vacation;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main3
 * @Description:
 * 原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * @author: 呆呆
 * @date: 2020/1/13
 */
public class Main3 {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] != val){
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
