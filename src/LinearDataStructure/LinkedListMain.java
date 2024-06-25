package LinearDataStructure;

// 노드

class Node{
    int data;
    Node next;

    Node() {}

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;

    LinkedList() {}
    LinkedList(Node node) {
        this.head = node;
    }

    // 연결리스트 비어있는지 확인
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    // 연결리스트의 맨 뒤에 추가
    public void addData(int data) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }


    // 연결리스트에 데이터 추가
    // before_data가 null인 경우, 가장 뒤에 추가
    // before_data에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else if (beforeData == null){
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        } else {
            Node cur = this.head;
            Node pre = cur;
            while (cur != null) {
                if (cur.data == beforeData) {
                    if (cur == this.head) {
                        this.head = new Node(data, this.head);
                    } else {
                        pre.next = new Node(data, cur);
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    // 연결리스트의 맨 뒤 데이터 삭제
    public void removeData() {
        if (this.isEmpty()) {
            System.out.println("list is empty");
            return;
        }
        Node cur = this.head;
        Node prev = cur;
        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }

        if (cur == this.head) {
            this.head = null;
        } else {
            prev.next = null;
        } // 안쓰는 메모리를 자동 해제하므로 링크부분만 잘 관리하면 됨.
    }

    // data 와 값이 같은 데이터 삭제
    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("list is empty");
            return;
        }

        Node cur = this.head;
        Node pre = cur;
        while (cur.next != null) {
            if (cur.data == data) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    pre.next = cur.next;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }

    public void findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            if (cur.data == data) {
                System.out.println("Data exist");
                return;
            }
            cur = cur.next;
        }
        System.out.println("Data not found");
    }

    // 연결 리스트의 모든 데이터 출력
    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }


}


public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList(new Node(1, null));
        myList.showData();

        myList.addData(2);
        myList.addData(3);
        myList.showData();

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.showData();

        myList.findData(1);
        myList.findData(100);

        myList.removeData(100);
        myList.removeData(200);
        myList.removeData(300);
        myList.showData();

        myList.removeData();
        myList.removeData();
        myList.removeData();
        myList.removeData();

    }
}
