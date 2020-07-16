package ds.problems.system.design;

public class _745PrefixAndSuffixSearch {
    Trie preRoot;
    Trie sufRoot;

    public _745PrefixAndSuffixSearch(String[] words) {
        preRoot = new Trie();
        sufRoot = new Trie();
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            Trie n = preRoot;
            for(int j=0; j<word.length(); j++) {
                char c = word.charAt(j);
                if(n.child[c-'a'] == null) {
                    n.child[c-'a'] = new Trie();
                }
                n = n.child[c-'a'];
            }
            n.weight = i;
            n.word = word;

            n = sufRoot;
            for(int j=word.length()-1; j>=0; j--) {
                char c = word.charAt(j);
                if(n.child[c-'a'] == null) {
                    n.child[c-'a'] = new Trie();
                }
                n = n.child[c-'a'];
            }
            n.weight = i;
            n.word = word;
        }

    }

    public int f(String prefix, String suf) {
        String suffix =new StringBuilder(suf).reverse().toString();
        Trie h = preRoot;
        Trie t = sufRoot;
        for(int i=0; i< Math.max(prefix.length(), suffix.length()); i++) {
            if(i<prefix.length()) {
                char c = prefix.charAt(i);
                if(h.child[c-'a']==null) {
                    return -1;
                }
                h = h.child[c-'a'];
            }

            if(i<suffix.length()) {
                char c = suffix.charAt(i);
                if(t.child[c-'a']==null) {
                    return -1;
                }
                t = t.child[c-'a'];
            }
        }
        if(prefix.length()>suffix.length()) {
            return findMaxWeight(h, suf, true);
        } else {
            return findMaxWeight(t, prefix, false);
        }
    }

    private int findMaxWeight(Trie n, String str, boolean isHead) {
        if (n==null) {
            return -1;
        }
        if(n.weight>0) {
            if(isHead) {
                String word = n.word;
                if(word.startsWith(str, word.length()-str.length())) {
                    return n.weight;
                } else {
                    return -1;
                }
            } else {
                if(n.word.startsWith(str)) {
                    return n.weight;
                } else {
                    return -1;
                }
            }
        }
        int maxWeight = n.weight;
        for(int i=0; i<26; i++) {
            maxWeight = Math.max(maxWeight, findMaxWeight(n.child[i],str, isHead));
        }
        return maxWeight;
    }


    class Trie {
        Trie[] child;
        int weight;
        String word;

        public Trie() {
            child = new Trie[26];
            weight = -1;
        }
    }

}
