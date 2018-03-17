package eightqueens;
//Created by Sean C. on 3/15/2018

import java.util.ArrayList;

public class EQSolver {

    public static void solve(EQPartialSolutionBoard b){
        ArrayList<EQPartialSolutionBoard> fullSolutions = new ArrayList<>();
        int e = b.examine();
        // If e = 1, then add to the solutions
        if(e == 1){
            fullSolutions.add(b);
        }else if(e != -1){ // If e != -1, get 8 more extensions and then solve them recursively
            b.extend();
        }
        for(EQPartialSolutionBoard s : fullSolutions){
            System.out.println(s);
        }
    }

    public static void main(String[] args){
        solve(new EQPartialSolutionBoard([1]));
    }
}
