package com.kristof.dailyprogrammer;

public class StringIndex {

    static String input = "...You...!!!@!3124131212 Hello have this is a --- string Solved !!...? to test @\n\n\n#!#@#@%$**#$@ Congratz this!!!!!!!!!!!!!!!!one ---Problem\n\n";
    static String[] words = input.split( "[^a-zA-Z0-9]+" );
    static int[] positions = { 12, -1, 1, -100, 4, 1000, 9, -1000, 16, 13, 17, 15 };

    public static void main( String[] args ) {
        for ( int pos : positions ) {
            String word = getWord(pos);
            System.out.print( word + ( word.isEmpty() ? "" : " " ) );
        }
    }

    public static String getWord( int i ) {
        if ( i < 0 || i >= words.length ) return "";
        return words[i];
    }

}