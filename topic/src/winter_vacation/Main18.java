package winter_vacation;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main18
 * @Description:
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * @author: 呆呆
 * @date: 2020/1/29
 */
public class Main18 {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int c = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        while(i >= 0 || j >= 0 || c != 0){
            if(i >= 0) c += a.charAt(i--)-'0';
            if(j >= 0) c += b.charAt(j--)-'0';
            sb.append(c%2);
            c /= 2;
        }
        return sb.reverse().toString();
    }
}
