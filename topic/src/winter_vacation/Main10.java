package winter_vacation;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main10
 * @Description:
 * 你的朋友正在使用键盘输入他的名字 name。
 * 偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。
 * 如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。

 * @author: 呆呆
 * @date: 2020/1/20
 */
public class Main10 {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()){
            return false;
        }
        int j = 0;
        for (int i = 0;i<typed.length();i++){
            if (typed.charAt(i) == name.charAt(j)){
                j++;
            }
            if (j == name.length()){
                break;
            }
        }
        if (j == name.length()){
            return true;
        }
        return false;
    }
}
