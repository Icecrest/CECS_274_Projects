package eightqueens;
//Created by Sean C. on 3/15/2018

public class Queen {

    int row;
    int col;

    public Queen(int row, int col){
        this.row = row;
        this.col = col;
    }


    public boolean attack(Queen other) {
        return this.row == other.row || this.col == other.col || checkDiag("UR", other) || checkDiag("UL", other) || checkDiag("DL", other) || checkDiag("DR", other);
    }

    public boolean checkDiag(String dir, Queen other){
        if(dir.equals("UR")){
            for(int i = 1; row < 8-row; row++){
                if(row+i == other.row && col+i == other.col){
                    return true;
                }
            }
            return false;
        }else if(dir.equals("UL")){
            for(int i = 1; row < 8-row; row++){
                if(row-i == other.row && col+i == other.col){
                    return true;
                }
            }
            return false;
        }else if(dir.equals("DL")){
            for(int i = 1; row < 8-row; row++){
                if(row-i == other.row && col-i == other.col){
                    return true;
                }
            }
            return false;
        }else if(dir.equals("DR")){
            for(int i = 1; row < 8-row; row++){
                if(row+i == other.row && col-i == other.col){
                    return true;
                }
            }
            return false;
        }
        else{
            System.out.println(" ~~ BAD DIRECTION ~~ ");
            return false;
        }
    }

    public String toString(){
        return Integer.toString(row + 1) + "abcdefgh".charAt(col);
    }
}
