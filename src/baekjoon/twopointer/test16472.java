package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test16472 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int i = 0, j = 0, ans = 0;
        int[] arr = new int[26];
        while (j < s.length()) {
            int rightNum = s.charAt(j++) - 'a';
            arr[rightNum]++;
            if (arr[rightNum] == 1) {
                n--;
            }
            while(n < 0){
                int leftNum = s.charAt(i++) - 'a';
                arr[leftNum]--;
                if (arr[leftNum] == 0){
                    n++;
                }
            }
            ans = Math.max(ans, j - i);

        }
        System.out.println(ans);
    }
}
