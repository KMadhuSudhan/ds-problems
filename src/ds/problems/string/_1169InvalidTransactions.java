package ds.problems.string;
//https://leetcode.com/problems/invalid-transactions/
//1169. Invalid Transactions

import java.util.*;

public class _1169InvalidTransactions {

    public List<String> invalidTransactions(String[] transactions) {
        Map<String,List<Transaction>> transactionMap = new HashMap<>();
        for(String transaction: transactions) {
            String[] strings = transaction.split(",");
            List<Transaction> transactionList = transactionMap.getOrDefault(strings[0],new ArrayList<>());
            transactionList.add(new Transaction(strings[0],
                    strings[3],
                    Integer.parseInt(strings[1]),
                    Integer.parseInt(strings[2]),
                    transaction
            ));
            transactionMap.put(strings[0],transactionList);
        }
        return getInvalidTransactions(transactionMap);
    }

    List<String> getInvalidTransactions(Map<String,List<Transaction>> map) {
        Set<String> ans = new HashSet<>();
        for(Map.Entry<String,List<Transaction>> entry : map.entrySet()) {
            List<Transaction> transactionList = entry.getValue();
            Collections.sort(transactionList, new Comparator<Transaction>() {
                @Override
                public int compare(Transaction o1, Transaction o2) {
                    return o1.time - o2.time;
                }
            });

            for(int i=0;i<transactionList.size();i++) {
                Transaction transaction = transactionList.get(i);
                boolean isValid = true;
                if(transaction.amount > 1000) {
                    ans.add(transaction.str);
                    isValid = false;
                }

                int time = transaction.time;
                int left = i - 1;

                while(isValid && left>=0 && ((time - transactionList.get(left).time) <=60)) {
                    if(!transaction.city.equals(transactionList.get(left).city)) {
                        isValid = true;
                        ans.add(transaction.str);
                    }
                    left--;
                }

                int right = i + 1;

                while(isValid && right <transactionList.size() && ((transactionList.get(right).time - time) <=60)) {
                    if(!transaction.city.equals(transactionList.get(right).city)) {
                        ans.add(transaction.str);
                    }
                    right++;
                }
            }
        }
        return new ArrayList<>(ans);
    }

    class Transaction {
        String str;
        String name;
        String city;
        int time;
        int amount;

        Transaction(String name,String city,int time,int amount,String str) {
            this.name = name;
            this.city = city;
            this.time = time;
            this.amount = amount;
            this.str = str;
        }
    }
}
