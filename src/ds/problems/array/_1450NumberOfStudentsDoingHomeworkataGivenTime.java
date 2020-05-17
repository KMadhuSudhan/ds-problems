package ds.problems.array;

public class _1450NumberOfStudentsDoingHomeworkataGivenTime {
    public static void main(String[] args) {
        int[] startTime = {1, 2, 3};
        int[] endTime = {3, 2, 7};
        _1450NumberOfStudentsDoingHomeworkataGivenTime numberOfStudentsDoingHomeworkataGivenTime = new _1450NumberOfStudentsDoingHomeworkataGivenTime();
        numberOfStudentsDoingHomeworkataGivenTime.busyStudent(startTime, endTime, 4);
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                count++;
            }
        }
        return count;
    }
}
