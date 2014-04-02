package com.kristof.dailyprogrammer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Gorellian {

    public static void main( String[] args ) {
        Integer wordCount = Integer.valueOf( args[0] );
        String alphabet = args[1].toLowerCase();
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Please enter your " + wordCount + " words, each on a new line." );
        ArrayList<String> words = new ArrayList<>();
        for ( int i = 0; i < wordCount; i++ )
            words.add( scanner.nextLine() );
        scanner.close();
        Collections.sort( words, new customComparator( alphabet ) );

        for ( String word : words )
            System.out.println( word );

    }

}

class customComparator implements Comparator<String> {
    String alphabet = "";

    customComparator( String alphabet ) {
        this.alphabet = alphabet;
    }

    @Override
    public int compare( String s1, String s2 ) {
        Integer limit = Math.min( s1.length(), s2.length() );
        for ( int i = 0; i < limit; i++ ) {
            char char1 = s1.toLowerCase().charAt( i );
            char char2 = s2.toLowerCase().charAt( i );
            if ( char1 != char2 ) {
                return ( alphabet.indexOf( char1 ) - alphabet.indexOf( char2 ) );
            }
        }
        return ( s1.length() - s2.length() );
    }
}
