package baekjoon.greedy;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://hee96-story.tistory.com/96 참고
public class test1781 {

    static class Homework {

        int ramen, deadline;

        Homework(int ramen, int deadline) {
            this.ramen = ramen;
            this.deadline = deadline;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        Homework[] homeworks = new Homework[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            homeworks[i] = new Homework(parseInt(s[1]), parseInt(s[0]));
        }
        Arrays.sort(homeworks, new Comparator<Homework>() {
            @Override
            public int compare(Homework o1, Homework o2) {
                return o1.deadline - o2.deadline;
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            Homework homework = homeworks[i];
            pq.add(homework.ramen);
            while (!pq.isEmpty() && pq.size() > homework.deadline) {
                pq.poll();
            }
        }
        long ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        System.out.println(ans);
    }

}
