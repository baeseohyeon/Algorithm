package baekjoon.greedy;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test17615 {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        String s = br.readLine();
        int redCnt = 0, blueCnt = 0, cnt = 0, ans = MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                redCnt++;
            } else {
                blueCnt++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                cnt++;
            } else {
                break;
            }
        }
        ans = Math.min(ans, redCnt - cnt);
        cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'R') {
                cnt++;
            } else {
                break;
            }
        }
        ans = Math.min(ans, redCnt - cnt);
        cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'B') {
                cnt++;
            } else {
                break;
            }
        }
        ans = Math.min(ans, blueCnt - cnt);
        cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'B') {
                cnt++;
            } else {
                break;
            }
        }
        ans = Math.min(ans, blueCnt - cnt);
        System.out.println(ans);
    }
}
