package me.jastz.common.ds;

/**
 * @author zhangzhiwen on 2019/12/18
 **/
public class MyCircularQueue {
    private int size;
    private int[] a;
    private int head;
    private int tail;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        a = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            head = 0;
        }
        tail = (tail+1)%size;
        a[tail] = value;
        return true;

    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(head==tail){
            head = -1;
            tail = -1;
            return true;
        }
        head = head+1%size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return a[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return a[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head==-1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail+1)%size==head;
    }


    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(10);
        for(int i =0;i<11;i++){
            myCircularQueue.enQueue(i);
        }
        System.out.println(myCircularQueue.isFull());
        System.out.println("出队结果："+myCircularQueue.deQueue());
        myCircularQueue.enQueue(2);
        System.out.println(myCircularQueue.isFull());
    }
}
