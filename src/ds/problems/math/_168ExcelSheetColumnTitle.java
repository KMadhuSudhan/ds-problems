package ds.problems.math;
//https://leetcode.com/problems/excel-sheet-column-title/
//168. Excel Sheet Column Title

public class _168ExcelSheetColumnTitle {
    public static void main(String[] args) {
        _168ExcelSheetColumnTitle excelSheetColumnTitle = new _168ExcelSheetColumnTitle();
        System.out.println(excelSheetColumnTitle.convertToTitle(701));
    }
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n!=0) {
            int r = n%26;
            if(r == 0) {
                sb.insert(0,'Z');
                n = n/26-1;
            } else {
                sb.insert(0, (char) ('A' + r - 1));
                n /= 26;
            }
        }
        return sb.toString();
    }
}
