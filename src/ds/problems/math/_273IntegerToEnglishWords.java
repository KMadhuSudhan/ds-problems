package ds.problems.math;
//https://leetcode.com/problems/integer-to-english-words/
//273. Integer to English Words

public class _273IntegerToEnglishWords {

    private static final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen",  "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TEN_MULTIPLES = { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num==0) {
            return "Zero";
        }

        return numberToWordsHelper(num).toString().trim();
    }

    public String numberToWordsHelper(int num) {
        if (num==0) {
            return "";
        }
        StringBuilder res = new StringBuilder();

        if(num >= 1000000000) {
            res.append(numberToWordsHelper(num/1000000000)).append(" Billion ").append(numberToWordsHelper(num%1000000000));
        } else if(num >= 1000000) {
            res.append(numberToWordsHelper(num/1000000)).append(" Million ").append(numberToWordsHelper(num%1000000));
        } else if(num >= 1000) {
            res.append(numberToWordsHelper(num/1000)).append(" Thousand ").append(numberToWordsHelper(num%1000));
        } else if(num >= 100) {
            res.append(numberToWordsHelper(num/100)).append(" Hundred ").append(numberToWordsHelper(num%100));
        } else if(num >= 20) {
            res.append(TEN_MULTIPLES[(num-20)/10]).append(" ").append(numberToWordsHelper(num%10));
        } else {
            res.append(LESS_THAN_TWENTY[num]);
        }

        return res.toString().trim();
    }
}
