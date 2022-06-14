package baekjoon.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test2608 {

    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int num = getNum(s1) + getNum(s2);
        System.out.println(num);
        String s = "";
        for (int i = 0; i < num / 1000; i++) {
            s += "M";
        }
        num %= 1000;
        while (num >= 100) {
            if (num >= 900) {
                s += "CM";
                num -= 900;
            }
            if (num >= 500) {
                s += "D";
                num -= 500;
            }
            if (num >= 400) {
                s += "CD";
                num -= 400;
            }
            if (num >= 100) {
                s += "C";
                num -= 100;
            }
        }
        while (num >= 10) {
            if (num >= 90) {
                s += "XC";
                num -= 90;
            }
            if (num >= 50) {
                s += "L";
                num -= 50;
            }
            if (num >= 40) {
                s += "XL";
                num -= 40;
            }
            if (num >= 10) {
                s += "X";
                num -= 10;
            }
        }
        while (num > 0) {
            if (num >= 9) {
                s += "IX";
                num -= 9;
            }
            if (num >= 5) {
                s += "V";
                num -= 5;
            }
            if (num >= 4) {
                s += "IV";
                num -= 4;
            }
            if (num >= 1) {
                s += "I";
                num -= 1;
            }
        }
        System.out.println(s);
    }

    private static int getNum(String s1) {
        int num = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (i + 1 < s1.length()) {
                char c2 = s1.charAt(i + 1);
                if (map.get(c) < map.get(c2)) {
                    num += map.get(c2) - map.get(c);
                    i++;
                    continue;
                }
            }
            num += map.get(c);
        }
        return num;
    }
}
