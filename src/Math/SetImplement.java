package Math;

import java.util.ArrayList;

class MySet{
    // ArrayList
    ArrayList<Integer> list;

    // 생성자 1 : 객체만 생성
    MySet() {
        this.list = new ArrayList<Integer>();
    }

    // 생성자 2 : 객체 생성시 데이터 삽입
    MySet(int[] arr) {
        this.list = new ArrayList<Integer>();

        for (int item : arr) {
            this.list.add(item);
        }
    }

    // 원소 추가 (중복 X)
    public void add(int x) {
        for (int item: this.list) {
            // 같은 원소일 경우 같은 값이 있으면 데이터를 추가하지 않고 리턴
            if (item == x) {
                return;
            }
        }
        this.list.add(x);
    }

    // 교집합 : 기존 내용을 그대로 두고 교집합 된 집합을 새로 반환
    public MySet retainAll(MySet b) {
        MySet result = new MySet();

        for (int itemA : this.list) {
            for (int itemB : b.list) {
                if (itemA == itemB) {
                    result.add(itemA);
                }
            }
        }
        return result;
    }

    // 합집합 : 기존 내용을 그대로 두고 합집합 된 집합을 새로 반환
    public MySet addAll(MySet b) {
        MySet result = new MySet();

        for (int itemA : this.list) {
            result.add(itemA);
        }

        //add 에서 중복된 원소를 추가하지 않으므로 상관없음.
        for (int itemB : b.list) {
            result.add(itemB);
        }
        return result;
    }

    // 차집합
    public MySet removeAll(MySet b) {
        MySet result = new MySet();

        for (int itemA: this.list) {
            boolean containFlag = false;

            for (int itemB : b.list) {
                if (itemA == itemB) {
                    containFlag = true;
                    break;
                }
            }

            if (!containFlag) {
                result.add(itemA);
            }
        }
        return result;
    }

}

public class SetImplement {
    public static void main(String[] args) {
        // Test code
        MySet a = new MySet();

        a.add(1);
        a.add(1);
        a.add(1);
        System.out.println(a.list);
        a.add(2);
        a.add(3);
        System.out.println(a.list);

        a = new MySet(new int[]{1, 2, 3, 4, 5});
        MySet b = new MySet(new int[]{2, 4, 6, 8, 10});
        System.out.println("a: " + a.list);
        System.out.println("b: " + b.list);

        MySet result = a.retainAll(b);
        System.out.println("교집합: " + result.list);

        result = a.addAll(b);
        System.out.println("합집합: " + result.list);

        result = a.removeAll(b);
        System.out.println("차집합: " + result.list);
    }
}
