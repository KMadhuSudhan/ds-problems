package ds.problems.array;
//https://leetcode.com/problems/gas-station/
//134. Gas Station

public class _134GasStation {
    public static void main(String[] args) {
        _134GasStation gasStation = new _134GasStation();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.print(gasStation.canCompleteCircuit(gas,cost));
    }
    public int canCompleteCircuitBruteForce(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++) {
            if(gas[i] < cost[i]) continue;
            if(helper(i,gas,cost)) {
                return i;
            }
        }
        return -1;
    }
    boolean helper(int current,int[] gas,int[] cost) {
        int sum = gas[current];
        int prevCost = cost[current];
        for(int i=current+1;i<2*gas.length;i++){
            if(i == current) return true;
            sum = sum - prevCost + gas[i%gas.length];
            prevCost = cost[i%gas.length];
            if(sum<=0 || sum < prevCost) return false;
        }
        return true;
    }

    //without bootforce
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int diff = 0;
        int sum = 0;
        for(int i=0;i<gas.length;i++) {
            sum+= gas[i] - cost[i];
            if(sum<0) {
                start=i+1;
                diff+=sum;
                sum = 0;
            }
        }
        return sum+diff>=0 ? start : -1;
    }
}
