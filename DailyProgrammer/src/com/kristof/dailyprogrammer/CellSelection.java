package com.kristof.dailyprogrammer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;


public class CellSelection {

    private static BufferedImage imageModifiable = new BufferedImage( 100, 100, BufferedImage.TYPE_INT_RGB );
    private static Graphics graphics = imageModifiable.getGraphics();
    private static ArrayList<String> points = new ArrayList<String>();
    private static boolean[][] ss = new boolean[10][10];

    public static void main( String[] args ) {

        try {
            ArrayList<String> rawCells = new ArrayList<String>();
            String input = "B1:B3&B4:E10&F1:G1&F4~C5:C8&B2";
            Pattern p = Pattern.compile( "[&~]*(([a-zA-Z]+[0-9])(:[a-zA-Z]+[0-9]+)*)" );
            Matcher matches = p.matcher( input );
            while ( matches.find() ) {
                rawCells.add( matches.group() );
            }
            for ( int k = 0; k < rawCells.size(); k++ ) {
                String s = rawCells.get( k );
                Boolean draw = true;
                if ( s.contains( "~" ) || s.contains( "&" ) && rawCells.get( k - 1 ).contains( "~" ) ) {
                    draw = false;
                }
                s = s.replaceAll( "[&~]", "" );
                if ( s.contains( ":" ) ) {
                    String[] split = s.split( ":" );
                    int[] startRaw = toBin( split[0] );
                    Point start = new Point( startRaw[1] - 1, startRaw[0] - 1 );
                    int[] endRaw = toBin( split[1] );
                    Point end = new Point( endRaw[1] - 1, endRaw[0] - 1 );
                    for ( int i = start.y; i <= end.y; i++ ) {
                        for ( int j = start.x; j <= end.x; j++ ) {
                            draw( i, j, draw );
                        }
                    }
                }
                else {
                    int[] pointRaw = toBin( s );
                    Point point = new Point( pointRaw[1] - 1, pointRaw[0] - 1 );
                    draw( point.y, point.x, draw );
                }
            }
            System.out.println( points.size() );
            for ( String point : points )
                System.out.println( point );
            ImageIO.write( imageModifiable, "png", new File( "spreadsheet.png" ) );
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        finally {
            graphics.dispose();
            imageModifiable.flush();
        }

    }

    private static void draw( int x, int y, boolean draw ) {
        ss[x][y] = draw;
        graphics.setColor( ( draw ? Color.GREEN : Color.BLACK ) );
        graphics.fillRect( x * 10, y * 10, 10, 10 );
        if ( draw ) {
            points.add( x + ", " + y );
        }
        else {
            points.remove( x + ", " + y );
        }
    }

    private static int[] toBin( String input ) {
        String[] inputArray = input.split( "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)" );
        int[] result = new int[2];
        result[0] = inputArray[0].charAt( 0 ) % 64;
        result[1] = Integer.parseInt( inputArray[1] );
        return result;
    }
    
//    public static int[] toBin( String input ) {
//        String[] inputArray = input.split( "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)" );
//        int[] result = new int[2];
//        if ( inputArray[0].length() == 2 ) {
//            int tmpVal = 0;
//            tmpVal += inputArray[0].charAt( 0 ) % 64 + 25;
//            tmpVal += inputArray[0].charAt( 1 ) % 64;
//            result[0] = tmpVal;
//        }
//        else {
//            result[0] = inputArray[0].charAt( 0 ) % 64;
//        }
//        result[1] = Integer.parseInt( inputArray[1] );
//        return result;
//    }
}
