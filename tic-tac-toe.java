import java.util.Scanner;

public class TicTacToe {
    static char[] board = new char[10];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        while (true) {
            int playerMove = getPlayerMove();
            makeMove(playerMove);
            printBoard();

            if (checkWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (checkDraw()) {
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private static void initializeBoard() {
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("-------------");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("-------------");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("-------------");
    }

    private static int getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        int move;
        do {
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            move = scanner.nextInt();
        } while (move < 1 || move > 9 || board[move] != ' ');
        return move;
    }

    private static void makeMove(int move) {
        board[move] = currentPlayer;
    }

    private static boolean checkWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private static boolean checkRows() {
        for (int i = 1; i <= 3; i++) {
            if (board[i] == board[i + 3] && board[i + 3] == board[i + 6] && board[i] != ' ') {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns() {
        for (int i = 1; i <= 3; i++) {
            if (board[i] == board[i + 1] && board[i + 1] == board[i + 2] && board[i] != ' ') {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals() {
        return (board[1] == board[5] && board[5] == board[9] && board[1] != ' ') ||
               (board[3] == board[5] && board[5] == board[7] && board[3] != ' ');
    }

    private static boolean checkDraw() {
        for (int i = 1; i < board.length; i++) {
            if (board[i] == ' ') {
                return false;
            }
        }
        return true;
    }
}
