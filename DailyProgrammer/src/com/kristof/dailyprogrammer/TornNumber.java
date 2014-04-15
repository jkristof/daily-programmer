package com.kristof.dailyprogrammer;

import java.util.Random;


public class TornNumber {

    public static void main( String[] args ) {
        while ( true ) {
            if ( isTorn( getNumber() ) ) break;
        }

    }

    public static Integer getNumber() {
        String number = "";
        Random rnd = new Random();
        number = String.valueOf( ( rnd.nextInt( 9 ) + 1 ) );
        while ( number.length() < 4 ) {
            int tmpRnd = ( rnd.nextInt( 10 ) );
            if ( number.indexOf( String.valueOf( tmpRnd ) ) == -1 ) {
                number = number + tmpRnd;
            }
        }
        return Integer.valueOf( number );
    }

    public static Boolean isTorn( Integer number ) {
        if ( Math.pow( ( number / 100 + number % 100 ), 2 ) == number ) {
            System.out.println( number );
            return true;
        }
        return false;
    }
}