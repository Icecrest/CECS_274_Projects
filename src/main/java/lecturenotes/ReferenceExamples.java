package lecturenotes;
//Created by Sean C. on 1/30/2018

import java.util.Arrays;

public class ReferenceExamples {

    public static void tripleIn(int a){
        a *= 3;
    }

    public static void doubleIn(int[] a){
        int[] b = new int[a.length];

        for(int i = 0; i < b.length; i++){
            b[i] = a[i] * 2;
        }
    }

    public static void main(String[] args){
        int c = 5;

        tripleIn(c);

        int[] d = {1, 2, 3, 4};
        doubleIn(d);

        System.out.print(Arrays.toString(d));
    }

}
