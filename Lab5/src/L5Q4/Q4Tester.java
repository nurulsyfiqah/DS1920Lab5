package L5Q4;
import java.util.Scanner;

public class Q4Tester {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        //System.out.print(str.charAt(3);
        //System.out.print("\\( No Error");
        //int[] num = 1, 2};
        //if(arr[(3] < 4)

        System.out.print("Enter an expression : ");
        String str = s.nextLine();
        System.out.println(str);
        evalPair(str);
    }

    public static void evalPair(String str1){
        Q4Stack<Character> c = new Q4Stack();
        int flag = 0;
        char ch = ' ';
        int index = 0;
        int tag = 0;

        String str = ignore(str1);

        for(int i=0; i<str.length(); i++){
            //open bracket
            if(str.charAt(i) == '('||str.charAt(i) == '['||str.charAt(i) == '{'){
                c.push(str.charAt(i));
            }
            //close bracket
            else if(str.charAt(i) == ')'||str.charAt(i) == ']'||str.charAt(i) == '}'){
                if(c.isEmpty()){
                    //extra
                    flag = 2;
                    ch = str.charAt(i);
                    index = i;
                }else{
                    //extra
                    if(str.charAt(i)==')'){
                        if(c.peek() != '('){
                            flag = 2;
                            ch = ')';
                            index = i;
                            tag = i;
                            break;
                        }else
                            c.pop();
                    }
                    else if(str.charAt(i)==']'){
                        if(c.peek() != '['){
                            flag = 2;
                            ch = ']';
                            index = i;
                            tag = i;
                            break;
                        }else
                            c.pop();
                    }
                    else if(str.charAt(i)=='}'){
                        if(c.peek() != '{'){
                            flag = 2;
                            ch = '}';
                            index = i;
                            tag = i;
                            break;
                        }else
                            c.pop();
                    }
                }
            }
        }
        if(c.isEmpty() && ch==' '){
            flag = 3;
            index = str.length()-1;

        }
        else if(!c.isEmpty() && tag != 0){
            flag = 1;
            index = tag;
            if(c.peek()=='(')
                ch = ')';
            else if(c.peek()=='{')
                ch = '}';
            else if(c.peek()=='[')
                ch = ']';
        }
        else if(c.isEmpty()){
            index = str.length()-1;
        }
        else if(!c.isEmpty() && tag == 0){
            index = str.length()-1;
            flag = 1;
            if(c.peek()=='(')
                ch = ')';
            else if(c.peek()=='{')
                ch = '}';
            else if(c.peek()=='[')
                ch = ']';
        }
        display(flag,index,ch);
    }

    public static void display(int flag, int index, char ch){
        if(flag == 1){
            for(int i=0; i<index; i++){
                System.out.print(" ");
            }
            System.out.println("^ Missing "+ ch);
        }
        else if(flag == 2){
            for(int i=0; i<index; i++){
                System.out.print(" ");
            }
            System.out.println("^ Extra "+ ch);
        }
        else if(flag == 3)
            System.out.println("The expression is balanced");
        else{
            System.out.println("Invalid");
        }
    }

    public static String ignore(String str){
        for(int i = 0; i<str.length(); i++){
            if(str.contains("\\")){
                str = str.substring(0, i) + str.substring(i+2);
            }
        }
        return str;
    }
}
