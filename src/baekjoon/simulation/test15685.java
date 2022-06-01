package baekjoon.simulation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test15685 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map = new int[101][101];

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());
            int d = parseInt(st.nextToken());
            int g = parseInt(st.nextToken());
            setLine(x, y, d, g);
        }
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void setLine(int x, int y, int d, int g) {
        map[y][x] = 1;
        List<Integer> directions = new ArrayList<>();
        directions.add(d);
        for (int j = 1; j <= g; j++) {
            int size = directions.size();
            for (int k = size - 1; k >= 0; k--) {
                int nowD = directions.get(k);
                int nextD = (nowD + 1) % 4;
                directions.add(nextD);
            }
        }
        for (int j = 0; j < directions.size(); j++) {
            int nextD = directions.get(j);
            x = x + dx[nextD];
            y = y + dy[nextD];
            map[y][x] = 1;
        }
    }
}
