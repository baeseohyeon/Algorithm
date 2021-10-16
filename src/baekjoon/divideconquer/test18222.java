package baekjoon.divideconquer;

import java.util.Scanner;

public class test18222 {
    public static void solve(long num, long n, int cnt) {
        if (n == 1) {
            System.out.println(cnt % 2 == 0 ? 0 : 1);
            return;
        }
        if (num / 2 >= n) { //왼쪽
            solve(num / 2, n, cnt);
        } else {
            solve(num / 2, n - num / 2, cnt + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        for (int i = 0; ; i++) {
            long num = (long) Math.pow(2, i);
            if (num >= n) {
                solve(num, n, 0);
                break;
            }
        }
    }
}
