
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // 前缀树 + 滑动窗口
        int len = words[0].length(), sLen = s.length();
        Trie t = new Trie();
        Map<String, Integer> map = new HashMap<>();
        int[] f = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int inx = i;
            if (map.containsKey(words[i])) {
                inx = map.get(words[i]);
            } else {
                map.put(words[i], i);
            }
            f[inx]++;
            t.insert(words[i], inx);
        }
        List<List<Pair<Integer, Integer>>> lists = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i <= sLen - len; i++) {
            int search = t.search(s, i, len);
            if (search != -1) {
                Pair<Integer, Integer> pair = new Pair<>(i, search);
                lists.get(i % len).add(pair);
            }
        }
        List<Integer> list = new ArrayList<>();
        lists.forEach(window -> window(window, list, f, len));
        return list;
    }

    private void window(List<Pair<Integer, Integer>> window, List<Integer> list, int[] f_, int size) {
        int[] f = Arrays.copyOf(f_, f_.length);
        int len = f_.length;
        int l = 0, r = 0;
        while (r < window.size()) {
            if (r > 0 && (window.get(r).getKey() - size > window.get(r - 1).getKey())) {
                f = Arrays.copyOf(f_, f_.length);
                l = r;
            }
            if (f[window.get(r).getValue()] <= 0) {
                f[window.get(l).getValue()]++;
                l++;
            } else {
                f[window.get(r).getValue()]--;
                r++;
                if (r - l == len) {
                    list.add(window.get(l).getKey());
                }
            }
        }
    }
}

class Trie {
    private Trie[] children;
    private int isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = -1;
    }

    public void insert(String word, int f) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = f;
    }

    public int search(String word, int sta, int len) {
        Trie node = searchPrefix(word, sta, len);
        return node != null ? node.isEnd : -1;
    }

    private Trie searchPrefix(String prefix, int sta, int len) {
        Trie node = this;
        for (int i = sta; i < sta + len; i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (!key.equals(pair.key)) return false;
        return value.equals(pair.value);
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
