package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Set {
    public static void main(String[] args) {
        // 1. 자바에서 집합 사용 - HashSet
        System.out.println("== HashSet ==");
        HashSet set1 = new HashSet<>();
        set1.add(1);
        set1.add(1);
        set1.add(1);
        System.out.println("set1 = " + set1); // 데이터가 중복해서 들어가지 않는 것 확인
        set1.add(2);
        set1.add(3);
        System.out.println("set1 = " + set1);
        set1.remove(1);
        System.out.println("set1 = " + set1);
        System.out.println(set1.size()); // 집합의 사이즈
        System.out.println(set1.contains(2)); // 집합에 들어 있는 원소 확인

        // 2. 집합 연산
        System.out.println("== 집합 연산 ==");

        // 2-1. 교집합
        HashSet a = new HashSet(Arrays.asList(1, 2, 3, 4, 5));
        HashSet b = new HashSet(Arrays.asList(2, 4, 6, 8, 10));
        a.retainAll(b); // 교집합 계산
        System.out.println("교집합" + a);

        // 2-2. 합집합
        HashSet c = new HashSet(Arrays.asList(1, 2, 3, 4, 5));
        HashSet d = new HashSet(Arrays.asList(2, 4, 6, 8, 10));
        c.addAll(d); // 합집합 계산
        System.out.println("합집합" + d);

        // 2-3. 차집합
        HashSet e = new HashSet(Arrays.asList(1, 2, 3, 4, 5));
        HashSet f = new HashSet(Arrays.asList(2, 4, 6, 8, 10));
        e.removeAll(f); // 차집합 계산
        System.out.println("차집합" + e);


    }



}
