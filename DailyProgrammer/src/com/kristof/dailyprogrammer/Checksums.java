package com.kristof.dailyprogrammer;

import java.util.Scanner;


public class Checksums {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        System.out.print( "Enter number of lines to receive: " );
        int count = Integer.valueOf( scanner.nextLine() );
        String[] lines = new String[count];
        System.out.println( "Enter your " + count + " lines :" );
        for ( int i = 0; i < count; i++ ) {
            lines[i] = scanner.nextLine();
        }
        for ( int i = 1; i <= lines.length; i++ ) {
            System.out.println( i + " " + check( lines[i - 1].getBytes() ) );
        }
        scanner.close();
    }

    private static String check( byte[] b ) {

        int sum1 = 0;
        int sum2 = 0;

        for ( int i = 0; i < b.length; i++ ) {
            sum1 = ( ( sum1 + b[i] ) % 255 );
            sum2 = ( ( sum2 + sum1 ) % 255 );
        }

        return Integer.toHexString( ( ( sum2 << 8 ) | sum1 ) ).toUpperCase();
    }
}
