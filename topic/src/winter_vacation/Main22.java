package winter_vacation;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main22
 * @Description:
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 *
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 * @author: 呆呆
 * @date: 2020/2/2
 */
public class Main22 {
    /**
     * 不断右移右指针，使窗口不断增大；
     * 当窗口内出现一个不同的元素时，就可以将元素及其数量（等于左右指针之差）更新在数组中，然后让左指针指向右指针；
     * 遍历到最后一个字符时也需要结算，因此将右指针的终点设为数组之外一格。当右指针移到终点时也要更新数组。
     */
    public int compress(char[] chars) {
        int size = 0;
        int left = 0;
        for (int right = 0;right <= chars.length;right++){
            if (right  == chars.length || chars[right] != chars[left]) {
                chars[size++] = chars[left];
                if (right - left > 1) {
                    // 若大小大于9，则要占两个数组元素
                    for (char c : String.valueOf(right - left).toCharArray()) {
                        chars[size++] = c;
                    }
                }
                left = right;
            }
        }
        return size;
    }
}
