package ds.problems.string;
//https://leetcode.com/problems/robot-return-to-origin/
//657. Robot Return to Origin

public class _657RobotReturntoOrigin {

    public boolean judgeCircle(String s) {
        int lr = 0;
        int ud = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'L') {
                lr--;
            } else if(s.charAt(i) == 'R') {
                lr++;
            } else if(s.charAt(i) == 'U') {
                ud++;
            } else if(s.charAt(i) == 'D') {
                ud--;
            }
        }
        return ud == 0 && lr == 0;
    }
}
