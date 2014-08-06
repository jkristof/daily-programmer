package com.kristof.dailyprogrammer;

import java.util.LinkedList;
import java.util.Scanner;


public class ThueMorse {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        System.out.print( "Enter nth order sequences to display: " );
        int nth = Integer.parseInt( scanner.nextLine() );
        scanner.close();
        System.out.println( "nth\t\tSequence" );
        System.out.println( "========================================================================" );
        LinkedList<Integer> sequence = new LinkedList<Integer>();
        sequence.add( 0 );
        for ( int i = 1; i <= nth; i++ ) {
            System.out.print( i + "\t\t" );
            int size = sequence.size();
            for ( int j = 0; j < size; j++ ) {
                sequence.add( sequence.get( j ) == 1 ? 0 : 1 );
            }
            for ( int j = 0; j < sequence.size(); j++ ) {
                int bin = sequence.get( j );
                System.out.print( bin );
            }
            System.out.println();
        }
    }
}
