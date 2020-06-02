package ds.problems.math;
//https://leetcode.com/problems/angle-between-hands-of-a-clock/
//1344. Angle Between Hands of a Clock

public class _1344AngleBetweenHandsofaClock {
    public static void main(String[] args) {
        _1344AngleBetweenHandsofaClock angleBetweenHandsofaClock = new _1344AngleBetweenHandsofaClock();
        angleBetweenHandsofaClock.angleClock(12,30);
    }
    public double angleClock(int hour, int minutes) {
        //int hourHand = (360/12)*hour + (minutes/60) * (360/12);
        //int minHand = (360/60)*minutes;
        double hAngle = ((double)hour%12.0) * 30.00;
        hAngle += (((double)minutes/60.0) * 30.00);

        double mAngle = 6.0 * (double)minutes;

        return Math.min(Math.abs(hAngle - mAngle), 360.0 - Math.abs(mAngle - hAngle));
    }
}
