package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1213 { //https://broship.tistory.com/134?category=845145

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int center = 0;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'A']++;
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 == 1) {
                center = i;
                cnt++;
            }
        }
        if (cnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        String ans = "";
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i] / 2; j++) {
                ans += (char) ('A' + i);
            }
        }
        String tmp = ans;
        if (cnt == 1) {
            ans += (char) ('A' + center);
        }
        for (int i = tmp.length() - 1; i >= 0; i--) {
            ans += tmp.charAt(i);
        }
        System.out.println(ans);
    }
}
