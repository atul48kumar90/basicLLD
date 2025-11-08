package ShreyanshJain.TicTacToe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public final int size;
    public final PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int column, PlayingPiece piece){
        if(board[row][column] != null){
            System.out.println(" place is already used");
            return false;
        }
        board[row][column] = piece;
        return true;
    }

    public List<Pair<Integer, Integer>> getFreeCells(){
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j] == null){
                    Pair<Integer, Integer> rowColumn = new Pair(i, j);
                    freeCells.add(rowColumn);
                }
            }
        }
        return freeCells;
    }

    public void PrintBoard(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j] != null){
                    System.out.print(board[i][j].pieceType.name() + "    ");
                }else{
                    System.out.print("    ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
