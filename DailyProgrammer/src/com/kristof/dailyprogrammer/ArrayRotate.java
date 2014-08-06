package com.kristof.dailyprogrammer;

import java.util.Arrays;


public class ArrayRotate {

    public static void main( String[] args ) {
        Integer[][] input = new Integer[][] { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, 
                                              { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 },
                                              { 1, 3, 5, 7, 9, 2, 4, 6, 8, 0 },
                                              { 0, 8, 6, 4, 2, 9, 7, 5, 3, 1 }, 
                                              { 0, 1, 2, 3, 4, 5, 4, 3, 2, 1 }, 
                                              { 9, 8, 7, 6, 5, 6, 7, 8, 9, 0 },
                                              { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
                                              { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 }, 
                                              { 9, 8, 7, 6, 7, 8, 9, 8, 7, 6 },
                                              { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
        for ( Integer[] line : rotate90( input ) ) {
            System.out.println( Arrays.toString( line ).replaceAll( "[\\[\\],]", "" ) );
        }
    }

    public static Integer[][] rotate90( Integer[][] matrix ) {
        Integer size = matrix.length;
        Integer[][] result = new Integer[size][size];
        for ( int r = 0; r < size; r++ ) {
            for ( int c = 0; c < size; c++ ) {
                result[r][c] = matrix[size - 1 - c][r];
            }
        }
        return result;
    }
}
