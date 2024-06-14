package DataStructure.Algorithm.Other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface Trie<V> {
    void put(String key, V val);
    void remove(String key);
    V get(String key);
    boolean containsKey(String key);
    String shortestPrefixOf(String query);
    String longestPrefixOf(String query);
    List<String> keysWithPrefix(String prefix);
    List<String> keysWithPattern(String pattern);
    boolean hasKeyWithPattern(String pattern);
    int size();
}
