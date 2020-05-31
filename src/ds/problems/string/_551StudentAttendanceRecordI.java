package ds.problems.string;
//https://leetcode.com/problems/student-attendance-record-i/
//551. Student Attendance Record I

public class _551StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        int aCount = 0,i=0;
        char[] chars = s.toCharArray();
        while(i<chars.length) {
            if(chars[i] == 'A') {
                aCount++;
            }
            if(chars[i] == 'L') {
                if(i+2 < chars.length && chars[i+1] == 'L' && chars[i+2] == 'L') {
                    return false;
                }
            }
            i++;
        }
        if(aCount>1) return false;
        return true;
    }
}
