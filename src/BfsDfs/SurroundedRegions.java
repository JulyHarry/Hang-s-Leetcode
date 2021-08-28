package BfsDfs;

import java.util.LinkedList;
import java.util.Queue;

/*
130. 被围绕的区域
https://leetcode-cn.com/problems/surrounded-regions/
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) return;
        int col = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
            }
            if (board[i][col - 1] == 'O') {
                queue.offer(new int[]{i, col - 1});
            }
        }
        for (int i = 1; i < col - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
            }
            if (board[0][row - 1] == 'O') {
                queue.offer(new int[]{row - 1, i});
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != 'O') {
                continue;
            }
            board[x][y] = 'A';
            queue.offer(new int[]{x - 1, y});
            queue.offer(new int[]{x + 1, y});
            queue.offer(new int[]{x, y + 1});
            queue.offer(new int[]{x, y - 1});
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}