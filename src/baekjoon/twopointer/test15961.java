package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[d + 1];
        int[] table = new int[n];
        for (int i = 0; i < n; i++) {
            table[i] = Integer.parseInt(br.readLine());
        }
        int i = 0, j = 0, cnt = 0, ans = 0;
        while (i < n) {
            int len = j > i ? j - i + 1 : n - i + j + 1;
            int sushiNum = table[j];
            sushi[sushiNum]++;
            if (sushi[sushiNum] == 1) { //스시 처음먹은 종류면
                cnt++;
            }
            if (len == k) { //k개 먹었으면
                if (sushi[c] == 0) //쿠폰 안먹었을때
                    ans = Math.max(ans, cnt + 1);
                else
                    ans = Math.max(ans, cnt);
                sushi[table[i]]--;
                if (sushi[table[i++]] == 0)
                    cnt--;
            }
            j = j < n - 1 ? j + 1 : 0;
        }
        System.out.println(ans);
    }
}
