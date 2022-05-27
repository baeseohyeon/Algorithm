package baekjoon.simulation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class test20056 {

    static int n, m, k;
    static Queue<FireBall> q;
    static List<FireBall>[][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static class FireBall {

        int x, y, m, d, s;

        FireBall(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        q = new LinkedList<>();
        map = new ArrayList[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());
            int m = parseInt(st.nextToken());
            int s = parseInt(st.nextToken());
            int d = parseInt(st.nextToken());
            map[x - 1][y - 1].add(new FireBall(x - 1, y - 1, m, s, d));
        }

        while (k-- > 0) {
            setFireBall();
            moveFireBall();
            unionFireBall();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (FireBall fireBall : map[i][j]) {
                    sum += fireBall.m;
                }
            }
        }

        System.out.println(sum);
    }

    private static void setFireBall() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (FireBall fireBall : map[i][j]) {
                    q.add(fireBall);
                }
                map[i][j].clear();
            }
        }
    }

    private static void unionFireBall() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int size = map[i][j].size();
                if (size >= 2) {
                    int mSum = 0;
                    int sSum = 0;
                    int evenCount = 0;
                    for (FireBall fireBall : map[i][j]) {
                        mSum += fireBall.m;
                        sSum += fireBall.s;
                        if (fireBall.d % 2 == 0) {
                            evenCount++;
                        }
                    }
                    map[i][j].clear();
                    if (mSum / 5 == 0) {
                        continue;
                    }
                    int nextD = 1;
                    if (evenCount == size || evenCount == 0) {
                        nextD--;
                    }
                    for (int d = nextD; d < 8; d += 2) {
                        map[i][j].add(new FireBall(i, j, mSum / 5, sSum / size, d));
                    }
                }
            }
        }
    }

    private static void moveFireBall() {
        while (!q.isEmpty()) {
            FireBall now = q.poll();
            int x = now.x;
            int y = now.y;
            int m = now.m;
            int s = now.s;
            int d = now.d;
            int nx = (x + n + dx[d] * (s % n)) % n;
            int ny = (y + n + dy[d] * (s % n)) % n;
            map[nx][ny].add(new FireBall(nx, ny, m, s, d));
        }
    }
}
