package Math;

public class ExponentialPractice {

    static double pow(int a, double b) {
        double result = 1;
        boolean isMinus = false;

        if (b == 0) {
            return 1;
        } else if (b < 0) {
            b *= -1;
            isMinus = true;
        }

        for (int i = 0; i < b; i++) {
            result *= a;
        }

        return isMinus? 1 / result : result;
    }

    static double sqrt(int a) {
        double result = 1;

        // 바빌로니아 방법
        for (int i = 0; i < 10; i++) {
            result = (result + (a / result)) / 2;
        }

        return result;
    }

    public static void main(String[] args) {
        // 1. 제곱, 제곱근, 지수
        System.out.println("== 제곱 ==");
        System.out.println(pow(2,3));
        System.out.println(pow(2,-3));
        System.out.println(pow(-2,-3));

        System.out.println("== 제곱근 ==");
        System.out.println(Math.sqrt(16));
        System.out.println(Math.sqrt(8));

        System.out.println(sqrt(16));
        System.out.println(sqrt(8));
    }
}
