package winter_vacation;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main6
 * @Description:
 * 判断一个整数是否是回文数。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @author: 呆呆
 * @date: 2020/1/15
 */
public class Main6 {
    public boolean isPalindrome1(int x) {
        String s = String.valueOf(x);
        char[] c = s.toCharArray();
        int start = 0;
        int end = c.length - 1;
        while (start <= end){
            if (c[start] != c[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 通过计算 1221 / 1000， 得首位1
    //通过计算 1221 % 10， 可得末位 1
    //进行比较
    //再将 22 取出来继续比较
    public boolean isPalindrome2(int x) {
        if (x < 0){
            return false;
        }
        int div = 1;
        while (x / div >= 10){
            div *= 10;
        }
        while (x > 0){
            int left = x / div;
            int right = x % 10;
            if (left != right){
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }


    // 每次进行取余操作 （ %10），取出最低的数字：y = x % 10
    //将最低的数字加到取出数的末尾：revertNum = revertNum * 10 + y
    //每取一个最低位数字，x 都要自除以 10
    //判断 x 是不是小于 revertNum ，当它小于的时候，说明数字已经对半或者过半了
    //最后，判断奇偶数情况：如果是偶数的话，revertNum 和 x 相等；如果是奇数的话，最中间的数字就在revertNum 的最低位上，将它除以 10 以后应该和 x 相等
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
