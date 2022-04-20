package baekjoon.dp;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class test1495 { //https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-1495-%EA%B8%B0%ED%83%80%EB%A6%AC%EC%8A%A4%ED%8A%B8-JAVA%EC%9E%90%EB%B0%94

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int s = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        int[] dp = new int[m + 1];
        List<Integer> list = new ArrayList<>();
        Arrays.fill(dp,-1);
        dp[s] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int now = parseInt(st.nextToken());
            list.clear();
            for (int j = 0; j <= m; j++) {
                if (dp[j] == i - 1) {
                    if (j + now <= m) {
                        list.add(j + now);
                    }
                    if (j - now >= 0) {
                        list.add(j - now);
                    }
                }
            }
            for (int idx : list) {
                dp[idx] = i;
            }
        }
        int ans = -1;
        for (int i = m; i >= 0; i--) {
            if (dp[i] == n) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
