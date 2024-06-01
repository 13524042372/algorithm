package org.hot100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class MedianFinder {
    int size = 0;
    PriorityQueue<Integer> right = new PriorityQueue<>();
    PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());

    public MedianFinder() {

    }

    public void addNum(int num) {
        size++;
        if(right.size() > 0 && num > right.peek()){
            right.add(num);
        }else {
            left.add(num);
        }
        if(right.size() > left.size()){
            left.add(right.poll());
        } else if(left.size() > right.size() + 1){
            right.add(left.poll());
        }
    }

    public double findMedian() {
        if(size % 2 == 1){
            return left.peek() ;
        }else {
            return  (left.peek() + right.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.size);
        medianFinder.addNum(3);
        System.out.println(medianFinder.size);
        System.out.println(Arrays.toString(medianFinder.left.toArray()));
        System.out.println(Arrays.toString(medianFinder.right.toArray()));

    }
}
