package baekjoon.greedy;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class test11501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = parseInt(br.readLine());
        while (t-- > 0) {
            int n = parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            long sum = 0;

            int maxNum = parseInt(s[n - 1]);
            for (int i = n - 2; i >= 0; i--) {
                int nowNum = parseInt(s[i]);
                if (maxNum < nowNum) {
                    maxNum = nowNum;
                } else {
                    sum += (maxNum - nowNum);
                }
            }

            bw.write(sum + "\n");
        }
        bw.flush();
    }
}
