package com.LeetCode;

public class No_3235_canReachCorner {
    public boolean canReachCorner(int xCorner, int yCorner, int[][] circles) {
        boolean[] visited = new boolean[circles.length];
        for (int i = 0; i < circles.length; i++) {
            int[] circle = circles[i];
            int x = circle[0], y = circle[1], r = circle[2];
            if (pointInCircle(0, 0, x, y, r) || pointInCircle(xCorner, yCorner, x, y, r)) {
                return false;
            }
            if (!visited[i] && circleIntersectsTopLeftOfRectangle(x, y, r, xCorner, yCorner)
                    && dfs(i, circles, xCorner, yCorner, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int i, int[][] circles, int xCorner, int yCorner, boolean[] visited) {
        int x1 = circles[i][0], y1 = circles[i][1], r1 = circles[i][2];
        if (circleIntersectsBottomRightOfRectangle(x1, y1, r1, xCorner, yCorner)) {
            return true;
        }
        visited[i] = true;
        for (int j = 0; j < circles.length; j++) {
            if (!visited[j]) {
                int x2 = circles[j][0], y2 = circles[j][1], r2 = circles[j][2];
                if (circlesIntersectInRectangle(x1, y1, r1, x2, y2, r2, xCorner, yCorner)
                        && dfs(j, circles, xCorner, yCorner, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean pointInCircle(long px, long py, long x, long y, long r) {
        return (x - px) * (x - px) + (y - py) * (y - py) <= r * r;
    }

    public boolean circleIntersectsTopLeftOfRectangle(int x, int y, int r, int xCorner, int yCorner) {
        return (Math.abs(x) <= r && 0 <= y && y <= yCorner) ||
                (0 <= x && x <= xCorner && Math.abs(y - yCorner) <= r) ||
                pointInCircle(x, y, 0, yCorner, r);
    }

    public boolean circleIntersectsBottomRightOfRectangle(int x, int y, int r, int xCorner, int yCorner) {
        return (Math.abs(y) <= r && 0 <= x && x <= xCorner) ||
                (0 <= y && y <= yCorner && Math.abs(x - xCorner) <= r) ||
                pointInCircle(x, y, xCorner, 0, r);
    }

    public boolean circlesIntersectInRectangle(long x1, long y1, long r1, long x2, long y2, long r2, long xCorner, long yCorner) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= (r1 + r2) * (r1 + r2) &&
                x1 * r2 + x2 * r1 < (r1 + r2) * xCorner &&
                y1 * r2 + y2 * r1 < (r1 + r2) * yCorner;
    }

    public static void main(String[] args) {

    }
}
