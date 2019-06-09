package tencent;

import java.util.Stack;

public class UniquePaths {

    public static void main(String... args) {
        int result = new UniquePaths().syn(8, 6);
        System.out.print(result);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int uniquePaths(int m, int n) {
        Point start = new Point(0, 0);
//        List<Point> stack = new ArrayList<>(m + n);
        int size = 0;
        Stack<Point> stock = new Stack<>();
        stock.add(start);
        while (stock.size() > 0) {
            Point point = stock.pop();
            if (point.x == m - 1 && point.y == n - 1) {
                size++;
                continue;
            }
            if (point.x < m - 1) {
                stock.push(new Point(point.x + 1, point.y));
            }
            if (point.y < n - 1) {
                stock.push(new Point(point.x, point.y + 1));
            }
        }
        return size;
    }

    public int syn(int m, int n) {
        int[][] point = new int[m][n];
        int size = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    point[i][j] = 1;
                } else {
                    point[i][j] = point[i - 1][j] + point[i][j - 1];
                }
            }
        }
        return point[m - 1][n - 1];
    }

}
