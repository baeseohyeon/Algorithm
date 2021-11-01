package baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test14226 {
    static int MAX = 1000;

    static class Emotion {
        int now, clipboard, time;

        Emotion(int now, int clipboard, int time) {
            this.now = now;
            this.clipboard = clipboard;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        boolean[][] visit = new boolean[MAX + 1][MAX + 1];
        Queue<Emotion> q = new LinkedList<>();
        q.add(new Emotion(1, 0, 0));
        visit[1][0] = true;
        while (!q.isEmpty()) {
            Emotion emotion = q.poll();
            int now = emotion.now;
            int clipboard = emotion.clipboard;
            int time = emotion.time;
            if (now == s) {
                System.out.println(time);
                break;
            }
            if (!visit[now][now]) {
                visit[now][now] = true;
                q.add(new Emotion(now, now, time + 1));
            }
            if (now + clipboard <= MAX && !visit[now + clipboard][clipboard]) {
                visit[now + clipboard][clipboard] = true;
                q.add(new Emotion(now + clipboard, clipboard, time + 1));
            }
            if (now - 1 >= 0 && !visit[now - 1][clipboard]) {
                visit[now - 1][clipboard] = true;
                q.add(new Emotion(now - 1, clipboard, time + 1));
            }
        }
    }
}
