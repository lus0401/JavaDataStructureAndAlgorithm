package LinearDataStructure;

import java.util.Arrays;

public class ArrayPractices {

    // Practice 1
    // 배열 arr의 모든 데이터에 대해 짝수 데이터 평균과 홀수 데이터 평균을 출력하세요.

    public static void solution1(int[] arr) {
        float sumEven = 0;
        float sumOdd = 0;
        int evenCnt = 0;
        int oddCnt = 0;

        for (int item: arr) {
            if (item % 2 == 0) {
                sumEven += item;
                evenCnt++;
            } else {
                sumOdd += item;
                oddCnt++;
            }
        }

        System.out.println("짝수 평균: " + sumEven / evenCnt);
        System.out.println("홀수 평균: " + sumOdd / oddCnt);
    }

    // Practice 2
    // 배열 arr 에서 target에 해당되는 값의 인덱스를 출력
    // 해당 값이 여러개인 경우 가장 큰 인덱스 출력

    // 배열 arr: 1, 1, 100, 1, 1, 1, 100
    // target: 100
    // 결과: 6
    public static void solution2(int[] arr, int target){
        int idxMax = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (i > idxMax) {
                    idxMax = i;
                }
            }
        }

        if (idxMax >= 0) {
            System.out.println(idxMax);
        } else {
            System.out.println("target이 없습니다.");

        }
    }

    // Practice 3
    // 배열 arr 의 데이터 순서를 거꾸로 변경하세요.
    // 추가 배열을 사용하지 않고 구현.

    public static int[] solution3(int[] arr){
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length -i - 1] = tmp;
        }
        return arr;
    }

    // Practice 4
    // 배열에서 peak값 모두 출력(좌,우 보다 큰 값)
    public static void solution4(int[] arr){
        int[] result;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] > arr[i + 1]) {
                System.out.print(arr[i] + ", ");
            } else if (i == arr.length - 1 && arr[i] > arr[i - 1]) {
                System.out.print(arr[i]);
            } else {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    System.out.print(arr[i] + ", ");
                }
            }
        }
        System.out.println();
    }

    // Practice 5
    // 배열 arr의 값을 오름차순으로 출력

    // arr: 5, 3, 1, 4, 6, 1
    // 결과: 1, 1, 3, 4, 5, 6
    public static void soultion5(int[] arr) {
        int[] visited = new int[arr.length];
        int visitCnt = 0;
        int minVal = Integer.MIN_VALUE;
        int minIdx = -1;

        while (visitCnt < arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < minVal && visited[i] == 0) {
                    minVal = arr[i];
                    minIdx = i;
                }
            }

            if (minIdx != -1) {
                System.out.print(minVal + " ");
                visited[minIdx] = 1;
                visitCnt++;
            }

            minVal = Integer.MAX_VALUE;
            minIdx = -1;
        }
        System.out.println();
    }





    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        solution1(arr);

        arr = new int[]{1, 1, 100, 1, 1, 1, 100};
        int target = 100;
        solution2(arr, target);

        arr = new int[]{1, 3, 5, 7, 9};
        System.out.println(Arrays.toString(solution3(arr)));

        arr = new int[]{3, 1, 2, 6, 2, 2, 5, 1, 9, 10, 1, 11};
        solution4(arr);

        arr = new int[]{5, 3, 1, 4, 6, 1};
        soultion5(arr);


    }
}
