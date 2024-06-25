package LinearDataStructure;

import java.util.ArrayList;

// Practice1
// List를 이용한 큐 구현
class MyQueue1 {
    ArrayList list;

    MyQueue1() {
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
            System.out.println("Queue is empty!");
            return null;
        }
        int data = (int)this.list.getFirst();
        this.list.removeFirst();
        return data;
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return (int) this.list.getFirst();
    }

    public void printQueue() {
        System.out.println(this.list);
    }

}

// Practice2
// 배열을 이용한 기본 큐 직접 구현 (원형 큐)
class MyQueue2 {
    int[] arr;
    int front = 0;
    int rear = 0;

    MyQueue2(int size) {
        arr = new int[size + 1];
        // 프론트 관리를 위해 한 칸을 비우고 배열 생성
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public boolean isFull() {
        return (this.rear +1) % this.arr.length == this.front;
    }

    public void enqueue(int data) {
        if (this.isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    public Integer dequeue() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }

        this.front = (this.front + 1) % this.arr.length;
        return this.arr[front];
    }

    public void printQueue() {
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        for (int i = start; i != end; i = (i + 1) % this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

}
public class QueueMain {
    public static void main(String[] args) {
        System.out.println("== Queue1 ==");
        MyQueue1 myQueue = new MyQueue1();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);

        myQueue.printQueue(); // 1, 2, 3, 4

        System.out.println(myQueue.peek()); // 1
        myQueue.printQueue(); // 1, 2, 3, 4

        System.out.println(myQueue.pop()); // 1
        myQueue.printQueue(); // 2, 3, 4

        System.out.println(myQueue.pop()); // 3
        System.out.println(myQueue.pop()); // 4
        System.out.println(myQueue.pop()); // 5
        myQueue.printQueue();

        System.out.println("== Queue2 ==");
        MyQueue2 myQueue2 = new MyQueue2(4);
        myQueue2.enqueue(1);
        myQueue2.enqueue(2);
        myQueue2.enqueue(3);
        myQueue2.enqueue(4);

        myQueue2.printQueue(); // 1, 2, 3, 4

        System.out.println(myQueue2.dequeue());
        myQueue2.printQueue(); // 2, 3, 4

        System.out.println(myQueue2.dequeue());
        myQueue2.printQueue(); // 3, 4

        myQueue2.enqueue(5);
        myQueue2.enqueue(6);
        myQueue2.printQueue(); // 3, 4, 5, 6

        System.out.println(myQueue2.dequeue()); //3
        System.out.println(myQueue2.dequeue()); //4
        System.out.println(myQueue2.dequeue()); //5
        System.out.println(myQueue2.dequeue()); //6
        myQueue2.dequeue(); // Queue is empty!
    }
}
