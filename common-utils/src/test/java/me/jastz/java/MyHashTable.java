package me.jastz.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiwen
 */
public class MyHashTable<K, V> {
    private Map<K, V> map = new HashMap<>();

    public void put(K k, V v) {
//        synchronized(MyHashTable.class){
        synchronized (this) {
            System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + "MyHashTable.put");
            map.put(k, v);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public V get(K k) {
//        synchronized(MyHashTable.class){ // synchronized class VS synchronized object VS synchronized method
        synchronized (this) {
            V v = map.get(k);
            System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + "MyHashTable.get " + v);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return v;
        }
    }
}
