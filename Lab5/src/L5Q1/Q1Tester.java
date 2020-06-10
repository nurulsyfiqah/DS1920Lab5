package L5Q1;

import java.util.Random;

public class Q1Tester {
    public static void main(String[]args){

        String[] candy={"Blue", "Yellow","Orange", "Red"};
        Random r=new Random();
        Q1Stack<String> a=new Q1Stack<>();
        Q1Stack<String> b=new Q1Stack<>();

        for(int i=0; i<7; i++){
            int candyCol = r.nextInt(4);
            a.push(candy[candyCol]);
        }

        System.out.println("The candies in the container : ");
        a.showStack();
        System.out.println("\nAli takes all the candies one by one from the container and eats the blue ones.");
        System.out.println("He puts back the rest of candies in the container.");
        System.out.println("The candies in the container : ");
        while(!a.isEmpty()){
            String str = a.pop();
            if(!str.equals("Blue")){
                b.push(str);
            }
        }

        while(!b.isEmpty()){
            String str1 = b.pop();
            a.push(str1);
        }
        a.showStack();
    }
}
