package com.kristof.dailyprogrammer;

import java.text.NumberFormat;
import java.util.Random;


public class DiceRoll {

    public static void main( String[] args ) {
        System.out.println( "# of Rolls\t1s\t2s\t3s\t4s\t5s\t6s" );
        System.out.println( "==============================================================" );
        NumberFormat pf = NumberFormat.getPercentInstance();
        pf.setMaximumFractionDigits( 2 );
        for ( int i = 10; i <= 100000; i = i * 10 ) {
            float[] rolls = new float[6];
            for ( int j = 0; j < i; j++ ) {
                rolls[new Random().nextInt( 6 )]++;
            }
            System.out.printf( "%d\t\t%s\t%s\t%s\t%s\t%s\t%s\n", i, pf.format( rolls[0] / i ), pf.format( rolls[1] / i ), pf.format( rolls[2] / i ),
                               pf.format( rolls[3] / i ), pf.format( rolls[4] / i ), pf.format( rolls[5] / i ) );
        }
    }
}
