package baekjoon.dfs;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test2310 {

    static int n;
    static String ans;
    static boolean[] visit;
    static Room[] rooms;

    static class Room {

        String monster;
        int money;
        List<Integer> doors = new ArrayList<>();

        Room(String monster, int money) {
            this.monster = monster;
            this.money = money;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        while ((n = parseInt(br.readLine())) != 0) {
            visit = new boolean[n + 1];
            rooms = new Room[n + 1];
            ans = "No";
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String monster = st.nextToken();
                int money = parseInt(st.nextToken());
                Room room = new Room(monster, money);
                while (st.hasMoreTokens()) {
                    int num = parseInt(st.nextToken());
                    if (num != 0) {
                        room.doors.add(num);
                    }
                }
                rooms[i] = room;
            }
            dfs(1, 0);
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int now, int money) {
        Room room = rooms[now];
        if (room.monster.equals("L")) {
            money = Math.max(money, room.money);
        }
        if (room.monster.equals("T")) {
            money -= room.money;
            if (money < 0) {
                return;
            }
        }
        if (now == n) {
            ans = "Yes";
        }
        visit[now] = true;
        for (int next : room.doors) {
            if (!visit[next]) {
                dfs(next, money);
            }
        }
    }
}
