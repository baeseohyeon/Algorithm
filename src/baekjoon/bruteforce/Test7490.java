package baekjoon.bruteforce;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test7490 {

    static int n;
    static StringBuilder expression;
    static StringBuilder ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = parseInt(br.readLine());
        ans = new StringBuilder();
        while (t-- > 0) {
            n = parseInt(br.readLine());
            expression = new StringBuilder("1");
            dfs(2);
            ans.append("\n");
        }
        System.out.println(ans);
    }

    private static void dfs(int now) {
        if (now == n + 1) {
            check();
            return;
        }
        expression.append(' ').append(now);
        dfs(now + 1);
        expression.setLength(expression.length() - 2);

        expression.append('+').append(now);
        dfs(now + 1);
        expression.setLength(expression.length() - 2);

        expression.append('-').append(now);
        dfs(now + 1);
        expression.setLength(expression.length() - 2);
    }

    private static void check() {
        String s = expression.toString().replaceAll(" ", "");
        StringBuilder tmp = new StringBuilder();
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case '+':
                    result += parseInt(tmp.toString());
                    tmp = new StringBuilder();
                    break;
                case '-':
                    result -= parseInt(tmp.toString());
                    tmp = new StringBuilder();
                    break;
                default:
                    tmp.insert(0, c);
            }
        }
        result += parseInt(tmp.toString());
        if (result == 0) {
            ans.append(expression.substring(0)).append("\n");
        }
    }
}
