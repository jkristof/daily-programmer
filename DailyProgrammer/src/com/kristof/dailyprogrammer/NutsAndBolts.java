package com.kristof.dailyprogrammer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class NutsAndBolts {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        Integer numOfItems = scanner.nextInt();
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        ArrayList<String> results = new ArrayList<String>();
        for ( int i = 0; i < numOfItems; i++ ) {
            ht.put( scanner.next(), scanner.nextInt() );
        }
        for ( int i = 0; i < numOfItems; i++ ) {
            String tmpItem = scanner.next();
            if ( ht.containsKey( tmpItem ) ) {
                Integer tmp = scanner.nextInt();
                tmp = tmp - ht.get( tmpItem ).intValue();
                if ( tmp != 0 ) {
                    results.add( tmpItem + " " + ( tmp > 0 ? "+" + tmp : tmp ) );
                }
            }
        }
        for ( String result : results )
            System.out.println( result );
        scanner.close();
    }

}
