package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1338 {

    static int n;
    static int m;
    static int ans = 0;
    static String[] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    ans++;
                    visit[i][j] = true;
                    search(i, j, map[i].charAt(j));
                }
            }
        }
        System.out.println(ans);
    }

    private static void search(int i, int j, char ch) {
        if (ch == '-') {
            while (++j < m && map[i].charAt(j) == ch) {
                visit[i][j] = true;
            }
        } else {
            while (++i < n && map[i].charAt(j) == ch) {
                visit[i][j] = true;
            }
        }
    }
}
