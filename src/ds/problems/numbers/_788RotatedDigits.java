package ds.problems.numbers;
//https://leetcode.com/problems/rotated-digits/
//788. Rotated Digits

import java.util.HashMap;
import java.util.Map;

public class _788RotatedDigits {

    public int rotatedDigits(int N) {
        Map<Integer, Integer> flipMap = new HashMap(){
            {
                put(0,0);
                put(1,1);
                put(2,5);
                put(3,-1);
                put(4,-1);
                put(5,2);
                put(6,9);
                put(7,-1);
                put(8,8);
                put(9,6);
            }
        };

        int countGoodNumbers = 0;
        for(int i = 1; i <= N; i++){
            int rotatedNumber = isGoodNumber(i, flipMap);
            if(rotatedNumber != 0 && rotatedNumber != i){
                countGoodNumbers++;
            }
        }
        return countGoodNumbers;
    }

    int isGoodNumber(int num, Map<Integer, Integer> flipMap) {
        int multiplier = 1;
        int rotatedNumber = 0;
        while(num > 0){
            int digit = num % 10;
            //if the number contains digit that is unflipable, return 0;
            if(flipMap.get(digit) == -1){
                return 0;
            }
            rotatedNumber += flipMap.get(digit) * multiplier;
            multiplier *= 10;
            num /= 10;
        }
        return rotatedNumber;
    }
}
