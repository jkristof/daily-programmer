package com.kristof.dailyprogrammer;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LooknSay {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        System.out.print( "Enter seed: " );
        String seed = scanner.nextLine();
        System.out.print( "Enter level: " );
        int level = Integer.parseInt( scanner.nextLine() );
        scanner.close();
        System.out.println( seed );
        for ( int i = 1; i < level; i++ ) {
            String result = "";
            Matcher m = Pattern.compile( "(\\w)\\1*" ).matcher( seed );
            while ( m.find() ) {
                String s = m.group();
                result += s.length() + String.valueOf( s.charAt( 0 ) );
            }
            seed = result;
            System.out.println( result );
        }

    }

}