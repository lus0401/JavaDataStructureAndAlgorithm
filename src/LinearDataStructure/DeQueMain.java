package LinearDataStructure;

import java.util.ArrayList;

class MyDeque1 {
    ArrayList list;

    MyDeque1() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addFirst(int data) {
        this.list.add(0, data);
    }

    public void addLast(int data) {
        this.list.add(data);
    }

    public Integer removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        int data = (int) this.list.get(0);
        this.list.remove(0);
        return data;
    }

    public Integer removeLast() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        int data = (int) this.list.get(this.list.size()-1);
        this.list.remove(this.list.size()-1);
        return data;
    }

    public void printDeque() {
        System.out.println(this.list);
    }

}


class MyDeque2 {
    int[] arr;
    int front = 0;
    int rear = 0;

    MyDeque2(int size) {
        this.arr = new int[size + 1];
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public boolean isFull() {
        return (this.rear +1) % this.arr.length == this.front;
    }

    public void addFirst(int data) {
        if (this.isFull()) {
            System.out.println("Deque is full");
            return;
        }

        this.arr[this.front] = data;
        this.front = (this.front - 1 + this.arr.length) % this.arr.length;

    }

    public void addLast(int data) {
        if (this.isFull()) {
            System.out.println("Deque is full");
            return;
        }

        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    public Integer removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        this.front = (this.front + 1) % this.arr.length;
        return this.arr[front];
    }

    public Integer removeLast() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        int data = this.arr[this.rear];
        this.rear = (this.rear - 1 + this.arr.length) % this.arr.length;
        return data;
    }

    public void printDeque() {
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        for (int i = start; i != end; i = (i + 1) % this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}

public class DeQueMain {
    public static void main(String[] args) {

        System.out.println("== My Deque1 ==");
        MyDeque1 myDeque1 = new MyDeque1();

        // Front 부분 입력
        myDeque1.addFirst(1);
        myDeque1.addFirst(2);
        myDeque1.addFirst(3);
        myDeque1.printDeque();

        // Rear 부분 입력
        myDeque1.addLast(10);
        myDeque1.addLast(20);
        myDeque1.addLast(30);
        myDeque1.printDeque();

        // Front 부분 출력
        System.out.println(myDeque1.removeFirst());
        myDeque1.printDeque();

        System.out.println(myDeque1.removeLast());
        myDeque1.printDeque();

        System.out.println(myDeque1.removeLast());
        System.out.println(myDeque1.removeLast());
        System.out.println(myDeque1.removeLast());
        System.out.println(myDeque1.removeLast());
        myDeque1.printDeque();

        System.out.println("== My Deque2 ==");
        MyDeque2 myDeque2 = new MyDeque2(5);

        // Front 부분 입력
        myDeque2.addFirst(1);
        myDeque2.addFirst(2);
        myDeque2.addFirst(3);
        myDeque2.printDeque();

        // Rear 부분 입력
        myDeque2.addLast(10);
        myDeque2.addLast(20);
        myDeque2.addLast(30);
        myDeque2.printDeque();

        // Front 부분 출력
        System.out.println(myDeque2.removeFirst());
        myDeque2.printDeque();

        System.out.println(myDeque2.removeLast());
        myDeque2.printDeque();

        System.out.println(myDeque2.removeLast());
        System.out.println(myDeque2.removeLast());
        System.out.println(myDeque2.removeLast());
        System.out.println(myDeque2.removeLast());
        myDeque2.printDeque();
    }
}
