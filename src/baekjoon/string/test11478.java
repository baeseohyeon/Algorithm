package baekjoon.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class test11478 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            String tmp = "";
            for (int j = i; j < s.length(); j++) {
                tmp += s.charAt(j);
                set.add(tmp);
            }
        }
        System.out.println(set.size());
    }
}
