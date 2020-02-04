package winter_vacation;

import java.util.Stack;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main24
 * @Description:
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * @author: 呆呆
 * @date: 2020/2/4
 */
public class Main24 {
    public int evalRPN(String[] tokens) {
        //用栈解决
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < tokens.length;i++){
            if (tokens[i].equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if (tokens[i].equals("-")){
                stack.push(-stack.pop()+stack.pop());
            }else if (tokens[i].equals("*")){
                stack.push(stack.pop()*stack.pop());
            }else if (tokens[i].equals("/")){
                int x = stack.pop();
                stack.push(stack.pop()/x);
            }else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
