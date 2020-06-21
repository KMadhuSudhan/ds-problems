package ds.problems.system.design;
//https://leetcode.com/problems/lru-cache/
//146. LRU Cache

import java.util.LinkedHashMap;
import java.util.Map;

public class _146LRUCache {

    Map<Integer,Integer> cache;
    int N;
    public _146LRUCache(int capacity) {
        this.cache = new LinkedHashMap<Integer,Integer>();
        this.N = capacity;
    }

    public int get(int key) {
        if(this.cache.containsKey(key)) {
            int val = this.cache.get(key);
            this.cache.remove(key);
            this.cache.put(key,val);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(this.cache.containsKey(key)) {
            this.cache.remove(key);
        }
        if(this.cache.size() == this.N) {
            Integer firstKey = this.cache.keySet().iterator().next();
            this.cache.remove(firstKey);
        }
        this.cache.put(key,value);
    }
}
