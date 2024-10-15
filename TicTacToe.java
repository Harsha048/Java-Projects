// See README FILE.txt for instructions


package scanner;

import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		char[][] board = {
				{'1','2','3'},
				{'4','5','6'},
				{'7','8','9'}
				
	};
		Scanner scanner = new Scanner(System.in);
		char player ='X';
		
		while(true) {
			printBoard(board);
			System.out.println("Player"+player+"s turn.");
			System.out.println("Enter your move(1-9):");
			int move = scanner.nextInt();
			
			if(isValidMove(board, move)) {
				makeMove(board, move, player);
				if(isWinner(board, player)) {
					printBoard(board);
					System.out.println("Player"+player+"wins!");
					break;
				}else if(isBoardFull(board)) {
					printBoard(board);
					System.out.println("It's a tie!");
					break;
				}
				player = (player =='X') ? 'O' : 'X';
			}else {
				System.out.println("Invalid move. Try again.");
			}
		}

}
	    public static void printBoard(char[][] board) {
	        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
	        System.out.println("-----------");
	        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
	        System.out.println("-----------");
	        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
	    }

	    public static boolean isValidMove(char[][] board, int move) {
	        int row = (move - 1) / 3;
	        int col = (move - 1) % 3;
	        return board[row][col] != 'X' && board[row][col] != 'O';
	    }

	    public static void makeMove(char[][] board, int move, char player) {
	        int row = (move - 1) / 3;
	        int col = (move - 1) % 3;
	        board[row][col] = player;
	    }

	    public static boolean isWinner(char[][] board, char player) {
	        // Check rows
	        for (int i = 0; i < 3; i++) {
	            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
	                return true;
	            }
	        }
	        // Check columns
	        for (int i = 0; i < 3; i++) {
	            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
	                return true;
	            }
	        }
	        // Check diagonals
	        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
	                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
	            return true;
	        }
	        return false;
	    }

	    public static boolean isBoardFull(char[][] board) {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (board[i][j] != 'X' && board[i][j] != 'O') {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	}
