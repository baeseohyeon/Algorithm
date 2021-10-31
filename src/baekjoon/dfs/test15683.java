package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class test15683 {
    static class Camera {
        int x, y, num;

        Camera(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static int n;
    static int m;
    static int ans;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Camera> cameraList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        ans = n * m;
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cameraList.add(new Camera(i, j, map[i][j]));
                }
            }
        }
        dfs(0, map);
        System.out.println(ans);

    }

    private static void dfs(int now, int[][] arr) {
        if (now == cameraList.size()) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0)
                        cnt++;
                }
            }
            ans = Math.min(ans, cnt);
        } else {
            Camera camera = cameraList.get(now);
            int x = camera.x;
            int y = camera.y;
            int num = camera.num;
            for (int i = 0; i < 4; i++) {
                int[][] tmp = copyArr(arr);
                switch (num) {
                    case 1:
                        move(x, y, i, tmp);
                        break;
                    case 2:
                        move(x, y, i, tmp);
                        move(x, y, i + 2 > 3 ? i - 2 : i + 2, tmp);
                        break;
                    case 3:
                        move(x, y, i, tmp);
                        move(x, y, i + 1 > 3 ? 0 : i + 1, tmp);
                        break;
                    case 4:
                        move(x, y, i, tmp);
                        move(x, y, i + 1 > 3 ? 0 : i + 1, tmp);
                        move(x, y, i + 2 > 3 ? i - 2 : i + 2, tmp);
                        break;
                    case 5:
                        move(x, y, i, tmp);
                        move(x, y, i + 1 > 3 ? 0 : i + 1, tmp);
                        move(x, y, i + 2 > 3 ? i - 2 : i + 2, tmp);
                        move(x, y, i + 3 > 3 ? i - 1 : i + 3, tmp);
                        break;
                }
                dfs(now + 1, tmp);
            }
        }
    }

    private static int[][] copyArr(int[][] arr) {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }

    private static void move(int x, int y, int d, int[][] tmp) {
        int nx = x + dx[d];
        int ny = y + dy[d];
        while (nx >= 0 && ny >= 0 && nx < n && ny < m && tmp[nx][ny] != 6) {
            if (tmp[nx][ny] == 0)
                tmp[nx][ny] = -1;
            nx += dx[d];
            ny += dy[d];
        }
    }
}
