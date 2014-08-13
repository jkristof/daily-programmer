package com.kristof.dailyprogrammer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


public class LargestWord {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Please enter words: " );
        String[] words = scanner.nextLine().split( " " );
        System.out.println( "Please enter letters: " );
        LinkedList<String> letters = new LinkedList<String>( Arrays.asList( scanner.nextLine().split( " " ) ) );
        scanner.close();
        LinkedList<String> result = new LinkedList<String>();
        int maxLength = 0;
        for ( String word : words ) {
            @SuppressWarnings( "unchecked" )
            LinkedList<String> tempLetters = (LinkedList<String>)letters.clone();
            int count = 0;
            for ( int i = 0; i < word.length(); i++ ) {
                if ( tempLetters.contains( Character.toString( word.charAt( i ) ) ) ) {
                    tempLetters.remove( tempLetters.indexOf( Character.toString( word.charAt( i ) ) ) );
                    count++;
                }
                else {
                    break;
                }
            }
            if ( count == word.length() ) {
                if ( word.length() > maxLength ) {
                    result.clear();
                    maxLength = word.length();
                    result.add( word );
                }
                else if ( word.length() == maxLength ) {
                    result.add( word );
                }
            }
        }
        if ( result.isEmpty() ) {
            System.out.println( "No Words Found" );
        }
        else {
            for ( String word : result )
                System.out.println( word );
        }
    }

}
