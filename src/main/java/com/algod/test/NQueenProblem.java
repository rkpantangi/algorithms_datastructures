package com.algod.test;

import java.util.Arrays;

public class NQueenProblem {
	private static final int N = 8;

    private static void printSolution(int board[][]) {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                                 + " ");
            System.out.println();
        }
    }
    
    private static boolean solve(int board[][], int col) {
    	if (col >= N) return true;
    	
    	for (int i=0;i<N;i++) {
    		if (isSafe(board, i, col)) {
    			board[i][col] = 1;
    			if (solve(board, col+1)) {
    				return true;
    			}
    			board[i][col] = 0;
    		}
    	}
    	return false;
    }
    
	private static boolean isSafe(int[][] board, int row, int col) {
		for (int j = 0;j<N;j++) {
			if (board[row][j] == 1) return false;
		}

		for (int j = 0;j<N;j++) {
			if (board[j][col] == 1) return false;
		}

		for (int i=row, j=col;i>=0 && j>=0;i--,j--) {
			if (board[i][j] == 1) return false;
		}

		for (int i=row+1, j=col+1;i<N && j<N;i++,j++) {
			if (board[i][j] == 1) return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		int [][] board = new int[N][N];

		for (int[] row: board)
		    Arrays.fill(row, 0);
		solve(board, 0);
		printSolution(board);
	}

}
