package programmers.level3;

import static java.lang.Integer.MAX_VALUE;

public class 외벽점검 {

    static int answer;
    static int[] sum, distance;
    static boolean[] checkDist;

    public static void main(String[] args) {
        //weak : 결함 위치, dist : 작업자 이동가능 거리
//        System.out.println(solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4}));
        System.out.println(solution(200, new int[]{0, 100, 150}, new int[]{1, 1}));
    }

    public static int solution(int n, int[] weak, int[] dist) {
        answer = MAX_VALUE;
        checkDist = new boolean[dist.length];
        distance = dist;
        for (int i = 0; i < weak.length; i++) {
            sum = new int[weak.length];
            for (int j = i, idx = 0; idx < weak.length; j++) {
                if (weak[j % weak.length] == weak[weak.length - 1]) {
                    sum[idx++] = n - weak[j % weak.length] + weak[0];
                    continue;
                }
                sum[idx++] = weak[(j + 1) % weak.length] - weak[j % weak.length];
            }
            dfs(0, 0, 0);
        }

        return answer == MAX_VALUE ? -1 : answer;
    }

    private static void dfs(int people, int dist, int sumIdx) {
        if (sumIdx == sum.length) {
            answer = Math.min(answer, people);
            return;
        }
        int len = sum[sumIdx];
        if (len <= dist) {
            dfs(people, dist - len, sumIdx + 1);
        } else { //한번더 이동 못하면
            for (int i = 0; i < checkDist.length; i++) {
                if (!checkDist[i]) {
                    checkDist[i] = true;
                    dfs(people + 1, distance[i], sumIdx + 1);
                    checkDist[i] = false;
                }
            }
        }
    }
}