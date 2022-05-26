package baekjoon.bfs;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class test18405 {

    static int n, k;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Virus {

        int x, y, num;

        Virus(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        map = new int[n][n];
        PriorityQueue<Virus> pq = new PriorityQueue<>((o1, o2) -> o1.num - o2.num);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    pq.add(new Virus(i, j, map[i][j]));
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int s = parseInt(st.nextToken());
        int endX = parseInt(st.nextToken());
        int endY = parseInt(st.nextToken());
        Queue<Virus> q = new LinkedList<>();
        while (!pq.isEmpty()) {
            q.add(pq.poll());
        }
        while (s-- > 0) {
            int size = q.size();
            while (size-- > 0) {
                Virus virus = q.poll();
                int x = virus.x;
                int y = virus.y;
                int num = virus.num;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] != 0) {
                        continue;
                    }
                    map[nx][ny] = num;
                    q.add(new Virus(nx, ny, num));
                }
            }
        }
        System.out.println(map[endX - 1][endY - 1]);
    }
}
