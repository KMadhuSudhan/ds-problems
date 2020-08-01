package ds.problems.math;
//https://leetcode.com/problems/2-keys-keyboard/
//650. 2 Keys Keyboard

public class _2KeysKeyboard {
    public int minSteps(int n) {
        int current = 1;
        int copied = 0;
        int steps = 0;
        while(current<n){
            if(n%current==0){
                copied = current;
                steps++;
            }
            current+=copied;
            steps++;
        }
        return steps;
    }
}
