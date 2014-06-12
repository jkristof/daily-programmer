package com.kristof.dailyprogrammer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FalloutGame {
    
    private static List<String> words = null;

    public static void main( String[] args ) {
        int diff = 1;
        int guesses = 4;
        int count = 5;
        int length = 4;
        String password = null;
        
        Scanner scanner = new Scanner(System.in);
        System.out.print( "Difficulty [1-5]? ");
        diff = Integer.parseInt( scanner.nextLine() );
        if ( diff < 1 || diff > 5 ) { 
            System.out.println( "You had one job...");
            scanner.close();
            return;
        }
        switch (diff) {
            case 2:
                count = 7;
                length = 6;
                break;
            case 3:
                count = 9;
                length = 8;
                break;
            case 4:
                count = 12;
                length = 11;
                break;
            case 5:
                count = 15;
                length = 15;
                break;
        }
        words = getWords( count, length );
        printWords();
        password = getPassword();
        while ( guesses > 0 ) {
            System.out.print("Guess (" + guesses + " left)? ");
            int numCorrect = checkGuess( scanner.nextLine(), password );
            System.out.println( numCorrect + "/" + password.length() + " correct");
            if ( numCorrect == password.length() ) {
                System.out.println( "You win!" );
                scanner.close();
                return;
            }
            guesses--;
        }
        System.out.println( "You ran out of guesses.");
        System.out.println( "The password was: " + password);
        scanner.close();
    }

    public static List<String> getWords( Integer numOfWords, Integer length ) {
        BufferedReader br = new BufferedReader( new InputStreamReader( TelephoneKeypads.class.getResourceAsStream( "enable1.txt" ) ) );
        String line;
        ArrayList<String> words = new ArrayList<String>();
        try {
            while ( ( line = br.readLine() ) != null ) {
                if ( line.length() == length ) words.add( line.toUpperCase() );
            }
            br.close();
            shuffle( words );
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        return words.subList( 0, numOfWords );
    }
    
    public static void shuffle( ArrayList<?> list ) {
        long seed = System.nanoTime();
        Collections.shuffle( list, new Random( seed ) );
    }
    
    public static String getPassword() {
        return words.get( new Random().nextInt( words.size() ) );
    }
    
    public static Integer checkGuess( String guess, String password ) {
        if ( guess.equalsIgnoreCase( password )) return password.length();
        int numCorrect = 0;
        for ( int i = 0; i < password.length(); i++ ) {
            if (guess.toLowerCase().toCharArray()[i] == password.toLowerCase().toCharArray()[i]) numCorrect++;
        }
        return numCorrect;
    }
    
    public static void printWords( ) {
        for ( String word : words ) {
            System.out.println( word );
        }
    }
}
