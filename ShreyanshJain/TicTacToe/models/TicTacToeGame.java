package ShreyanshJain.TicTacToe.models;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board board;
    Player winner;

    public void initializeGame(){
        players = new LinkedList<>();

        PlayingPiece pieceX = new PlayingPiece(PieceType.X);
        Player p1 = new Player("P1", pieceX);
        players.add(p1);

        PlayingPiece pieceO = new PlayingPiece(PieceType.O);
        Player p2 = new Player("P2", pieceO);
        players.add(p2);

        board = new Board(3);
    }

    public GameStatus startGame(){
        boolean noWinner = true;

        while(noWinner){
            Player currentPlayer = players.removeFirst();

            board.PrintBoard();

            List<Pair<Integer, Integer>> freeSpaces = board.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner = false;
                continue;
            }

            System.out.print("Player " + currentPlayer.getName() + " Please enter [row, column] ");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            String[] values = s.split(",");
            int row = Integer.valueOf(values[0]);
            int column = Integer.valueOf(values[1]);

            boolean validMove = board.addPiece(row, column, currentPlayer.getPlayingPiece());
            if(!validMove){
                System.out.println(" place is occupied");
                players.addFirst(currentPlayer);
                continue;
            }
            players.addLast(currentPlayer);

            boolean isWinner = checkForWinner(row, column, currentPlayer.getPlayingPiece().pieceType);
            if(isWinner){
                board.PrintBoard();
                noWinner = false;
                return GameStatus.WIN;
            }
        }

        return GameStatus.DRAW;
    }

    public boolean checkForWinner(int row, int column, PieceType pieceType){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //check row
        for(int i=0; i<board.size; i++){
            if(board.board[row][i] == null || board.board[row][i].pieceType != pieceType){
                rowMatch = false;
                break;
            }
        }

         // Check Column
         for (int i = 0; i < board.size; i++) {
            if (board.board[i][column] == null || board.board[i][column].pieceType != pieceType) {
                columnMatch = false;
                break;
            }
        }

        // Check Diagonally
        for (int i = 0, j = 0; i < board.size; i++, j++) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
                break;
            }
        }

        // Check Anti-Diagonally
        for (int i = 0, j = board.size - 1; i < board.size; i++, j--) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;

    }
}
