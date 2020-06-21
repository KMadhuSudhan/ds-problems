package ds.problems.math;
//https://leetcode.com/problems/rabbits-in-forest/
//781. Rabbits in Forest

public class _781RabbitsinForest {

    public int numRabbits(int[] answers) {
        int res = 0;
        int[] map = new int[1000];
        for (int ans : answers) {
            map[ans]++;
        }
        int cnt;
        for (int i = 0; i < 1000; i++) {
            int key = i;
            int value = map[i];
            if (value > 0) {
                if (i == 0) {
                    cnt = value;
                } else {
                    cnt = key+1;

                }
                res += cnt;
            }
        }
        return res;
    }
/*
    public int numRabbits(int[] answers) {
        int res = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int ans : answers) {
            hm.put(ans, hm.getOrDefault(ans, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            int cnt;
            if (key == 0) {
                cnt = val;
            } else {
                cnt = Math.max(key + 1, (int) Math.ceil((double) val / (key + 1)) * (key+1));
            }
            res += cnt;
        }

        return res;
    }
    */

/*
public int numRabbits(int[] answers) {
        if (answers.length == 0) return 0;

        Arrays.sort(answers);

        int toBeSkipped = answers[0];
        int result = answers[0] + 1;
        for (int i = 1; i < answers.length; i++) {
            if (answers[i] == answers[i - 1] && toBeSkipped > 0) {
                toBeSkipped--;
            } else {
                toBeSkipped = answers[i];
                result += answers[i] + 1;
            }
        }

        return result;
    }
 */

}
