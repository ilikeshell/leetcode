import java.util.Stack;

public class PostfixExpDemo
{
    public static void main(String[] args)
    {
        String s = "1* (9 + 6 / 3 - 5) +10";
        System.out.println(getPostfixExp(s));
        System.out.println(calValueFromPostfix(getPostfixExp(s)));
    }

    /** 把一个中缀表达式转换为一个后缀表达式 */
    public static String getPostfixExp(String s)
    {
        String ret = "";
        Stack<String> operators = new Stack<>();

        //以空格为隔断符分割字符串
        s = s.trim();
        s = insertSpace(s);
        String[] tokens = s.split("\\s+");

        for(String token : tokens)
        {
            /** 如果是左括号，直接入栈 */
            if(token.equals("("))
                operators.push(token);
            /** 如果是右括号，从栈中直接弹出栈顶所有操作符，直到碰到左括号 */
            else if(token.equals(")"))
            {
                while(!operators.peek().equals("("))
                    ret += operators.pop() + " ";
                operators.pop(); //弹出左括号
            }
            /** 如果是'+'、'-'、'*'、'/' 等运算符 */
            else if(token.matches("[\\u002b\\u002d\\u002a\\u002f]"))
            {
                /** 栈为空,或者当前运算符优先级高于栈顶运算符就直接入栈 */
                if(operators.isEmpty() || comparePriority(token, operators.peek()) > 0)
                    operators.push(token);
                /** 当前运算符优先级低于栈顶运算符 */
                else
                {
                    /** 栈不为空,且当前运算符优先级低于于栈顶运算符就一直出栈 */
                    while(!operators.isEmpty() && !(comparePriority(token, operators.peek()) > 0))
                        ret += operators.pop() + " ";

                    /** 把当前运算符入栈 */
                    operators.push(token);
                }
            }
            /** 如果是运算数则直接输出 */
            else
                ret += token + " ";
        }

        /** 弹出栈中剩余运算符 */
        while(!operators.isEmpty())
            ret += operators.pop() + " ";

        return ret;
    }

    /** 在所有运算符两边插入空格 */
    private static String insertSpace(String expression)
    {
        String ret = "";
        for (int i = 0; i < expression.length(); i++)
        {
            if(expression.charAt(i) == '+' ||
                    expression.charAt(i) == '-' ||
                    expression.charAt(i) == '*' ||
                    expression.charAt(i) == '/' ||
                    expression.charAt(i) == '(' ||
                    expression.charAt(i) == ')')
            ret = ret + " " + expression.charAt(i) + " ";
            else
                ret += expression.charAt(i);
        }
        return ret;
    }

    /** 比较运算符的优先级 */
    private static int comparePriority(String op1, String op2)
    {
        if(op1.matches("[\\u002b\\u002d]") && op2.matches("[\\u002b\\u002d]") ||
                op1.matches("[\\u002a\\u002f]") && op2.matches("[\\u002a\\u002f]"))
            return 0;
        else if (op1.matches("[\\u002a\\u002f]") && op2.matches("[\\u002b\\u002d]") ||
                    op2.equals("("))                //栈内的小括号优先级最低
            return 1;
        else
            return -1;
    }

    private static int calValueFromPostfix(String postfixExp)
    {
        Stack<String> operands = new Stack<>();
        postfixExp = postfixExp.trim();

        String[] tokens = postfixExp.split("\\s+");

        for(String token : tokens)
        {
            if(token.matches("[\\u002b\\u002d\\u002a\\u002f]"))
            {
                int op2 = Integer.parseInt(operands.pop());
                int op1 = Integer.parseInt(operands.pop());
                switch(token)
                {
                    case "+":
                        operands.push(String.valueOf(op1 + op2));
                        break;
                    case "-":
                        operands.push(String.valueOf(op1 - op2));
                        break;
                    case "*":
                        operands.push(String.valueOf(op1 * op2));
                        break;
                    case "/":
                        operands.push(String.valueOf(op1 / op2));
                        break;
                }
            }
            else
                operands.push(token);
        }
        return Integer.parseInt(operands.pop());
    }
}
