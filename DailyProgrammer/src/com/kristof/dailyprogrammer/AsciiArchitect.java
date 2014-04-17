package com.kristof.dailyprogrammer;

import java.util.ArrayList;


public class AsciiArchitect {

    public static void main( String[] args ) {
        String[] output = new String[10];
        String template = "++--***...";
        ArrayList<String> columns = new ArrayList<String>();
        String builderString = args[0];

        for ( int i = 0; i < builderString.length(); i++ ) {
            String column = "";
            char currentChar = builderString.charAt( i );
            if ( Character.isDigit( currentChar ) ) {
                for ( int j = 0; j < Character.getNumericValue( currentChar ); j++ ) {
                    column += " ";
                }
                column += template.substring( 0, builderString.charAt( i + 1 ) - 96 );
            }
            else if ( Character.isLetter( currentChar ) && ( i == 0 || !Character.isDigit( builderString.charAt( i - 1 ) ) ) ) {
                column += template.substring( 0, currentChar - 96 );
            }
            if ( !column.equals( "" ) ) {
                while ( column.length() < 10 )
                    column += " ";
                columns.add( 0, column );
            }
        }
        for ( int i = 0; i < columns.size(); i++ ) {
            for ( int j = 0, j2 = 9; j < 10; j++, j2-- ) {
                if ( output[j] == null ) output[j] = "";
                output[j] = columns.get( i ).charAt( j2 ) + output[j];
            }
        }

        for ( String s : output ) {
            System.out.println( s );
        }
    }

}
