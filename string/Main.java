package string;

/**
 * @PackageName: string
 * @ClassName: Main
 * @Description:
 * 反编译、手工入池
 * @author: 呆呆
 * @date: 2019/10/19
 */
public class Main {
    public static void main(String[] args) {
        //javap -c Main.class>out.txt
        String s1 = "hello"+" "+"world";

        //手工入池
        //s2不在常量池，t在常量池中
        String s2 = new String("hello");
        String t = s2.intern();
    }
}
