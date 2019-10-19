package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @PackageName: string
 * @ClassName: MyString
 * @Description:
 * 模拟常量池入池
 * 实现一个String，实现常见方法，保证对象不可变
 * @author: 呆呆
 * @date: 2019/10/19
 */
public final class MyString {
    // 利用一个静态属性模拟常量池
    private static List<MyString> constPool = new ArrayList<>();

    // 模拟 String s = “hello”
    public static MyString literal(MyString s){
        // 1.先找，找到直接返回常量池中的对象引用
        // 2.否则，创建并入池，返回池中对象引用
        int i = constPool.indexOf(s);
        if (i == -1){
            constPool.add(s);
            return s;
        }
        return constPool.get(i);
    }

    // 模拟
    // String s = new String("hello");
    // String t = s.intern();
    public MyString intern(){
        int i = constPool.indexOf(this);
        if (i == -1){
            constPool.add(this);
            return this;
        }
        return constPool.get(i);
    }

    private final char[] value;

    public MyString(char[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }

    public MyString(char[] value,int offset,int count){
        this.value = Arrays.copyOfRange(value,offset,offset+count);
    }

    public char charAt(int index){
        return value[index];
    }

    public char[] toCharArray(){
        return Arrays.copyOf(value,value.length);
    }
}
