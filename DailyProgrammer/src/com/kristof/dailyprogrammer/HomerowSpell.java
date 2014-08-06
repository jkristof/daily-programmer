package com.kristof.dailyprogrammer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class HomerowSpell {
    
    static ArrayList<String> words = new ArrayList<String>();

    public static void main( String[] args ) {
        BufferedReader br = new BufferedReader( new InputStreamReader( HomerowSpell.class.getResourceAsStream( "brit-a-z.txt" ) ) );
        String line;
        try {
            while ( ( line = br.readLine() ) != null ) {
                words.add( line.toLowerCase() );
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String input = "A oweaib who fprd not zfqzh challenges should mt ewlst to kze";
        String output = "";
        for ( String word : input.split( " " ) ) {
            if ( words.contains( word.toLowerCase().replaceAll( "[^a-zA-Z]", "" ) ) ) {
                output += word + " ";
                continue;
            } else {
                output += findMatches( word );
            }
        }
        System.out.println( output );
    }
    
    static String findMatches( String input ) {
        input = input.replaceAll( "[^a-zA-Z]", "" );
        ArrayList<String> result = new ArrayList<String>();
        for ( int i = -2; i <= 2 ; i++ ) {
            if ( i == 0 ) continue;
            String word = "";
            for ( String letter : input.split("") ) {
                word += getLetterAt( letter.toLowerCase(), i );
            }
            if ( !word.isEmpty() && word.length() == input.length() && words.contains( word ) ) {
                result.add(word);
            }
        }

        return result.isEmpty() ? "" : Arrays.toString( result.toArray() ).replace( "[", "{" ).replace( "]", "}" ) + " ";
    }
    
    static String getLetterAt( String c, int offset ) {
        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        rows.add( new ArrayList<String>( Arrays.asList( "q", "w", "e", "r", "t", "y", "u", "i", "o", "p" ) ) );
        rows.add( new ArrayList<String>( Arrays.asList( "a", "s", "d", "f", "g", "h", "j", "k", "l" ) ) );
        rows.add( new ArrayList<String>( Arrays.asList( "z", "x", "c", "v", "b", "n", "m" ) ) );
        for ( ArrayList<String> row : rows ) {
            if ( row.contains( c ) ) {
                if ( row.indexOf( c ) + offset >= row.size() ) {
                    return row.get( row.indexOf( c ) + offset - row.size() ); 
                } else if ( row.indexOf( c ) + offset < 0 ) {
                    return row.get( row.indexOf( c ) + offset + row.size() ); 
                }
                return row.get( row.indexOf( c ) + offset );
            }
        }
        return "";
    }

}
