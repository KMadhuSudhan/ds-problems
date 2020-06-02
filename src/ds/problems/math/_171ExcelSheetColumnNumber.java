package ds.problems.math;

//https://leetcode.com/problems/excel-sheet-column-number/
//171. Excel Sheet Column Number

public class _171ExcelSheetColumnNumber {
    public static void main(String[] args) {
        _171ExcelSheetColumnNumber excelSheetColumnNumber = new _171ExcelSheetColumnNumber();
        System.out.println(excelSheetColumnNumber.titleToNumber("ZY"));
    }

    public int titleToNumber(String s) {
        char[] characters = s.toCharArray();
        int result = 0;
        for(int i=0;i<characters.length;++i){
            result = result*26 + (int)(characters[i] -'A') +1;
        }
        return result;
    }
}
