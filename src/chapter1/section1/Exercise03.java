package chapter1.section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//随便复习一些其他的知识
public class Exercise03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = new ArrayList<>(3);
        for (int i = 0; i <3 ; i++) {
            System.out.println("请输入一个数字");
            list.add(scan.nextLine());
        }
        int value =Integer.valueOf(list.get(0));
        Stream<Integer> stream = list.stream().map(str->Integer.valueOf(str));
        if(stream.allMatch(e->e.equals(value)))
            System.out.println("三个数字相同");

        else
            System.out.println("三个数字不相同");

    }
}
