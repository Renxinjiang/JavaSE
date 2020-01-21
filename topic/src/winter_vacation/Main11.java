package winter_vacation;

import java.util.Arrays;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main11
 * @Description:
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * @author: 呆呆
 * @date: 2020/1/21
 */
public class Main11 {
    public int[] sortedSquares1(int[] A) {
        for (int i = 0;i < A.length;i++){
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public int[] sortedSquares(int[] A) {
        int i = 0;
        while (i < A.length && A[i] < 0){
            i++;
        }
        int pre = i - 1;
        int B[] = new int[A.length];
        int j = 0;
        while (pre >= 0 && i < A.length){
            if (A[pre]*A[pre]<A[i]*A[i]){
                B[j++] = A[pre]*A[pre];
                pre--;
            }else {
                B[j++] = A[i] * A[i];
                i++;
            }
        }
        while (pre >= 0){
            B[j++] = A[pre]*A[pre];
            pre--;
        }
        while (i < A.length){
            B[j++] = A[i] * A[i];
            i++;
        }
        return B;
    }
}
