package main.java.fung.model;

import java.util.ArrayList;

public class MyMap<K, V> {
    private ArrayList<K> myKeyList;
    private ArrayList<V> myValueList;
    private ArrayList<Entry<K, V>> myEntryList;

    static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

    }

    public MyMap() {
        this.myKeyList = new ArrayList<>();
        this.myValueList = new ArrayList<>();
        this.myEntryList = new ArrayList<>();
    }
}
