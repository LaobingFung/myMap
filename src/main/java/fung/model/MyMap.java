package main.java.fung.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MyMap<K, V> {
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

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry<K, V> objEntry = (Entry<K, V>) obj;
            return this.getKey().equals(objEntry.getKey()) && this.getValue().equals(objEntry.getValue());
        }
    }

    public boolean put(K key, V value) {
        for (Entry<K, V> entry : this.myEntryList) {
            if (entry.getKey().equals(key)) {
                return false;
            }
        }
        Entry<K, V> newEntry = new Entry<>(key, value);
        this.myEntryList.add(newEntry);
        return true;
    }

    public V get(K key) {
        for (Entry<K, V> entry : this.myEntryList) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = indexOf(key);
        if (index != -1) {
            return this.myEntryList.remove(index).getValue();
        }
        return null;
    }

    public V replace(K key, V value) {
        int index = indexOf(key);
        if (index != -1) {
            Entry<K, V> entry = this.myEntryList.get(index);
            V oldValue = entry.getValue();
            entry.setValue(value);
            return oldValue;
        }
        return null;
    }

    public int indexOf(K key) {
        int index = -1;
        for (int i = 0; i < this.myEntryList.size(); i++) {
            if (this.myEntryList.get(i).getKey().equals(key)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void clear() {
        this.myEntryList.clear();
    }

    public Set<Entry<K, V>> entrySet() {
        return new HashSet(this.myEntryList);
    }

    public Set<K> keySet() {
        HashSet<K> keySet = new HashSet<>();
        for (Entry<K, V> entry : this.myEntryList) {
            keySet.add(entry.getKey());
        }
        return keySet;
    }

    public ArrayList<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (Entry<K, V> entry : this.myEntryList) {
            values.add(entry.getValue());
        }
        return values;
    }

    public MyMap() {
        this.myEntryList = new ArrayList<>();
    }
}
