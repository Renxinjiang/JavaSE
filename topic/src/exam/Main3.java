package exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @PackageName: exam
 * @ClassName: Main3
 * @Description:
 * 餐馆
 * @author: 呆呆
 * @date: 2020/2/12
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] table = new int[n];
            for(int i=0;i<n;i++)
                table[i]=sc.nextInt();

            int[][] cus = new int[m][2];
            for(int j=0;j<m;j++){
                cus[j][0]=sc.nextInt();
                cus[j][1]=sc.nextInt();
            }

            Arrays.sort(table);
            Arrays.sort(cus, new Comparator<int[]>(){

                public int compare(int[] a, int[] b){

                    return b[1]-a[1];

                }
            });

            long money = 0L;
            int index = 0;
            boolean[] tableb = new boolean[n];
            for(int i=0;i<m;i++){
                if(cus[i][0]>table[n-1])
                    continue;
                index = bs(table,cus[i][0]);
                while(index<n && tableb[index]==true)
                    index++;
                if(index<n){
                    money += cus[i][1];
                    tableb[index]=true;
                }
            }

            System.out.println(money);
        }
    }

    private static int bs(int[] num, int tar){
        int low=0;
        int high=num.length-1;
        int mid=0;
        while(low<=high){
            mid=(high+low)>>1;
            if(num[mid]>=tar)
                high=mid-1;
            else
                low=mid+1;
        }

        return low;
    }
}

