package com.kristof.dailyprogrammer;

public class PolygonPerimeter {

    public static void main( String[] args ) {
        Integer sides = Integer.valueOf( args[0] );
        Float sideLength = Float.valueOf( args[1] );
        Float cr = (float)( sides * sideLength * (2 * Math.sin( Math.PI / sides )) );
        System.out.printf( "%.3f\n", cr );
    }

}