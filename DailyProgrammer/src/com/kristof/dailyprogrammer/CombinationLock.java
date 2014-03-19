package com.kristof.dailyprogrammer;

public class CombinationLock {

    public static void main( String[] args ) {
        
        int dialSize = Integer.valueOf( args[0] );
        int digitOne = Integer.valueOf( args[1] );
        int digitTwo = Integer.valueOf( args[2] );
        int digitThree = Integer.valueOf( args[3] );
        int turnsNeeded = 0;
        
        turnsNeeded += ( dialSize * 2 ) + digitOne + dialSize;
        
        int tmp = digitOne - digitTwo;
        
        if ( tmp > 0 ) {
            turnsNeeded += tmp;
        } else if ( tmp < 0 ) {
            turnsNeeded += dialSize + tmp;
        }
        
        tmp = digitThree - digitTwo;
        
        if ( tmp == 0 ) {
            turnsNeeded += dialSize;
        } else if (tmp > 0 ) {
            turnsNeeded += tmp;
        } else {
            turnsNeeded += dialSize + tmp;
        }
        
        System.out.println( turnsNeeded );
        
    }

}
