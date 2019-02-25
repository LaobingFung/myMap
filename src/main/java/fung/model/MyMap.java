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

    public boolean put(K key, V value) {
        if (this.myKeyList.contains(key)) {
            return false;
        }
        Entry<K, V> newEntry = new Entry<>(key, value);
        this.myEntryList.add(newEntry);
        int index = this.myEntryList.size() - 1;
        this.myValueList.add(this.myEntryList.get(index).getValue());
        this.myKeyList.add(this.myEntryList.get(index).getKey());
        return true;
    }

    public V get(K key) {
        int index = this.myKeyList.indexOf(key);
        return index == -1? null: this.myValueList.get(index);
    }

    public V remove(K key) {
        int index = this.myKeyList.indexOf(key);
        if (index != -1) {
            this.myKeyList.remove(index);
            this.myEntryList.remove(index);
            return this.myValueList.remove(index);
        }
        return null;
    }

    public V replace(K key, V value) {
        int index = this.myKeyList.indexOf(key);
        if (index != -1) {
            this.myEntryList.get(index).setValue(value);
            return this.myValueList.set(index, value);
        }
        return null;
    }

    public MyMap() {
        this.myKeyList = new ArrayList<>();
        this.myValueList = new ArrayList<>();
        this.myEntryList = new ArrayList<>();
    }
}
