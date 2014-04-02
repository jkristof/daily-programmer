package com.kristof.dailyprogrammer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;


public class TelephoneKeypads {

    public static void main( String[] args ) {
        String word = "";
        Hashtable<Integer, String> ht = getAlphaHashTable();
        for ( String arg : args ) {
            word += ht.get( Integer.parseInt( arg ) );
        }
        System.out.println( findMatches( word ) );
    }

    public static String findMatches( String s ) {
        BufferedReader br = new BufferedReader( new InputStreamReader( TelephoneKeypads.class.getResourceAsStream( "brit-a-z.txt" ) ) );
        String line;
        StringBuffer result = new StringBuffer();
        try {
            while ( ( line = br.readLine() ) != null ) {
                if ( line.toLowerCase().startsWith( s.toLowerCase() ) ) result.append( line + "\n" );
            }
            br.close();
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static Hashtable<Integer, String> getAlphaHashTable() {
        Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
        ht.put( 2, "a" );
        ht.put( 22, "b" );
        ht.put( 222, "c" );
        ht.put( 3, "d" );
        ht.put( 33, "e" );
        ht.put( 333, "f" );
        ht.put( 4, "g" );
        ht.put( 44, "h" );
        ht.put( 444, "i" );
        ht.put( 5, "j" );
        ht.put( 55, "k" );
        ht.put( 555, "l" );
        ht.put( 6, "m" );
        ht.put( 66, "n" );
        ht.put( 666, "o" );
        ht.put( 7, "p" );
        ht.put( 77, "q" );
        ht.put( 777, "r" );
        ht.put( 7777, "s" );
        ht.put( 8, "t" );
        ht.put( 88, "u" );
        ht.put( 888, "v" );
        ht.put( 9, "w" );
        ht.put( 99, "x" );
        ht.put( 999, "y" );
        ht.put( 9999, "z" );
        return ht;
    }
}
