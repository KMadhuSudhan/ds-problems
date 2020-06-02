package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/lemonade-change/
//860. Lemonade Change

public class _860LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[3];
        for(int i=0;i<bills.length;i++) {
            switch(bills[i]) {
                case 5:
                    change[0]++;
                    break;
                case 10:
                    change[1]++;
                    if(change[0] > 0){
                        change[0]--;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    change[2]++;
                    if(change[1] > 0 && change[0] > 0){
                        change[1]--;
                        change[0]--;
                    } else if(change[0] > 2) {
                        change[0] = change[0] -3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
