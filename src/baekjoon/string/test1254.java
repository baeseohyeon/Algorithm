package baekjoon.string;

import java.util.Scanner;

public class test1254 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(i))) {
                System.out.println(s.length() + i);
                return;
            }
        }
    }

    private static boolean isPalindrome(String tmp) {
        int left = 0, right = tmp.length() - 1;
        while (left < right) {
            if (tmp.charAt(left++) != tmp.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
