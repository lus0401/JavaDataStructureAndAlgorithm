package LinearDataStructure;

// 기본 배열 자료형을 이용한 배열의 생성, 삽입, 삭제 기능 구현

import java.util.Arrays;

public class Array {

    int[] arr;

    // 배열의 초기 사이즈
    Array(int size) {
        this.arr = new int[size];
    }

    // 배열에 데이터 삽입
    public void insertData(int index, int data) {
        if (index < 0 || index > this.arr.length) {
            System.out.println("Index Error");
            return;
        }

        int[] arrDup = this.arr.clone();
        this.arr = new int[this.arr.length + 1];

        for (int i = 0; i < index; i++) {
            this.arr[i] = arrDup[i];
        }
        for (int i = index + 1; i < this.arr.length; i++) {
            this.arr[i] = arrDup[i - 1];
        }

        this.arr[index] = data;
    }

    // 배열에서 특정 데이터 삭제
    public void removeData(int data) {
        int targetIndex = -1;

        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == data) {
                targetIndex = i;
                break;
            }
        }

        if (targetIndex == -1) {
            System.out.println("해당 데이터가 없습니다.");
        } else {
            int[] arrDup = this.arr.clone();
            this.arr = new int[this.arr.length - 1];

            for (int i = 0; i < targetIndex; i++) {
                this.arr[i] = arrDup[i];
            }
            for (int i = targetIndex; i < this.arr.length; i++) {
                this.arr[i] = arrDup[i + 1];
            }
        }
    }

    public static void main(String[] args) {
        int size = 5;
        Array myArray = new Array(size);

        for (int i = 0; i < size; i++) {
            myArray.arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(myArray.arr));

        myArray.arr[0] = 10;
        System.out.println(Arrays.toString(myArray.arr));

        myArray.insertData(2, 20);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.insertData(-1, 4);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.removeData(4);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.removeData(5);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.removeData(99);
        System.out.println(Arrays.toString(myArray.arr));

    }
}
