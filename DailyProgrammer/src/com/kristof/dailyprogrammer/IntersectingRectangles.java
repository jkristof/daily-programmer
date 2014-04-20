package com.kristof.dailyprogrammer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Scanner;


public class IntersectingRectangles {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "How many rectagles should I expect?" );
        Rectangle[] rectangles = new Rectangle[Integer.valueOf( scanner.nextLine() )];
        System.out.println( "Enter your " + rectangles.length + " rectangle coordinates." );

        for ( int i = 0; i < rectangles.length; i++ ) {
            String[] coords = scanner.nextLine().split( " " );
            rectangles[i] = new Rectangle( Double.valueOf( coords[0] ), Double.valueOf( coords[1] ), Double.valueOf( coords[2] ), Double.valueOf( coords[3] ) );
        }
        scanner.close();
        int maxWidth = 0;
        int maxHeight = 0;
        for ( Rectangle r : rectangles ) {
            if ( r.getX2() > maxWidth ) maxWidth = r.getX2();
            if ( r.getY2() > maxHeight ) maxHeight = r.getY2();
        }
        BufferedImage bufferedImage = new BufferedImage( maxWidth, maxHeight, BufferedImage.TYPE_INT_RGB );
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor( Color.WHITE );
        graphics.fillRect( 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight() );
        graphics.setColor( Color.GREEN );
        for ( Rectangle r : rectangles ) {
            graphics.fillRect( r.getX1(), r.getY1(), r.getWidth(), r.getHeight() );
        }
        int[] pixels = ( (DataBufferInt)bufferedImage.getRaster().getDataBuffer() ).getData();
        double totalArea = 0;
        for ( int pixel : pixels ) {
            Color color = new Color( pixel );
            if ( color.getRGB() == Color.GREEN.getRGB() ) totalArea++;
        }
        System.out.printf( "%.2f", totalArea / 1000000 );
    }

}

class Rectangle {

    private int x1 = 0;
    private int y1 = 0;
    private int x2 = 0;
    private int y2 = 0;

    public Rectangle( double x1, double y1, double x2, double y2 ) {
        this.x1 = (int)( x1 * 1000 );
        this.y1 = (int)( y1 * 1000 );
        this.x2 = (int)( x2 * 1000 );
        this.y2 = (int)( y2 * 1000 );
    }

    public int getWidth() {
        return x2 - x1;
    }

    public int getHeight() {
        return y2 - y1;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
}
