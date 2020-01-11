package winter_vacation;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main1
 * @Description:
 * 实现函数 ToLowerCase()，
 * 该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 * @author: 呆呆
 * @date: 2020/1/11
 */
public class Main1 {
    public String toLowerCase(String str) {
        //对所有65～90之间的进行加32运算，最后拼接就行
        char[] c = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char chars : c){
            if (chars>=65 && chars<=90){
                chars = (char)(chars + 32);
            }
            sb.append(chars);
        }
        return sb.toString();
    }
}
