package exam;

import sun.plugin2.message.GetAuthenticationMessage;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @PackageName: exam
 * @ClassName: Main1
 * @Description:
 * 最小的K个数
 * @author: 呆呆
 * @date: 2020/2/12
 */
public class Main1 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> rev = new ArrayList<>();
        if (k > input.length){
            return rev;
        }
        Arrays.sort(input);
        for (int i = 0;i < k;i++) {
            rev.add(input[i]);
        }
        return rev;
    }
}
