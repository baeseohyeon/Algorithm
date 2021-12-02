package baekjoon.twopointer;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = parseInt(s[0]);
        int m = parseInt(s[1]);
        s = br.readLine().split(" ");
        int sum = 0, ans = 0;
        int i = 0, j = 0;
        while (true) {
            if (sum >= m) {
                if (sum == m) {
                    ans++;
                }
                sum -= parseInt(s[i++]);
            } else if (j == n) {
                break;
            } else {
                sum += parseInt(s[j++]);
            }
        }
        System.out.println(ans);
    }

}
