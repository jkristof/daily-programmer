package com.kristof.dailyprogrammer;

import java.util.ArrayList;

public class Devoweler {

    public static void main( String[] args ) {
        ArrayList<String> vowels = new ArrayList<String>();
        vowels.add( "a" );
        vowels.add( "e" );
        vowels.add( "i" );
        vowels.add( "o" );
        vowels.add( "u" );
        
        String parsedConsonants = "";
        String parsedVowels = "";
        
        String parsedArgs = "";
        
        for (String arg : args) {
            parsedArgs += arg;
        }
        
        for ( char c : parsedArgs.toCharArray() ) {
            if ( vowels.contains( String.valueOf( c ) ) ) {
                parsedVowels += c;
            } else {
                parsedConsonants += c;
            }
        }
        
        System.out.println(parsedConsonants);
        System.out.println(parsedVowels);

    }

}
