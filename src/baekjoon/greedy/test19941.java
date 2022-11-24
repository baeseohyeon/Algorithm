package baekjoon.greedy;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test19941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int k = parseInt(st.nextToken());
        char[] chr = br.readLine().toCharArray();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char c = chr[i];
            if (c == 'P') {
                for (int j = Math.max(i - k, 0); j <= i + k && j < n; j++) {
                    if (chr[j] == 'H') {
                        cnt++;
                        chr[j] = 'X';
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
