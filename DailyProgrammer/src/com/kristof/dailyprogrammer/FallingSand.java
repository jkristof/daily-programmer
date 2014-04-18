package com.kristof.dailyprogrammer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class FallingSand {

    public static void main( String[] args ) throws Exception {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Enter grid size:" );
        int gridSize = scanner.nextInt();
        StringBuilder[] grid = new StringBuilder[gridSize];
        System.out.println( "Enter location of text file to parse:" );
        BufferedReader br = new BufferedReader( new FileReader( scanner.next() ) );
        scanner.close();
        String line;
        int j = 0;
        while ( ( line = br.readLine() ) != null ) {
            grid[j] = new StringBuilder().append( line );
            j++;
        }
        br.close();
        for ( int i = grid.length - 1; i >= 0; i-- ) {
            for ( int c = 0; c < grid[i].length(); c++ ) {
                if ( grid[i].charAt( c ) == ".".charAt( 0 ) ) {
                    int h = 0;
                    while ( true ) {
                        h++;
                        if ( i + h == grid.length || grid[i + h].charAt( c ) != " ".charAt( 0 ) ) {
                            h--;
                            break;
                        }
                    }
                    if ( h > 0 ) {
                        grid[i + h].setCharAt( c, grid[i].charAt( c ) );
                        grid[i].setCharAt( c, " ".charAt( 0 ) );
                    }
                }

            }
        }
        for ( StringBuilder sb : grid )
            System.out.println( sb.toString() );

    }

}