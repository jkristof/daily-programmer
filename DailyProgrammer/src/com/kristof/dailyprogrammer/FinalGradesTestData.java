package com.kristof.dailyprogrammer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;


public class FinalGradesTestData {

    public static void main( String[] args ) {
        BufferedReader brFirstNames = new BufferedReader( new InputStreamReader( FinalGradesTestData.class.getResourceAsStream( "actor-givenname.txt" ) ) );
        BufferedReader brLastNames = new BufferedReader( new InputStreamReader( FinalGradesTestData.class.getResourceAsStream( "actor-surname.txt" ) ) );
        String line;
        ArrayList<String> firstNames = new ArrayList<String>();
        ArrayList<String> lastNames = new ArrayList<String>();
        HashMap<String, String> results = new HashMap<String, String>();
        try {
            while ( ( line = brFirstNames.readLine() ) != null ) {
                firstNames.add( line );
            }
            brFirstNames.close();
            while ( ( line = brLastNames.readLine() ) != null ) {
                lastNames.add( line );
            }
            brLastNames.close();
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        while ( results.size() < 10 ) {
            String name = firstNames.get( random( firstNames.size() ) ) + " , " + lastNames.get( random( lastNames.size() ) );
            String grades = random( 101 ) + " " + random( 101 ) + " " + random( 101 ) + " " + random( 101 ) + " " + random( 101 );
            results.put( name, grades );
        }
        for ( Entry<String, String> e : results.entrySet() ) {
            System.out.println( e.getKey() + " " + e.getValue() );
        }
    }

    public static int random( int size ) {
        return new Random().nextInt( size );
    }
}