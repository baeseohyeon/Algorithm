package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1342 {

    static int n, ans;
    static String s;
    static int[] alphabet;
    static int[] chr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        n = s.length();
        alphabet = new int[26];
        chr = new int[n];
        for (char c : s.toCharArray()) {
            alphabet[c - 'a']++;
        }
        dfs(0);
        System.out.println(ans);
    }

    private static void dfs(int idx) {
        if (idx == n) {
            ans++;
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] == 0) {
                continue;
            }
            chr[idx] = i;
            if (isUnLuckyString(idx)) {
                continue;
            }
            alphabet[i]--;
            dfs(idx + 1);
            alphabet[i]++;
        }
    }

    private static boolean isUnLuckyString(int idx) {
        return idx > 0 && chr[idx] == chr[idx - 1];
    }
}
