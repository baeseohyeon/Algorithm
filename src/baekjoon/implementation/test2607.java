package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2607 { //https://dundung.tistory.com/131

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        String[] str = new String[n];
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
        for (int i = 0; i < str[0].length(); i++) {
            arr[str[0].charAt(i) - 'A']++;
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (isSimilar(str[i], arr, str[0].length())) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean isSimilar(String s, int[] arr, int len) {
        int[] nums = arr.clone();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            if (nums[c] > 0) {
                nums[c]--;
                cnt++;
            }
        }
        if (len == cnt && s.length() == len + 1) { //기준보다 길이가 1길때
            return true;
        }
        if (s.length() == cnt && s.length() == len - 1) { //기준보다 길이가 1 짧을때
            return true;
        }
        if (s.length() == len && (cnt == len || cnt == len - 1)) { //길이가 같을때
            return true;
        }
        return false;
    }
}
