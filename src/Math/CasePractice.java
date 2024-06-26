package Math;

import java.util.ArrayList;

public class CasePractice {

    // 약수
    public ArrayList getDivisor(int num) {
        ArrayList result = new ArrayList();

        for (int i = 1; i < (int) num / 2; i++) {
            if (num % 1 == 0) {
                result.add(i);
            }
        }
        result.add(num);

        return result;
    }

    // 최대 공약수: 더 좋은 풀이 방법이 있으나 재귀함수에서 다시 해볼 것
    // GCD: the Greatest Common Divisor
    public int getGCD(int numA, int numB) {
        int gcd = -1;

        ArrayList divisorA = this.getDivisor(numA);
        ArrayList divisorB = this.getDivisor(numB);

        for (int itemA: (ArrayList<Integer>) divisorA) {
            for (int itemB : (ArrayList<Integer>) divisorB) {
                if (itemA == itemB) {
                    gcd = itemA;
                }
            }
        }
        return gcd;
    }

    // 최소 공배수: (두 수의 곱) / (최대 공약수)
    // LCM: Least Common Multiple
    public int getLCM(int numA, int numB) {
        int lcm = -1;

        int gcd = this.getGCD(numA, numB);
        if (gcd != -1) {
            lcm = (numA * numA) / gcd;
        }
        return lcm;
    }

    public static void main(String[] args) {

        // Test code
        int number1 = 10;
        int number2 = 6;

        CasePractice p = new CasePractice();
        ArrayList l1 = p.getDivisor(number1);
        ArrayList l2 = p.getDivisor(number2);

        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);

        System.out.println("최대 공약수: " + p.getGCD(number1, number2));
        System.out.println("최소 공배수: " + p.getLCM(number1, number2));
    }
}
