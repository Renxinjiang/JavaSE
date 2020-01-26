package winter_vacation;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main15
 * @Description:
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * @author: 呆呆
 * @date: 2020/1/26
 */
public class Main15 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1;i>=0;i--) {
            if (digits[i] != 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] ret = new int[digits.length+1];
        ret[0] = 1;
        return ret;
    }
}
