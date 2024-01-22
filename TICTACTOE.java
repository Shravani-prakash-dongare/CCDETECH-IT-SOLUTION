import java.util.*;

public class TICTACTOE {
    private static Scanner scanner = new Scanner(System.in);
    private static final int BOARD_SIZE = 3;
    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private static char currentPlayer;

    public static void main(String args[]) {
        initializeBoard();

        System.out.println("\n\nWelcome To Tic Tac Toe !\n");
        System.out.println("Select the game mode :");
        System.out.println("1. Human Vs. Human \n2. Human Vs. Computer");
        int choice = scanner.nextInt();
        if (choice == 1) {
            playHumanVsHuman();
        } else if (choice == 2) {
            playHumanVsComputer();
        } else {
            System.out.println("Invalid Choice");
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
    }

    private static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static void playHumanVsHuman() {
        int moves = 0;

        while (true) {
            System.out.println("Player " + currentPlayer + "'s turn");
            makemove();
            displayBoard();
            moves++;

            if (checkWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (moves == BOARD_SIZE * BOARD_SIZE) {
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }
    }

    private static void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    public static boolean checkWin() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    public static void makemove() {
        int row, col;

        do {
            System.out.print("Enter row (1-3): ");
            row = scanner.nextInt() - 1;
            System.out.print("Enter column (1-3): ");
            col = scanner.nextInt() - 1;
        } while (!isValidMove(row, col));

        board[row][col] = currentPlayer;
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE || board[row][col] != ' ') {
            System.out.println("Invalid move. Try again.");
            return false;
        }
        return true;

    }

    public static void playHumanVsComputer() {
        int moves = 0;
        Random random = new Random();

        while (true) {
            if (currentPlayer == 'X') {
                System.out.println("Your Turn Player X :");
                makemove();
            } else {
                System.out.println("Computer turn Player O :");
                makecomputermove(random);
            }

            displayBoard();
            moves++;

            if (checkWin()) {
                if (currentPlayer == 'X') {
                    System.out.println("Congratulation you wins!");
                } else {
                    System.out.println("Computer wins!");
                }
                break;
            } else if (moves == BOARD_SIZE * BOARD_SIZE) {
                System.out.println("It's a Draw");
                break;
            }
            switchPlayer();
        }
    }

    public static void makecomputermove(Random random) {
        int row, col;

        do {
            row = random.nextInt(BOARD_SIZE);
            col = random.nextInt(BOARD_SIZE);
        } while (!isValidMove(row, col));

        board[row][col] = currentPlayer;
    }
}
