package april2020.week2;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
    private class Node {
        int value;
        Node next;
        int min;

        private Node(int value, int min, Node next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }

        private Node(int value, int min) {
            // call the first constructor with this
            this(value, min, null);
        }
    }

    private Node head;
    private  Node prevHead;
    public void push(int value) {
        if(head == null) {
            head = new Node(value, value);
        } else {
            prevHead = head;
            // head.min = smaller between value and the current head.min
            // then head.next = previous head
            head = new Node(value, Math.min(value, head.min), prevHead);
        }
    }

    public void pop() {
        // java will fix the dangling pointer during gabbage collection
        head = head.next;
    }

    public int getMin() {
        return head.min;
    }

    public int top() {
        return head.value;
    }
}

class DoubleStackSolution {
    Stack<Integer> stack, stackOfMins;
    // initialize the stack
    DoubleStackSolution() {
        stack = new Stack<>();
        stackOfMins = new Stack<>();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return stackOfMins.peek();
    }
    public void push(int value) {
        stack.push(value);
        // push to stackOfMins when it is empty or the new value is less than or equal to the top element
        if(stackOfMins.isEmpty() || value <= stackOfMins.peek()) stackOfMins.push(value);
    }
    public void pop() {
        int a = stack.pop();
        // if the popped item is the minimum item, pop it from stackOfMins too
        if(a == stackOfMins.peek()) stackOfMins.pop();
    }
}