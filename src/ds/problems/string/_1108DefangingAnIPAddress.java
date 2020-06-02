package ds.problems.string;
//https://leetcode.com/problems/defanging-an-ip-address/
//1108. Defanging an IP Address

public class _1108DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        return  address.replace(".","[.]");
    }
}
