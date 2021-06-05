package com.algod.test.lru;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LRUCacheCustom<K, V> {
    private final int maxSize;
    private final Map<K, V> map = new HashMap<>();
    private final Deque<K> queue = new ArrayDeque<>();

    public LRUCacheCustom(int maxSize) {
        this.maxSize = maxSize;
    }

    public void put(K key, V val) {
        if (!map.containsKey(key)) {
            if (map.size() == maxSize) {
                K last = queue.removeLast();
                map.remove(last);
            }
        }
        map.put(key, val);
        queue.remove(key);
        queue.offerFirst(key);
    }

    public V get(K key) {
        V val = map.get(key);
        if (val != null) {
            queue.remove(key);
            queue.offerFirst(key);
        }
        return val;
    }
}
