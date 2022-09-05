package programmers.level3;

import static java.lang.Integer.MAX_VALUE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 등산코스 {

    static int minIntensity = MAX_VALUE, destination = 50000;
    static boolean[] visit, isSummit, isGate;
    static int[] parent;
    static List<Node>[] nodes;

    static class Node {

        int next, intensity;

        Node(int next, int intensity) {
            this.next = next;
            this.intensity = intensity;
        }
    }

    public static void main(String[] args) {
        int[] ans = solution(7,
            new int[][]{{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}},
            new int[]{1},
            new int[]{2, 3, 4});
    }

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        visit = new boolean[n + 1];
        isGate = new boolean[n + 1];
        isSummit = new boolean[n + 1];
        parent = new int[n + 1];
        nodes = new ArrayList[n + 1];
        setFlagArr(isGate, gates);
        setFlagArr(isSummit, summits);
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            nodes[i] = new ArrayList<>();
        }
        Arrays.sort(paths, Comparator.comparingInt(o -> o[2]));

        int cnt = 1;
        for (int i = 0; i < paths.length && cnt < n; i++) {
            int a = paths[i][0];
            int b = paths[i][1];
            int c = paths[i][2];
            int aParent = find(a);
            int bParent = find(b);
            if (aParent == bParent) {
                continue;
            }
            cnt++;
            merge(aParent, bParent);
            nodes[a].add(new Node(b, c));
            nodes[b].add(new Node(a, c));
        }

        for (int i = 0; i < gates.length; i++) {
            int now = gates[i];
            visit[now] = true;
            dfs(now, 0);
            visit[now] = false;
        }

        return new int[]{destination, minIntensity};
    }

    private static void dfs(int now, int maxIntensity) {
        if (isSummit[now]) {
            if (minIntensity >= maxIntensity) {
                if (minIntensity == maxIntensity) {
                    destination = Math.min(destination, now);
                } else {
                    destination = now;
                }
                minIntensity = maxIntensity;
            }
            return;
        }
        for (Node node : nodes[now]) {
            int next = node.next;
            int intensity = node.intensity;
            if (!visit[next] && !isGate[next]) {
                visit[next] = true;
                dfs(next, Math.max(maxIntensity, intensity));
                visit[next] = false;
            }
        }
    }

    private static void setFlagArr(boolean[] flagArr, int[] arr) {
        for (int i : arr) {
            flagArr[i] = true;
        }
    }

    private static void merge(int aParent, int bParent) {
        if (aParent <= bParent) {
            parent[bParent] = aParent;
        } else {
            parent[aParent] = bParent;
        }
    }

    private static int find(int now) {
        if (parent[now] == now) {
            return now;
        }
        return parent[now] = find(parent[now]);
    }
}
