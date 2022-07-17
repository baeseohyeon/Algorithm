package baekjoon.backtracking;

import java.util.Scanner;

public class test9663 {

    static int n, ans;
    static int[] rows;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        rows = new int[n + 1];
        dfs(0);
        System.out.println(ans);
    }

    private static void dfs(int now) {
        if (now == n) {
            ans++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            rows[now + 1] = i;
            if (isRight(now + 1)) {
                dfs(now + 1);
            }
        }
    }

    private static boolean isRight(int now) {
        for (int i = 1; i < now; i++) {
            if (rows[i] == rows[now] || Math.abs(rows[i] - rows[now]) == Math.abs(i - now)) {
                return false;
            }
        }
        return true;
    }
}
