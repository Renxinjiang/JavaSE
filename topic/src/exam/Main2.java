package exam;

import java.util.Scanner;

/**
 * @PackageName: exam
 * @ClassName: Main2
 * @Description:
 * 字符串中找出连续最长的数字串
 * @author: 呆呆
 * @date: 2020/2/12
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(judge(s));
        }
    }

    public static String judge(String s){
        int max = 0;
        int count=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                count++;
                if(max<count){
                    max= count;
                    end = i;
                }
            }else{
                count = 0;
            }
        }
        String rev = s.substring(end-max+1,end+1);
        return rev;
    }
}
