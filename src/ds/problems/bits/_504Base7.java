package ds.problems.bits;
//https://leetcode.com/problems/base-7/
//504. Base 7

public class _504Base7 {
    public String convertToBase7(int num) {
        int flag = 0 ;
        if( num<0)
        {
            flag =1;
            num=-num;
        }
        StringBuffer ans=new StringBuffer() ;
        while ( num > 6 )
        {
            ans.append( Integer.toString(num%7) );
            num=num/7;
        }
        ans.append(Integer.toString(num));
        if(flag==1)
            ans.append("-");
        return ans.reverse().toString();
    }
}
