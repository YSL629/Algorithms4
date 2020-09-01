package chapter1.section2;

import java.util.Scanner;


public class Exercise9 {
    public static void main(String[] args) {
        while(true)
  {      Scanner scan =  new Scanner(System.in);
        System.out.println("输入表达式");
        String expression = scan.nextLine();
        if(expression == "exit")
            break;
        Stack<String> opt = new Stack<>();
        Stack<String> num = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            String symbol = String.valueOf(expression.charAt(i));
            if(symbol.equals("(")){
                // no operation
            }
            else if(symbol.equals("+")){
                opt.push(symbol);
            }
            else if(symbol.equals("-")) {
                opt.push(symbol);
            }
            else if(symbol.equals("*")){
                opt.push(symbol);
            }
            else if(symbol.equals("/")){
                opt.push(symbol);
            }
            else if(symbol.equals(")")){
                String rightNum = num.pop();
                String leftNum = num.pop();
                String op = opt.pop();
                String dest = "(" + leftNum + op + rightNum + ")";
                num.push(dest);
            }
            else
                num.push(symbol);
        }
        System.out.println(num.pop());

    }
}

}
