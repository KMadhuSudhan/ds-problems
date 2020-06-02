package ds.problems.string;
//https://leetcode.com/problems/unique-email-addresses/
//929. Unique Email Addresses

import java.util.HashSet;
import java.util.Set;

public class _929UniqueEmailAddresses {
    public static void main(String[] args) {
        _929UniqueEmailAddresses uniqueEmailAddresses = new _929UniqueEmailAddresses();
        String[] emails = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        };
        System.out.println(uniqueEmailAddresses.numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> ans = new HashSet();
        for (String str : emails) {
            char[] chars = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            boolean atTheRateAppeared = false;
            int i = 0;
            while (i < chars.length) {
                if (atTheRateAppeared == false && chars[i] == '+') {
                    while (chars[i] != '@') {
                        i++;
                    }
                }
                if (atTheRateAppeared == false && chars[i] == '.') {
                    i++;
                    continue;
                }
                if (chars[i] == '@') {
                    atTheRateAppeared = true;
                }
                sb.append(chars[i]);
                i++;
            }
            ans.add(sb.toString());
        }
        return ans.size();
    }
}
