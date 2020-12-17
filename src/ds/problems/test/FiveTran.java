package ds.problems.test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FiveTran {


    /*
     * Complete the 'countCounterfeit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY serialNumber as parameter.
     */
    static Set<Integer> set = new HashSet<>();

    static {
        set.add(10);
        set.add(20);
        set.add(50);
        set.add(100);
        set.add(200);
        set.add(500);
        set.add(1000);
    }

    public static int countCounterfeit(List<String> serialNumber) {
        // Write your code here
        int total = 0;
        for (String sno : serialNumber) {

            int num = getAmount(sno);
            if (num == 0) {
                System.out.println("sno:" + sno);
            }
            total += num;
        }
        return total;
    }

    static int getAmount(String str) {
        char[] chars = str.toCharArray();
        if (chars.length < 10) return 0;
        if (!isSameCase(chars[0], chars[1], chars[2])) return 0;
        System.out.println("isSameCase");
        if (!isValidYear(chars[3], chars[4], chars[5], chars[6])) return 0;
        System.out.println("isValidYear");
        if (!isUpperCase(chars[chars.length - 1])) return 0;
        System.out.println("isUpperCase");
        int num = getDenamination(chars, 7, chars.length - 2);
        System.out.println("num: {}" + num);
        return num;
    }

    static int getDenamination(char[] chars, int start, int end) {
        int num = 0;
        try {
            while (start <= end) {
                num = num*10 + Character.getNumericValue(chars[start]);
                start++;
            }
            if (set.contains(num)) {
                return num;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    static boolean isValidYear(char ch1, char ch2, char ch3, char ch4) {
        try {
            int year = (Character.getNumericValue(ch1) * 1000) + (Character.getNumericValue(ch2) * 100) + (Character.getNumericValue(ch3) * 10) + (Character.getNumericValue(ch4));
            return year >= 1900 && year <= 2019;
        } catch (Exception e) {
            return false;
        }
    }

    static boolean isSameCase(char ch1, char ch2, char ch3) {
        if (!isUpperCase(ch1)) return false;
        if (!isUpperCase(ch2)) return false;
        if (!isUpperCase(ch3)) return false;
        return (ch1 != ch2 && ch2 != ch3 && ch1 != ch3);
    }

    static boolean isUpperCase(char ch) {
        return ch >= 65 && ch <= 90;
    }

    static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("RED190250E");
        FiveTran.countCounterfeit(list);
    }
}
