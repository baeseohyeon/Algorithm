package baekjoon.twopointer;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class test17609 {
    static int ans;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = parseInt(br.readLine());
        while (t-- > 0) {
            ans = 0;
            s = br.readLine();
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    ans = 2;
                    move(i+1,j,s);
                    move(i,j-1,s);
                    break;
                }
                i++;
                j--;
            }
            bw.write(ans+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void move(int i, int j, String s) {
        if(ans == 1)
            return;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return;
            }
            i++;
            j--;
        }
        ans = 1;
    }

}
