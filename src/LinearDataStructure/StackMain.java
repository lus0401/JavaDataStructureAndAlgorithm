package LinearDataStructure;

import java.util.ArrayList;

// ArrayList 사용
class MyStack1 {
    ArrayList list;

    MyStack1() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) {
        this.list.add(data);
    }

    public Integer pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        int data = (int) this.list.get(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);
        return data;
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        int data = (int) this.list.get(this.list.size() - 1);
        return data;
    }
    public void printStack() {
        System.out.println(this.list);

    }
}

// 배열 사용
class MyStack2 {
    int[] arr;
    int top = -1;

    MyStack2(int size) {
        arr = new int[size];
    }

    public boolean isEmpty() {
        if (this.top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (this.top == this.arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) {
        if(this.isFull()) {
            System.out.println("Stack is full!");
            return;
        }
        this.top += 1;
        this.arr[this.top] = data;
    }

    public Integer pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }

        int data = this.arr[this.top];
        this.top -= 1;
        return data; //사실 데이터는 남아있음.
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }
        return this.arr[this.top];
    }

    public void printStack() {
        for (int i = 0; i < this.top + 1; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}


public class StackMain {
    public static void main(String[] args) {
        System.out.println("== STACK1 ==");
        MyStack1 myStack1 = new MyStack1();
        System.out.println(myStack1.isEmpty());
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(3);
        myStack1.push(4);
        myStack1.printStack();

        System.out.println(myStack1.peek());
        myStack1.printStack();

        System.out.println(myStack1.pop());
        System.out.println(myStack1.pop());
        myStack1.printStack();

        System.out.println(myStack1.pop());
        System.out.println(myStack1.pop());
        myStack1.printStack();

        System.out.println();

        System.out.println("== STACK2 ==");
        MyStack2 myStack2 = new MyStack2(4);
        System.out.println(myStack2.isEmpty());
        myStack2.push(1);
        myStack2.push(2);
        myStack2.push(3);
        myStack2.push(4);
        myStack2.printStack();

        System.out.println(myStack2.peek());
        myStack2.printStack();

        System.out.println(myStack2.pop());
        System.out.println(myStack2.pop());
        myStack2.printStack();

        System.out.println(myStack2.pop());
        System.out.println(myStack2.pop());
        myStack2.printStack();
    }
}
