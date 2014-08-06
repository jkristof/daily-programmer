package com.kristof.dailyprogrammer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ConvexPolygonArea {

    public static void main( String[] args ) throws IOException {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "How many polygons should I expect?" );
        int count = Integer.valueOf( scanner.nextLine() );
        ArrayList<ArrayList<Point2D>> polygons = new ArrayList<ArrayList<Point2D>>();

        for ( int i = 0; i < count; i++ ) {
            System.out.println( "Enter your #" + ( i + 1 ) + " polygon coordinates on separate lines. Example: x,y\nPress Enter on a blank line to continue." );
            String[] coords;
            polygons.add( i, new ArrayList<Point2D>() );
            while ( ( coords = scanner.nextLine().split( "," ) ).length > 1 ) {
                polygons.get( i ).add( new Point2D.Double( Double.parseDouble( coords[0] ), Double.parseDouble( coords[1] ) ) );
            }

        }
        scanner.close();
        int maxWidth = 0;
        int maxHeight = 0;
        int minHeight = 0;
        int minWidth = 0;
        for ( ArrayList<Point2D> points : polygons ) {
            for ( Point2D point : points ) {
                if ( point.getX() > maxWidth ) maxWidth = (int)point.getX();
                if ( point.getX() < minWidth ) minWidth = (int)point.getX();
                if ( point.getY() > maxHeight ) maxHeight = (int)point.getY();
                if ( point.getY() < minHeight ) minHeight = (int)point.getY();
            }
        }
        int xOffset = 0;
        int yOffset = 0;
        if ( minWidth < 0 ) xOffset = Math.abs( minWidth );
        if ( minHeight < 0 ) yOffset = Math.abs( minHeight );
        BufferedImage bufferedImage = new BufferedImage( ( maxWidth + xOffset ) * 100, ( maxHeight + yOffset ) * 100, BufferedImage.TYPE_INT_RGB );
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor( Color.WHITE );
        graphics.fillRect( 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight() );
        graphics.setColor( Color.GREEN );
        for ( ArrayList<Point2D> points : polygons ) {
            int[] xPoints = new int[points.size()];
            int[] yPoints = new int[points.size()];
            for ( int i = 0; i < points.size(); i++ ) {
                xPoints[i] = (int)( points.get( i ).getX() * 100 + xOffset * 100 );
                yPoints[i] = (int)( points.get( i ).getY() * 100 + yOffset * 100 );
            }
            graphics.fillPolygon( xPoints, yPoints, xPoints.length );
        }
        int[] pixels = ( (DataBufferInt)bufferedImage.getRaster().getDataBuffer() ).getData();
        float totalArea = 0;
        for ( int pixel : pixels ) {
            Color color = new Color( pixel );
            if ( color.getRGB() == Color.GREEN.getRGB() ) {
                totalArea++;
            }
        }
        System.out.printf( "%.2f", totalArea / 10000 );
    }

}
