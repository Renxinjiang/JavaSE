package winter_vacation;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main8
 * @Description:
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * @author: 呆呆
 * @date: 2020/1/17
 */
public class Main8 {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] num1Copy = new int[m];
        System.arraycopy(nums1,0,num1Copy,0,m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 < m && p2 < n){
            if (num1Copy[p1] < nums2[p2]){
                nums1[p] = num1Copy[p1];
                p++;
                p1++;
            }else {
                nums1[p] = nums2[p2];
                p++;
                p2++;
            }
        }
        if (p1 < m){
            System.arraycopy(num1Copy,p1,nums1,p1+p2,m+n-p1-p2);
        }
        if (p2 < n){
            System.arraycopy(nums2,p2,nums1,p1+p2,m+n-p1-p2);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;
        while (p1>=0 && p2>=0){
            if (nums1[p1] < nums2[p2]){
                nums1[p] = nums2[p2];
                p--;
                p2--;
            }else {
                nums1[p] = nums1[p1];
                p--;
                p1--;
            }
        }
        // while执行完后，nums2不知道是否为空，若不为空，一定比nums1小，则拷贝到nums1中
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }
}
