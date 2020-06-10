package lq;

import java.util.Scanner;
import java.util.Stack;
public class LQ54 {

    static int index = 0;

    public static String Missing(String str){
        Stack<Character> stack = new Stack();
        int index=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='{'||str.charAt(i)=='('||str.charAt(i)=='[')
                stack.push(str.charAt(i));
            else if(str.charAt(i)=='}'||str.charAt(i)==')'||str.charAt(i)==']'){
                if((str.charAt(i)==']'&&stack.peek()=='[')||(str.charAt(i)==')'&&stack.peek()=='(')||(str.charAt(i)=='}'&&stack.peek()=='{'))
                    stack.pop();
                else{
                   index=i;
                   break;
                }
            }
            index=i;
        }
        if((!stack.isEmpty())){
            for(int j=0;j<index;j++){
                System.out.print(" ");
            }
        return "^Missing";
        }else
        return "Balance";
        
    }        
     
    public static void main(String[] args) {
        String str = "(makanan(#);";
        System.out.println(str);
        System.out.println(Missing(str));
        

        
    }
}
//        Stack<Character> s = new Stack();
//        
//        for(int i=0;i<str.length();i++){
//            if(str.charAt(i)=='{'||
//                str.charAt(i)=='('||
//                str.charAt(i)=='[')
//                s.push(str.charAt(i));
//            else if(!s.isEmpty()&&
//                   ((str.charAt(i)==']'&&s.peek()=='[')||
//                    (str.charAt(i)==')'&&s.peek()=='(')||
//                    (str.charAt(i)=='}'&&s.peek()=='{')))
//                s.pop();
////            else
////                s.push(str.charAt(i));
//        }
//        if(s.isEmpty()){
//            System.out.println("Balanced");
//        }
//        else{
//            System.out.println("Unbalanced");
//        }