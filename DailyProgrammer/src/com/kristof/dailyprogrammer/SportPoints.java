package com.kristof.dailyprogrammer;

import java.util.Arrays;

public class SportPoints {

    public static void main( String[] args ) {
        Integer[] invalid = {1, 2 , 4, 5};
        Arrays.sort( invalid );
        System.out.println( Arrays.binarySearch( invalid, Integer.valueOf( args[0] ) ) >= 0 ? "Invalid Score" : "Valid Score" );
    }

}
