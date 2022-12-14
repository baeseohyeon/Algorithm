package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Test3613 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s.charAt(0) == '_' || s.charAt(s.length() - 1) == '_') {
            System.out.println("Error!");
            return;
        }
        String[] str = s.split("_");
        if (str.length > 1) {
            System.out.println(changeCToJava(str));
            return;
        }
        System.out.println(changeJavaToC(str));
    }

    private static String changeJavaToC(String[] s) {
        if (isUpperCase(s[0].charAt(0))) {
            return "Error!";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < s[0].length(); i++) {
            char c = s[0].charAt(i);
            if (isUpperCase(c)) {
                sb.append(tmp).append("_");
                tmp = new StringBuilder().append((char) (c + 32));
                continue;
            }
            tmp.append(c);
        }
        return sb.append(tmp).toString();
    }

    private static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static String changeCToJava(String[] s) {
        if (!Pattern.matches("[a-z]*", s[0])) {
            return "Error!";
        }
        StringBuilder sb = new StringBuilder(s[0]);
        for (int i = 1; i < s.length; i++) {
            if (!Pattern.matches("[a-z]*", s[i]) || s[i].isEmpty()) {
                return "Error!";
            }
            sb.append((char) (s[i].charAt(0) - 32)).append(s[i].substring(1));
        }
        return sb.toString();
    }
}
