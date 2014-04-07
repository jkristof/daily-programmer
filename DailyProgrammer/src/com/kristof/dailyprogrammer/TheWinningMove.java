package com.kristof.dailyprogrammer;

import java.util.Scanner;


public class TheWinningMove {

    public static void main( String[] args ) {
        String[] playField = new String[3];
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Enter player character:" );
        String player = scanner.next();
        System.out.println( "Enter 3x3 play field. Each row on a separate line: " );
        for ( int i = 0; i < 3; i++ ) {
            playField[i] = scanner.next();
        }
        scanner.close();
        playField = parseField( playField, player );
        if ( playField != null ) {
            for ( String row : playField ) {
                System.out.println( row );
            }
        }
        else {
            System.out.println( "No Winning Move" );
        }

    }

    public static Boolean checkForMove( String line, String player ) {
        int counter = 0;
        for ( int i = 0; i < line.length(); i++ ) {
            if ( line.charAt( i ) == player.charAt( 0 ) ) {
                counter++;
            }
        }
        return counter == 2;
    }

    public static String[] parseField( String[] playField, String player ) {
        // Check Rows
        for ( int i = 0; i < 3; i++ ) {
            if ( checkForMove( playField[i], player ) ) {
                playField[i] = playField[i].replace( "-", player );
                return playField;
            }
        }

        // Check Columns
        for ( int i = 0; i < 3; i++ ) {
            String column = "";
            for ( int j = 0; j < 3; j++ ) {
                column += playField[j].charAt( i );
            }
            if ( checkForMove( column, player ) ) {
                for ( int j = 0; j < 3; j++ ) {
                    StringBuilder sb = new StringBuilder( playField[j] );
                    sb.setCharAt( i, player.charAt( 0 ) );
                    playField[j] = sb.toString();
                }
                return playField;
            }
        }

        // Check First Diagonal
        String diagonal = "";
        for ( int i = 0; i < 3; i++ ) {
            diagonal += playField[i].charAt( i );
        }
        if ( checkForMove( diagonal, player ) ) {
            for ( int i = 0; i < 3; i++ ) {
                StringBuilder sb = new StringBuilder( playField[i] );
                sb.setCharAt( i, player.charAt( 0 ) );
                playField[i] = sb.toString();
            }
            return playField;
        }
        diagonal = "";
        // Check Second Diagonal
        for ( int i = 0, j = 2; i < 3; i++, j-- ) {
            diagonal += playField[i].charAt( j );
        }
        if ( checkForMove( diagonal, player ) ) {
            for ( int i = 0, j = 2; i < 3; i++, j-- ) {
                StringBuilder sb = new StringBuilder( playField[i] );
                sb.setCharAt( j, player.charAt( 0 ) );
                playField[i] = sb.toString();
            }
            return playField;
        }

        return null;
    }

}