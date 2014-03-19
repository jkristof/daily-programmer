package com.kristof.dailyprogrammer;

public class TreeGeneration {

    public static void main( String[] args ) {
        Integer base = Integer.valueOf( args[0] );
        Integer stump = (base - 1) / 2 - 1;
                
        Integer counter = base / 2;
        for (int j = 1; j <= base; j+=2, counter--) {
            for (int i = counter;i > 0;i--) {
                System.out.print( " " );
            }
            for (int i = j;i > 0;i--) {
                System.out.print( "*" );
            }
            System.out.println();
        }
        for ( int j = stump; j > 0; j--) {
            System.out.print( " " );
        }
        System.out.println("###");
    }
    
}