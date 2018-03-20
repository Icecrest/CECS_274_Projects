package eightqueens;


import java.util.ArrayList;
import java.util.Arrays;

public class EQPartialSolutionBoard {

    private ArrayList<Queen> queens;
    public EQPartialSolutionBoard(){
        queens = new ArrayList<>();
    }

    /**
     * check whether the board is a full solution,
     * a partion solution, or not a solution
     * @return - 1 if the board is a solution
     *          0 if the board is a partial solution
     *              -1 if the board is not a solution
     */
    public int examine() {
        //CASE 1: Check whether the queens attack each other, if they do, return -1
        //CASE 2: Check the size of queens, if it is 8, then return 1
        //Otherwise return 0
        for(Queen q : queens){
            for(Queen u : queens){
                if(q.toString().equals(u.toString())){
                    continue;
                }else if(q.attack(u)){
                    return -1;
                }
            }
        }
        if(queens.size() == 8){
            return 1;
        }
        return 0;
    }

    /**
     * comes up with an array of 8 partial solution boards
     */
    public ArrayList<EQPartialSolutionBoard> extend (){
        ArrayList<EQPartialSolutionBoard> extensions = new ArrayList<>();
        int row;
        if(queens.size() > 0){
             row = this.queens.get(queens.size()-1).row;
        }
        else{
            row = -1;
        }
        for (int i = 0; i < 8; i++){
            EQPartialSolutionBoard newBoard = new EQPartialSolutionBoard();
            //1. Copy the Queens from this board to the new board
            //2. Add a new Queen one row above the one we just tested
            //3. Add the new board to the array
            newBoard.setQueens(this.queens);
            newBoard.addQueen(new Queen(row+1, i));
            extensions.add(newBoard);
        }

        return extensions;
    }

    public void setQueens(ArrayList<Queen> queens){
        queens.addAll(this.queens);
    }

    public void addQueen(Queen q){
        this.queens.add(q);
    }

    public String toString(){
        return queens.toString();
    }





}
