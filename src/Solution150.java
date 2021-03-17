/**
 * 150. 逆波兰表达式求值
 *
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面.
 *
 * 逆波兰表达式主要有以下两个优点：
 *     1, 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 *     2, 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。

 */
import java.util.Stack;
public class Solution150
{
    public int evalRPN(String[] tokens)
    {
        Stack<Integer> operands = new Stack<>();

        for(String token : tokens)
        {
            token = token.trim();
            if(token.length() == 0)
                continue;
            else if(token.matches("[\\u002b\\u002d\\u002a\\u002f]"))
            {
                int op1 = operands.pop();
                int op2 = operands.pop();
                if(token.equals("+"))
                    operands.push(op2 + op1);
                else if(token.equals("-"))
                    operands.push(op2 - op1);
                else if(token.equals("*"))
                    operands.push(op2 * op1);
                else
                    operands.push(op2 / op1);
            }
            else
                operands.push(Integer.valueOf(token));
        }
        return operands.pop();
    }
}
