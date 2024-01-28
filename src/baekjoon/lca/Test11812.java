package baekjoon.lca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test11812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long count = 0;
            if (k == 1) {
                sb.append(Math.abs(x - y)).append("\n");
                continue;
            }
            while (x != y) {
                if (x < y) {
                    y = (y - 2) / k + 1;
                } else {
                    x = (x - 2) / k + 1;
                }
                count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
