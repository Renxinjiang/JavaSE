package winter_vacation;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main13
 * @Description:
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * @author: 呆呆
 * @date: 2020/1/23
 */
public class Main13 {
    public int[] sortArrayByParity1 (int[] A) {
        int[] B = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        for (int i = 0;i < A.length;i++){
            if (A[i] % 2 == 0){
                B[start++] = A[i];
            }else {
                B[end--] = A[i];
            }
        }
        return B;
    }
    
}
