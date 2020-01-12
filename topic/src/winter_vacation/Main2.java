package winter_vacation;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main2
 * @Description:
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 * 三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * @author: 呆呆
 * @date: 2020/1/12
 */
public class Main2 {
    // 方法一：一次右移一位，循环k次
    public void rotate1(int[] nums, int k) {
        for (int j = 0;j < k;j++) {
            int last = nums[nums.length-1];
            for (int i = nums.length-2; i >= 0; i--) {
                nums[i+1] = nums[i];
            }
            nums[0] = last;
        }
    }
    // 方法二：一次交换到位
    public void rotate2(int[] nums, int k) {
        k = k%nums.length;
        int count = 0;
        for (int i = 0;count < nums.length; i++){
            int cur = i;
            int prev = nums[i];
            do {
                int next = (cur + k)%nums.length;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                cur = next;
                count++;
            }while (cur != i);
        }
    }

    // 方法三：
    // 原始数组                  : 1 2 3 4 5 6 7
    //反转所有数字后             : 7 6 5 4 3 2 1
    //反转前 k 个数字后          : 5 6 7 4 3 2 1
    //反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums,int start,int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
