package com.kristof.dailyprogrammer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MarchMadnessBrackets {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Enter string to parse:" );
        String rawText = scanner.nextLine();
        scanner.close();
        rawText = rawText.replace( "{", "[" ).replace( "(", "[" ).replace( "}", "]" ).replace( ")", "]" );
        ArrayList<Integer[]> positions = new ArrayList<Integer[]>();
        Pattern p = Pattern.compile( "\\[{1}" );
        Matcher m = p.matcher( rawText );
        while ( m.find() ) {
            Integer[] iArray = { m.start(), null };
            positions.add( iArray );
        }
        p = Pattern.compile( "\\]{1}" );
        m = p.matcher( rawText );
        int i = positions.size() - 1;
        while ( m.find() ) {
            positions.get( i )[1] = m.start();
            i--;
        }
        StringBuffer results = new StringBuffer();
        for ( Integer[] j : positions ) {
            results.insert( 0, ( removeSubBlock( rawText.substring( j[0], j[1] + 1 ) ) ) );
        }
        System.out.println( cleanString( results.toString().trim() ) );

    }

    public static String removeSubBlock( String str ) {
        if ( str.startsWith( "[" ) ) str = str.replaceFirst( "\\[", " " );
        if ( str.endsWith( "]" ) ) str = str.substring( 0, str.length() - 1 );
        return str.replaceAll( "\\[.*\\]", "" );
    }

    public static String cleanString( String str ) {
        return str.replaceAll( "[ ]{2,}", " " );
    }

}