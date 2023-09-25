package Stack;

import java.util.EmptyStackException;

class MyStack<T> {
    private class MyStackNode<T> {
        private T data;
        private MyStackNode<T> next;

        public MyStackNode(T data) {
            this.data = data;
        }
    }

    private MyStackNode<T> top;
    private int nodeCounter = 0;

    private int getNodeCounter() {
        return this.nodeCounter;
    }

    private void increaseNodeCounter() {
        this.nodeCounter++;
    }

    private void decreaseNodeCounter() {
        this.nodeCounter--;
    }

    private boolean isEmptyStack() {
        return getNodeCounter() == 0 ? true : false;
    }

    public T push(T data) {
        MyStackNode<T> newStack = new MyStackNode<>(data);
        if (!isEmptyStack()) {
            newStack.next = top;
        }
        top = newStack;
        increaseNodeCounter();
        return data;
    }

    public T pop() {
        if (isEmptyStack()) {
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        decreaseNodeCounter();
        return data;
    }

    public T peek() {
        if (isEmptyStack()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public void printStack() {
        if (isEmptyStack()) {
            System.out.println("This stack is empty.");
            return;
        }
        MyStackNode<T> temp = top;
        for (int i = 0; i < getNodeCounter(); i++) {
            System.out.println(top.data);
            top = top.next;
        }
        System.out.println("----");
        top = temp;
    }

    public static void main(String[] args) {
        MyStack<Integer> ms = new MyStack<>();
        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        ms.printStack();
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.peek());
        System.out.println(ms.pop());
    }

}