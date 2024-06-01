package org.hot100;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key;
        int value;

        Node pre;
        Node next;

        public Node(){

        }

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int size;
    int capacity;
    Node head;
    Node tail;

    Map<Integer,Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.pre = head;
    }

    public int get(int key) {
        Node value = map.get(key);
        if(value == null){
            return -1;
        }
        moveToHead(value);
        return value.value;
    }

    private void moveToHead(Node value) {
        removeNode(value);
        addToHead(value);
    }

    private void addToHead(Node value) {
        value.pre = head;
        value.next = head.next;
        head.next.pre = value;
        head.next  = value;
    }

    private void removeNode(Node value) {
        value.next.pre = value.pre;
        value.pre.next = value.next;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null){
            node = new Node(key, value);
            map.put(key,node);
            size++;
            addToHead(node);
            if(size > capacity){
                map.remove(tail.pre.key);
                removeTail();
                size--;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void removeTail() {
        removeNode(tail.pre);
    }

}
