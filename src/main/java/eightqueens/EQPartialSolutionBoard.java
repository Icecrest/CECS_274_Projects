package eightqueens;


import java.util.Arrays;

public class EQPartialSolutionBoard {

    private Queen[] queens;
    public EQPartialSolutionBoard(int numQ){
        queens = new Queen[numQ];
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
        if(queens.length == 8){
            return 1;
        }
        return 0;
    }

    /**
     * comes up with an array of 8 partial solution boards
     */
    public EQPartialSolutionBoard[] extend (){
        EQPartialSolutionBoard[] extensions = new EQPartialSolutionBoard[8];
        for (int i = 0; i < 8; i++){
            EQPartialSolutionBoard newBoard = new EQPartialSolutionBoard(queens.length+1);
            //1. Copy the Queens from this board to the new board
            //2. Add a new Queen one row above the one we just tested
            //3. Add the new board to the array
            newBoard.setQueens(this.queens);
            addQueen(new Queen(i, queens[queens.length-2].col));

        }

        return extensions;
    }

    public void setQueens(Queen[] queens){
        for(int i  = 0; i < queens.length; i++){
            this.queens[i] = queens[i];
        }
    }

    public void addQueen(Queen other){
        this.queens[this.queens.length-1] = other;
    }

    public String toString(){
        return Arrays.toString(queens);
    }





}
