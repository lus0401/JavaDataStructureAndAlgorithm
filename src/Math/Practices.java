package Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class Practices {

    // 행의 수가 입력으로 주어졌을 때 파스칼의 삼각형을 출력하시오
    public static ArrayList<ArrayList<Integer>> solution1(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    int x = result.get(i - 1).get(j - 1);
                    int y = result.get(i - 1).get(j);
                    list.add(x + y);
                }
            }
            result.add(list);
        }
        return result;
    }

    // 양의 정수로 이루어진 arr 배열이 주어졌을 때 해당 데이터로 만들 수 있는 permutation 중
    // - 현재 데이터보다 이전의 큰 수를 출력
    // - 한번의 swap으로 출력 가능한 큰 수를 출력
    public static void solution2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int idx = -1;
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i] < arr[i - 1]) {
                idx = i - 1;
                break;
            }
        }
        if (idx == -1) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 0; i > idx; i--) {
            if (arr[i] < arr[idx] && arr[i] != arr[i - 1]) {
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // 문자열 s1, s2가 주어졌을 때 s2의 부분 문자열이 s1에 있으면 true반환
    public static boolean solution3(String s1, String s2) {
        boolean[] visited = new boolean[s1.length()];
        char[] out = new char[s1.length()];
        ArrayList<String> list = new ArrayList<>();
        permutation(s1.toCharArray(), 0, s1.length(), s1.length(), visited, out, list);

        for (String s : list) {
            if (s2.contains(s)) {
                return true;
            }
        }
        return false;
    }

    public static void permutation(char[] arr, int depth, int n, int r, boolean[] visited, char[] out, ArrayList<String> list) {

        if (depth == r) {
            list.add(new String(out));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth + 1, n, r, visited, out, list);
                visited[i] = false;
            }
        }
    }

    // 행복한 수 일때 true
    public static boolean solution4(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (set.add(n)) {
            int squareSum = 0;

            while (n > 0) {
                int remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }

            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }
        return false;
    }

    // grid[i][j]가 지도이고 1이 영토, 0이 물일때 땅의 둘레구하기
    // 지도에는 독립된 영토만 있고, 내부에는 물이 있지 않음
    public static int solution5(int[][] grid) {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int cnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return recursion(grid, directions, i, j);
                }
            }
        }
        return cnt;
    }

    public static int recursion(int[][] grid, int[][] directions, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;

        grid[i][j] = -1;
        int cnt = 0;
        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0) {
                cnt++;
            } else {
                if (grid[x][y] == 1) {
                    cnt += recursion(grid, directions, x, y);
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        // Practice 1
        System.out.println("== Practice1 ==");
        System.out.println(solution1(1));
        System.out.println(solution1(2));
        System.out.println(solution1(3));
        System.out.println(solution1(4));
        System.out.println(solution1(5));

        // Practice 2
        System.out.println("== Practice2 ==");
        int[] arr = {3, 2, 1};
        solution2(arr);

        arr = new int[]{1, 9, 4, 7, 6};
        solution2(arr);

        arr = new int[]{1, 1, 2, 3};
        solution2(arr);

        // Practice 3
        System.out.println("== Practice3 ==");
        String s1 = "ab";
        String s2 = "abcde";
        System.out.println(solution3(s1, s2));

        s1 = "ac";
        s2 = "car";
        System.out.println(solution3(s1, s2));

        s1 = "ak";
        s2 = "aabbkk";
        System.out.println(solution3(s1, s2));

        // Practice 4
        System.out.println("== Practice4 ==");
        System.out.println(solution4(19));
        System.out.println(solution4(2));
        System.out.println(solution4(61));

        // Practice 5
        System.out.println("== Practice5 ==");
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(solution5(grid));

    }
}
