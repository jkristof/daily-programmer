package com.kristof.dailyprogrammer;

import java.util.Random;


public class Bogosort {

    public static void main( String[] args ) {
        String answer = "hello";
        String shuffled = "lolhe";
        int shuffles = 1;
        for ( ; !shuffled.equals( answer ); shuffles++ ) {
            shuffled = shuffle( shuffled );
        }
        System.out.println( "Shuffles: " + shuffles );
    }

    public static String swap( char[] letters, int i, int j ) {
        char temp = letters[i];
        letters[i] = letters[j];
        letters[j] = temp;
        return String.copyValueOf( letters );
    }

    public static String shuffle( String input ) {
        int i = input.length() - 1;
        String temp = "";
        while ( i >= 0 ) {
            temp = swap( input.toCharArray(), new Random().nextInt( input.length() ), new Random().nextInt( input.length() ) );
            i--;
        }
        return temp;
    }
}
