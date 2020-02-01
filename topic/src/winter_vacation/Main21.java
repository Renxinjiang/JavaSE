package winter_vacation;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main21
 * @Description:
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * @author: 呆呆
 * @date: 2020/2/1
 */
public class Main21 {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start < end && !isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (toLowerCase(s.charAt(start)) != toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isLetterOrDigit(Character c) {
        if (('0' <= c && c <= '9') || ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
            return true;
        }
        return false;
    }

    public Character toLowerCase(Character c) {
        if ('A' <= c && c <= 'Z') {
            return (char)(c + 32);
        }
        return c;
    }
}