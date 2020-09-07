package ds.problems.stack;
//https://leetcode.com/problems/mini-parser/
//385. Mini Parser

import java.util.List;

public class _385MiniParser {


      public interface NestedInteger {
          // Constructor initializes an empty nested list.
//          public NestedInteger();

          // Constructor initializes a single integer.
//          public NestedInteger(int value);

          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger();

          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger();

          // Set this NestedInteger to hold a single integer.
          public void setInteger(int value);

          // Set this NestedInteger to hold a nested list and adds a nested integer to it.
          public void add(NestedInteger ni);
          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return null if this NestedInteger holds a single integer
          public List<NestedInteger> getList();
      }


//    private boolean isDigit(char ch) {
//        return ch >= '0' && ch <= '9';
//    }
//
//    public NestedInteger deserialize(String s) {
//        if (!s.startsWith("[")) {
//            return new NestedInteger(Integer.valueOf(s));
//        }
//
//        Stack<NestedInteger> stk = new Stack<>();
//
//        char[] chs = s.toCharArray();
//        int ret = 0;
//        int sign = 1;
//        NestedInteger ni;
//        for (int i = 0; i < chs.length; i++) {
//            switch (chs[i]) {
//                case '[':
//                    ni = new NestedInteger();
//                    if (stk.size() > 0) {
//                        stk.peek().add(ni);
//                    }
//                    stk.push(ni);
//                    break;
//                case ']':
//                    ni = stk.pop();
//                    if (isDigit(chs[i-1])) {
//                        ni.add(new NestedInteger(ret * sign));
//                        sign = 1;
//                        ret = 0;
//                    }
//                    if (i == chs.length-1) {
//                        return ni;
//                    }
//                    break;
//                case '-':
//                    sign = -1;
//                    break;
//                case ',':
//                    if (isDigit(chs[i-1])) {
//                        stk.peek().add(new NestedInteger(ret * sign));
//                        sign = 1;
//                        ret = 0;
//                    }
//                    break;
//                default:
//                    ret = ret * 10 + (int) (chs[i]-'0');
//            }
//        }
//
//        return null;
//    }
}
