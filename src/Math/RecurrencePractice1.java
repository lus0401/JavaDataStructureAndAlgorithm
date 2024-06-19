package Math;

public class RecurrencePractice1 {

    // 팩토리얼을 재귀함수로 구현하기
    static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // GCD를 재귀함수로 구현하기
    static int getGcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));

        System.out.println(getGcd(3, 5));
        System.out.println(getGcd(2, 6));
        System.out.println(getGcd(8, 12));
    }
}
