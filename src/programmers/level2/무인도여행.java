package programmers.level2;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 무인도여행 {

    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;

    public List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && maps[i].charAt(j) != 'X') {
                    answer.add(bfs(i, j, maps));
                }
            }
        }
        Collections.sort(answer);
        return answer.size() == 0 ? List.of(-1) : answer;
    }

    public int bfs(int x, int y, String[] maps) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visit[x][y] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();
            x = now.x;
            y = now.y;
            cnt += (maps[x].charAt(y) - '0');
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visit[nx][ny] || maps[nx].charAt(ny) == 'X') {
                    continue;
                }
                visit[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
        return cnt;
    }
}
