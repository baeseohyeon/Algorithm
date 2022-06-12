package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class test17143 { //https://minhamina.tistory.com/65

    static int r, c, ans;
    static List<Shark> movedSharks;
    static Shark[][] map;
    static Queue<Shark> q;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Shark {

        int r, c, s, d, z;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = parseInt(st.nextToken());
        c = parseInt(st.nextToken());
        movedSharks = new ArrayList<>();
        q = new LinkedList<>();
        map = new Shark[r][c];
        int m = parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            int s = parseInt(st.nextToken());
            int d = parseInt(st.nextToken());
            int z = parseInt(st.nextToken());
            if (d == 1) {
                d = 0;
            } else if (d == 4) {
                d = 1;
            }
            map[r - 1][c - 1] = new Shark(r - 1, c - 1, s, d, z);
        }
        for (int i = 0; i < c; i++) {
            catchShark(i);
            setQ();
            moveShark();
        }
        System.out.println(ans);
    }

    private static void moveShark() {
        map = new Shark[r][c];
        while (!q.isEmpty()) {
            Shark shark = q.poll();
            int x = shark.r;
            int y = shark.c;
            int s = shark.s;
            int d = shark.d;
            int z = shark.z;
            if (d == 0 || d == 2) {
                s %= ((r - 1) * 2);
            } else {
                s %= ((c - 1) * 2);
            }
            for (int k = 0; k < shark.s; k++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    d = (d + 2) % 4;
                    nx = x + dx[d];
                    ny = y + dy[d];
                }
                x = nx;
                y = ny;
            }
            Shark movedShark = new Shark(x, y, s, d, z);
            if (map[x][y] == null) {
                map[x][y] = movedShark;
            } else {
                if (map[x][y].z < movedShark.z) {
                    map[x][y] = movedShark;
                }
            }
        }
    }

    private static void setQ() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != null) {
                    q.add(map[i][j]);
                }
            }
        }
    }

    private static void catchShark(int c) {
        for (int j = 0; j < r; j++) {
            if (map[j][c] != null) {
                ans += map[j][c].z;
                map[j][c] = null;
                break;
            }
        }
    }
}
