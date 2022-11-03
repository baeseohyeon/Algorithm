package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test15904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean u = false, c = false, p = false, lastC = false;
        for (char ch : s.toCharArray()) {
            if (ch == 'U') {
                u = true;
            }
            if (ch == 'C' && u) {
                c = true;
            }
            if (ch == 'P' && c) {
                p = true;
            }
            if (ch == 'C' && p) {
                lastC = true;
            }
        }
        if (u && c && p && lastC) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}
