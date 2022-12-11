package baekjoon.recursion;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test17478 {

    static int n;
    static String line;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = "____";
        sb = new StringBuilder("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        n = parseInt(br.readLine());
        solve(0);
        System.out.println(sb);
    }

    public static void solve(int now) {
        if (now > n) {
            return;
        }
        StringBuilder line = createLine(now);
        sb.append(line).append("\"재귀함수가 뭔가요?\"").append("\n");
        if (now == n) {
            sb.append(line).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
        } else {
            sb.append(line).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");
            sb.append(line).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");
            sb.append(line).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");
        }
        solve(now + 1);
        sb.append(line).append("라고 답변하였지.").append("\n");
    }

    private static StringBuilder createLine(int now) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(String.valueOf(line).repeat(Math.max(0, now)));
        return tmp;
    }
}