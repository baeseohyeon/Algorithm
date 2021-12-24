package baekjoon.dp;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class test3687 { //https://escapefromcoding.tistory.com/147 참고

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = parseInt(br.readLine());
        long[] minDp = new long[101];
        String[] maxDp = new String[101];
        String[] nums = {"1", "7", "4", "2", "0", "8"};
        Arrays.fill(minDp, Long.MAX_VALUE);
        minDp[2] = 1;
        minDp[3] = 7;
        minDp[4] = 4;
        minDp[5] = 2;
        minDp[6] = 6;
        minDp[7] = 8;
        minDp[8] = 10;
        maxDp[2] = "1";
        maxDp[3] = "7";
        for (int i = 9; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                String num = minDp[i - j] + nums[j - 2];
                minDp[i] = Math.min(Long.parseLong(num), minDp[i]);
            }
        }
        for (int i = 4; i <= 100; i++) {
            maxDp[i] = maxDp[i - 2] + "1";
        }
        while (t-- > 0) {
            int n = parseInt(br.readLine());
            bw.write(minDp[n] + " " + maxDp[n] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
