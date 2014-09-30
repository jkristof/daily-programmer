package com.kristof.dailyprogrammer;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ColumnConundrum {

    public static void main( String[] args ) {
        try {
            Scanner scanner = new Scanner( new File( "input.txt" ) );
            double colCount = scanner.nextInt();
            int colWidth = scanner.nextInt();
            int colSpace = scanner.nextInt();
            String spacer = "";
            for ( int i = 0; i < colSpace; i++ )
                spacer += " ";
            StringBuffer rawText = new StringBuffer();
            while ( scanner.hasNextLine() ) {
                rawText.append( scanner.nextLine() + " " );
            }
            scanner.close();
            Pattern pattern = Pattern.compile( "\\b(.){1," + ( colWidth - 1 ) + "}\\b([\\.\\,\\s])*" );
            Matcher matcher = pattern.matcher( rawText.toString() );
            ArrayList<String> textList = new ArrayList<String>();
            while ( matcher.find() ) {
                textList.add( String.format( "%1$-" + colWidth + "s", matcher.group().trim() ) );
            }
            double colLength = Math.ceil( textList.size() / colCount );
            for ( int i = 0; i < colLength; i++ ) {
                String row = "";
                for ( int j = 0, k = 0; j < colCount; k += colLength, j++ ) {
                    if ( i + k < textList.size() ) row += textList.get( i + k ) + spacer;
                }
                System.out.println( row );
            }
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }

}
