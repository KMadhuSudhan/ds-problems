package ds.problems.string;
//https://leetcode.com/problems/license-key-formatting/
//482. License Key Formatting

public class _482LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuffer str = new StringBuffer("");
        int pointer=0;
        char[] ch = S.toCharArray();
        for(int i=ch.length-1;i>=0;i--)
        {
            if(ch[i]!='-')
            {
                pointer++;
                str.append(Character.toUpperCase(ch[i]));
                if(i!=0 && pointer==K)
                {
                    str.append("-");
                    pointer=0;
                }
            }
        }
        if(str.length()==0)
        {
            return "";
        }
        if(str.charAt(0)=='-')
        {
            str.deleteCharAt(0);
        }
        if(str.charAt(str.length()-1)=='-')
        {
            str.deleteCharAt(str.length()-1);
        }
        str.reverse();
        return str.toString();
    }
}
