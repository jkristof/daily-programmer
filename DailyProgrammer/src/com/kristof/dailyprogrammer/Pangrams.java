package com.kristof.dailyprogrammer;

import java.util.HashMap;
import java.util.Scanner;


public class Pangrams {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        System.out.print( "Enter number of lines to receive: " );
        int count = Integer.valueOf( scanner.nextLine() );
        String[] lines = new String[count];
        System.out.println( "Enter your " + count + " lines :" );
        for ( int i = 0; i < count; i++ ) {
            lines[i] = scanner.nextLine();
        }
        for ( String line : lines ) {
            System.out.println( checkString( line ) );
        }
        scanner.close();
    }

    private static Boolean checkString( String s ) {
        HashMap<Character, Integer> alphabetHM = getHashMap();
        for ( Character c : s.toCharArray() ) {
            Character cToLower = Character.toLowerCase( c );
            if ( alphabetHM.containsKey( cToLower ) ) alphabetHM.put( cToLower, alphabetHM.get( cToLower ) + 1 );
        }
        if ( alphabetHM.containsValue( 0 ) ) return false;
        return true;
    }

    private static HashMap<Character, Integer> getHashMap() {
        HashMap<Character, Integer> result = new HashMap<Character, Integer>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for ( Character letter : alphabet.toCharArray() ) {
            result.put( letter, 0 );
        }
        return result;
    }

}
