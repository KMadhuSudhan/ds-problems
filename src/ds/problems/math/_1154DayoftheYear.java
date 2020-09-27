package ds.problems.math;
//https://leetcode.com/problems/day-of-the-year/
//1154. Day of the Year

public class _1154DayoftheYear {

    public int dayOfYear(String date) {
        String[] str = date.split("-");
        int year = Integer.valueOf(str[0]);
        int month = Integer.valueOf(str[1]);
        int day = Integer.valueOf(str[2]);
        int febDays = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? 29 : 28;
        int[] monthDays = new int[]{0, 31, febDays, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = day;
        for (int i = 1; i < month; i++) {
            days += monthDays[i];
        }
        return days;
    }
}
