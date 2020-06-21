package ds.problems.string;
//https://leetcode.com/problems/masking-personal-information/
//831. Masking Personal Information

public class _831MaskingPersonalInformation {
    public static void main(String[] args) {
        _831MaskingPersonalInformation maskingPersonalInformation =  new _831MaskingPersonalInformation();
        System.out.println(maskingPersonalInformation.maskPII("1(234)567-890"));
    }
    public String maskPII(String S) {
        char[] info = S.toCharArray();
        int[] digitsCount = digitsCount(info);
        boolean isEmail = digitsCount[1] != info.length;
        if (isEmail) {
            return maskEmail(info);
        } else {
            return maskPhoneNumber(info,digitsCount[0]);
        }
    }

    String maskEmail(char[] info) {
        StringBuilder sb = new StringBuilder();
        sb.append(toLowerCase(info[0]));
        int i=1;
        while (i + 1 < info.length && info[i + 1] != '@') {
            if (i <= 5) sb.append('*');
            i++;
        }
        int j = i;
        while (j <= 5) {
            sb.append('*');
            j++;
        }
        while (i < info.length) {
            sb.append(toLowerCase(info[i]));
            i++;
        }
        return sb.toString();
    }

    String maskPhoneNumber(char[] info,int noOfDigits) {
        StringBuilder sb = new StringBuilder();
        int i = info.length-1,lastDigits = 0;
        while(lastDigits<4) {
            if(info[i]>='0' && info[i]<= '9') {
                lastDigits++;
                sb.insert(0, info[i]);
            }
            i--;
        }
        sb.insert(0,'-');
        sb.insert(0,'*');sb.insert(0,'*');sb.insert(0,'*');
        sb.insert(0,'-');
        sb.insert(0,'*');sb.insert(0,'*');sb.insert(0,'*');
        if(noOfDigits>10) {
            sb.insert(0,'-');
            sb.insert(0,'*');
            if(noOfDigits > 11) {
                sb.insert(0, '*');
            }
            if(noOfDigits>12) {
                sb.insert(0,'*');
            }
            sb.insert(0,'+');
        }
        return sb.toString();
    }

    int[] digitsCount(char[] info) {
        int i = 0,digits = 0;
        while(i<info.length && info[i] != '@') {
            if(info[i] >= '0' && info[i] <= '9') {
                digits++;
            }
            i++;
        }
        return new int[]{digits,i};
    }

    char toLowerCase(char character) {
        return (character>=65 && character<=90) ? (char) (character  + 32) : character;
    }
}
