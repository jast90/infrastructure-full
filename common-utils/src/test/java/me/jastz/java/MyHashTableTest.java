package me.jastz.java;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhiwen
 */
public class MyHashTableTest {

    @Test
    public void test() {
        MyHashTable myHashTable = new MyHashTable();
        MyHashTable myHashTable2 = new MyHashTable();

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorService.submit(() -> {
            myHashTable.put("hello", "world");
//            System.out.println(myHashTable.get("hello"));
        });

        executorService.submit(() -> {
            myHashTable2.get("hello");
        });


        /*executorService.submit(() -> {
            myHashTable.put("hello1", "world1");
//            System.out.println(myHashTable.get("hello"));
        });*/

        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                break;
            }
        }
    }
}
