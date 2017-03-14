package com.keirnellyer.glencaldy.repository;

import java.util.List;

public interface Repository<K, V> {

    List<V> getAll();
    V get(K key);
    void add(V value);

}
