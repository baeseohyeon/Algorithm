package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test4179 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        boolean[][] visit = new boolean[r][c];
        char[][] map = new char[r][c];
        Queue<Pair> human = new LinkedList<>();
        Queue<Pair> fire = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                char ch = s.charAt(j);
                map[i][j] = ch;
                if (ch == 'J') {
                    human.add(new Pair(i, j));
                    visit[i][j] = true;
                }
                if (ch == 'F')
                    fire.add(new Pair(i, j));
            }
        }
        int cnt = 0;
        boolean flag = false;
        while (!human.isEmpty()) {
            cnt++;
            int f = fire.size();
            while (f-- > 0) {
                Pair nowFire = fire.poll();
                int x = nowFire.x;
                int y = nowFire.y;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == '#' || map[nx][ny] == 'F')
                        continue;
                    map[nx][ny] = 'F';
                    fire.add(new Pair(nx, ny));
                }
            }
            int h = human.size();
            while (h-- > 0) {
                Pair nowHuman = human.poll();
                int x = nowHuman.x;
                int y = nowHuman.y;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        flag = true;
                        continue;
                    }
                    if (map[nx][ny] == '.' && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        human.add(new Pair(nx, ny));
                    }
                }
            }
            if (flag)
                break;
        }
        if (flag)
            System.out.println(cnt);
        else
            System.out.println("IMPOSSIBLE");

    }
}
