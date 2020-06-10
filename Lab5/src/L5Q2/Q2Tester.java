package L5Q2;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Q2Tester {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //ob 300 mul 75 add 4350 cb div 15 add 1126
        //ob ob 5 add 8 cb sub ob 7 sub 3 cb cb mul 8 add 25 mod 3
        System.out.print("Enter infix expression : ");
        String exp = s.nextLine();
        System.out.print("The infix expression is : ");
        String infix = infixExpression(exp);
        System.out.println(infix);
        System.out.print("The postfix expression is : ");
        String postfix = infixToPostfix(infix);
        System.out.println(postfix);
        System.out.print("The result is : ");
        System.out.println(postfixEvaluation(postfix));
    }
    
    public static String infixExpression(@NotNull String a) {

        String[] str = a.split(" ");
        String infix = "";
        for (int i = 0; i < str.length; i++) {

            if (str[i].equalsIgnoreCase("add")) {
                infix += "+ ";
            } else if (str[i].equalsIgnoreCase("sub")) {
                infix += "- ";
            } else if (str[i].equalsIgnoreCase("mul")) {
                infix += "* ";
            } else if (str[i].equalsIgnoreCase("div")) {
                infix += "/ ";
            } else if (str[i].equalsIgnoreCase("mod")) {
                infix += "% ";
            } else if (str[i].equalsIgnoreCase("ob")) {
                infix += "( ";
            } else if (str[i].equalsIgnoreCase("cb")) {
                infix += ") ";
            } else {
                infix += str[i] +" ";
            }
        }
        return infix;
    }

    public static String infixToPostfix(String b) {
        String str="";
        char c=' ';
        String[] a = b.split(" ");
        Q2Stack<Character> stack = new Q2Stack<>();
        for(int i=0; i<a.length; i++) {
            if (Character.isLetterOrDigit(a[i].charAt(0)))
                str += a[i]+" ";
            else if (a[i].charAt(0) == '(')
                stack.push(a[i].charAt(0));
            else if (a[i].charAt(0) == ')') {
                c = stack.pop();
                while (c != '('){
                    str+=c+" ";
                    c = stack.pop();
                }
            }
            else {
                if (!stack.isEmpty()) {
                    if (stack.peek()=='(')
                        stack.push(a[i].charAt(0));
                    else {
                        c = stack.peek();
                        while(getPriority(a[i].charAt(0)) <= getPriority(c)) {
                            str+=stack.pop()+" ";
                            if (!stack.isEmpty()) {
                                c = stack.peek();
                                if (c=='(')
                                    break;
                            }
                            else
                                break;
                        }
                        stack.push(a[i].charAt(0));
                    }
                }
                else
                    stack.push(a[i].charAt(0));
            }
        }
        while (!stack.isEmpty())
            str+=stack.pop()+" ";

        return str;
    }

    public static int getPriority(char a) {
        switch (a) {
            case '*':
            case '/':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    public static int postfixEvaluation(String a) {
        Q2Stack<String> stack = new Q2Stack<>();
        String temp;
        String[] word = a.trim().split("\\s+");
        int num1 = 0, num2 = 0, result = 0;
        for (int i = 0; i < word.length; i++) {
            if (isInteger(word[i])) {
                temp = word[i];
                stack.push(temp);
            } else {
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                result = getResult(num1, num2, word[i]);
                stack.push(result + "");
            }
        }
        result = Integer.parseInt(stack.pop());
        return result;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static int getResult(int a, int b, String c) {
        switch (c) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "%":
                return a % b;

        }
        return 0;
    }

}
