package baekjoon.sort;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class test10800 { //https://mygumi.tistory.com/273

    static class Ball {

        int id, color, size;

        Ball(int id, int color, int size) {
            this.id = id;
            this.color = color;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = parseInt(br.readLine());
        List<Ball> balls = new ArrayList<>();
        int[] ans = new int[n + 1];
        int[] sizes = new int[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            balls.add(new Ball(i, a, b));
        }
        Collections.sort(balls, new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                if (o1.size == o2.size) {
                    return o1.color - o2.color;
                }
                return o1.size - o2.size;
            }
        });
        int sum = 0;
        for (int i = 0, j = 0; i < n; i++) {
            Ball a = balls.get(i);
            Ball b = balls.get(j);
            while (b.size < a.size) {
                sum += b.size;
                sizes[b.color] += b.size;
                b = balls.get(++j);
            }
            ans[a.id] = sum - sizes[a.color];
        }
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
