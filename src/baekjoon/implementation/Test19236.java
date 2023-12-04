package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Test19236 {

    static int n = 4, m = 8, score;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static Fish shark;
    static Fish[][] map;

    static class Fish {

        int num, d, x, y;

        Fish(int num, int d) {
            this.num = num;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Fish[][] map = new Fish[n][n];
        Fish shark = new Fish(0, 0);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = parseInt(st.nextToken());
                int d = parseInt(st.nextToken());
                map[i][j] = new Fish(num, d - 1);
            }
        }
        initShark(map, shark);
        solve(map, shark);
        System.out.println(score);
    }


    private static void solve(Fish[][] map, Fish shark) {
        Fish[][] copyMap = copy(map);
        moveFish(copyMap, shark);
        if (!canMoveShark(copyMap, shark)) {
            score = Math.max(score, shark.num);
            return;
        }
        for (int i = 1; i <= n; i++) {
            int nx = shark.x + dx[shark.d] * i;
            int ny = shark.y + dy[shark.d] * i;
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || copyMap[nx][ny] == null) {
                continue;
            }
            Fish tmp = new Fish(copyMap[nx][ny].num, copyMap[nx][ny].d);
            Fish copyShark = new Fish(shark.num + tmp.num, tmp.d);
            copyShark.x = nx;
            copyShark.y = ny;
            copyMap[nx][ny] = null;
            solve(copyMap, copyShark);
            copyMap[nx][ny] = tmp;
        }
    }

    private static Fish[][] copy(Fish[][] map) {
        Fish[][] tmp = new Fish[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Objects.nonNull(map[i][j])) {
                    tmp[i][j] = new Fish(map[i][j].num, map[i][j].d);
                }
            }
        }
        return tmp;
    }

    private static void moveFish(Fish[][] map, Fish shark) {
        for (int k = 1; k <= n * n; k++) {
            for (int i = 0; i < n * n; i++) {
                int x = i / 4;
                int y = i % 4;
                Fish fish = map[x][y];
                if (Objects.nonNull(fish) && fish.num == k) {
                    for (int j = 0; j < 8; j++) {
                        int nextD = (fish.d + j) % m;
                        int nx = x + dx[nextD];
                        int ny = y + dy[nextD];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n || (shark.x == nx && shark.y == ny)) {
                            continue;
                        }
                        map[x][y].d = nextD;
                        if (Objects.isNull(map[nx][ny])) {
                            map[nx][ny] = map[x][y];
                            map[x][y] = null;
                            break;
                        }
                        if (Objects.nonNull(map[nx][ny])) {
                            Fish tmp = map[nx][ny];
                            map[nx][ny] = map[x][y];
                            map[x][y] = tmp;
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    private static void initShark(Fish[][] map, Fish shark) {
        shark.x = 0;
        shark.y = 0;
        shark.d = map[0][0].d;
        shark.num += map[0][0].num;
        map[0][0] = null;
    }

    private static boolean canMoveShark(Fish[][] map, Fish shark) {
        for (int i = 1; i <= n; i++) {
            int nx = shark.x + dx[shark.d] * i;
            int ny = shark.y + dy[shark.d] * i;
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] != null) {
                return true;
            }
        }
        return false;
    }
}
