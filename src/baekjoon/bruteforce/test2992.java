package baekjoon.bruteforce;

import static java.lang.Integer.*;

import java.util.Scanner;

public class test2992 {

    static int len, ans = MAX_VALUE;
    static String originNumString;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        originNumString = sc.next();
        len = originNumString.length();
        visit = new boolean[len];
        findNum("");
        System.out.println(ans == MAX_VALUE ? 0 : ans);
    }

    private static void findNum(String now) {
        if (now.length() == len) {
            if (parseInt(now) > parseInt(originNumString)) {
                ans = Math.min(ans, parseInt(now));
            }
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visit[i]) {
                visit[i] = true;
                findNum(now + originNumString.charAt(i));
                visit[i] = false;
            }
        }
    }
}
