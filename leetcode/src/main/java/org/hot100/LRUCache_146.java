package org.hot100;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {
    public class Node{
        int key;
        int value;

        Node pre;

        Node next;

        public Node (int key,int value){
            this.key = key;
            this.value = value;
        }

    }
    private int capacity;
    private int size = 0;
    private Map<Integer,Node> map = null;
    private Node head;
    private Node tail;
    public LRUCache_146(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null){
            node = new Node(key,value);
            if(size == capacity){
                removeTail();
                size--;
            }
            size++;
            add(node);
            map.put(key,node);
        } else{
            moveToHead(node);
        }

    }
    private void removeTail(){
        Node pre = tail.pre;
        tail.pre = null;
        pre.next = null;
        tail = pre;
    }
    private void add(Node node){
        if(head == null){
            head = tail = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
    }
    private void moveToHead(Node node){
        if(node == head){
            return;
        }
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        add(node);

    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int rs = rootSum(root,targetSum);
        int leftSum = pathSum(root.left,targetSum);
        int rightSum = pathSum(root.right, targetSum);
        return rs + leftSum + rightSum;

    }
    private int rootSum(TreeNode root, int target){
        int ans = 0;
        if(root == null){
            return 0;
        }
        if(root.val == target){
            ans =  1;
        }
        return ans +  rootSum(root.left, target - root.val) + rootSum(root.right, target - root.val);
    }
}
