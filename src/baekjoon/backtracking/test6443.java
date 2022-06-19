package baekjoon.backtracking;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test6443 {

    static StringBuilder sb;
    static char[] arr;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            arr = br.readLine().toCharArray();
            visit = new int[26];
            for (char c : arr) {
                visit[c - 'a']++;
            }
            dfs(0, new char[arr.length]);
        }
        System.out.println(sb);
        br.close();
    }

    private static void dfs(int idx, char[] tmp) {
        if (idx == arr.length) {
            for (char c : tmp) {
                sb.append(c);
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (visit[i] > 0) {
                visit[i]--;
                tmp[idx] = (char) (i + 'a');
                dfs(idx + 1, tmp);
                visit[i]++;
            }
        }
    }
}
