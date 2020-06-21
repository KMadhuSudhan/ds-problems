package ds.problems.string;
//https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
//1247. Minimum Swaps to Make Strings Equal

public class _1247MinimumSwapstoMakeStringsEqual {

    public int minimumSwap(String s1, String s2) {
        int xcount=0,ycount=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)=='x'&& s2.charAt(i)=='y'){
                xcount++;
            }
            if(s1.charAt(i)=='y'&& s2.charAt(i)=='x'){
                ycount++;
            }
        }

        int xr=xcount%2;
        int yr=ycount%2;

        int ans=(xcount/2)+(ycount/2);
        if(xr==1 && yr==1){
            ans+=2;
        }
        if(xr==1 && yr==0 || xr==0 && yr==1){
            return -1;
        }
        return ans;
    }
}
