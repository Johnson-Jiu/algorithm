package LeetCode.shujujiegou;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    Deque<Integer> deque1 = new LinkedList<Integer>();
    Deque<Integer> deque2 = new LinkedList<Integer>();


    public MinStack() {
        deque2.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        deque1.push(val);
        deque2.push(Math.min(val,deque2.peek()));
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
