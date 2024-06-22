package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    Deque<Integer> deque1 = new LinkedList<Integer>();
    Deque<Integer> deque2 = new LinkedList<Integer>();

    public MinStack() {

    }

    public void push(int val) {
        deque1.push(val);
        if(deque2.isEmpty()){
            deque2.push(val);
        }else{
            deque2.push(Math.min(deque2.peek(), val));
        }

    }

    public void pop() {
        deque1.pop();
        deque2.pop();
    }

    public int top() {
        return deque1.peek();
    }

    public int getMin() {
        return deque2.peek();
    }
}
