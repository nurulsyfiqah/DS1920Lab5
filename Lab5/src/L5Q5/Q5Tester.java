package L5Q5;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q5Tester {
    public static void main(String[] args){
        try{
            System.out.println("Content of XML file");
            Scanner s = new Scanner(new FileInputStream("test4.xml"));
            String str = "";
            while(s.hasNextLine()){
                str+=s.nextLine()+"\n";

            }
            System.out.print(str);
            checkFile(str);

        }catch(FileNotFoundException e){
            System.out.println("File not Found");
        }

    }

    public static void checkFile(String str){
        str=str.replace("\n","");
        Q5Stack<String> a = new Q5Stack();
        int first=0, flag=0;
        int last=0;
        int i=0;
        boolean tag=true;
        String label="",close="";
        while(i<str.length()){
            if(str.charAt(i)=='<' && str.charAt(i+1)!='/'){
                Q5Stack b = new Q5Stack();
                first=i;
                while (str.charAt(i) != '>') {
                    i++;
                }
                label = str.substring(first,i+last+1);

                if(!a.isEmpty()){
                    while (!a.isEmpty()) {
                        if(a.peek().equals(label)){
                            flag=1;
                            display(flag,label,"");
                            break;
                        }else{
                            a.push(label);
                            break;
                        }
                    }
                }else{
                    a.push(label);
                }
            }
            else if(str.charAt(i)=='<' && str.charAt(i+1) =='/'){
                first=i;
                while (str.charAt(i) != '>') {
                    i++;
                }
                close = str.substring(first,i+last+1);
                String noSlash = close.replace("/","");
                if(!a.isEmpty()){
                    String peek = a.peek();
                    if(peek.equals(noSlash)){
                        a.pop();
                    }else{
                        flag=2;
                        display(flag,a.peek(),close);
                        break;
                    }
                }
            }
            i++;
        }

        if(a.isEmpty() && flag!=1){
            flag=3;
            display(flag,"","");
        }else{
            display(0,"","");
        }
    }

    public static void display(int flag, String label1, String label2){
        if(flag==1){
            System.out.println("Duplicate root element "+ label1);
        }else if(flag==2){
            System.out.println("Begin Element : "+label1+" Invalid ending element : "+label2);
        }else if(flag==3){
            System.out.println("The xml document is valid");
        }else{
            System.out.print("");
        }
    }
}
