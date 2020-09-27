package ds.problems.string;
//https://leetcode.com/problems/reorder-data-in-log-files/
//937. Reorder Data in Log Files

import java.util.Arrays;
import java.util.Comparator;

public class _937ReorderDataInLogFile {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>()
        {
            public int compare(String log1, String log2)
            {
                String[] split1 = log1.split(" ",2);
                String[] split2 = log2.split(" ",2);

                boolean isDig1 = Character.isDigit(split1[1].charAt(0));
                boolean isDig2 = Character.isDigit(split2[1].charAt(0));



                //case2
                if(!isDig1 && !isDig2)
                {
                    int cmp= split1[1].compareTo(split2[1]);
                    if(cmp!=0)
                    {
                        return cmp;
                    }
                    return split1[0].compareTo(split2[0]);
                }

                //case3
                if(!isDig1 && isDig2)
                {
                    return -1;
                }

                else if(isDig1 && !isDig2)
                {
                    return 1;
                }
                //case1
                else
                {
                    return 0;
                }

            }
        };

        Arrays.sort(logs, comp);
        return logs;
    }
}
