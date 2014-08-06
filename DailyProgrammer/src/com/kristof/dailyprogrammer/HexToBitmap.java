package com.kristof.dailyprogrammer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;


public class HexToBitmap {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        BufferedImage bufferedImage = new BufferedImage( 32, 32, BufferedImage.TYPE_INT_RGB );
        try {
            String input = scanner.nextLine();
            String[] hexLines = input.split( " " );
            scanner.close();
            Graphics graphics = bufferedImage.getGraphics();
            graphics.setColor( Color.WHITE );
            graphics.fillRect( 0, 0, bufferedImage.getHeight(), bufferedImage.getWidth() );
            graphics.setColor( Color.GREEN );
            for ( int h = 0; h < hexLines.length; h++ ) {
                char[] bin = String.format( "%8s", Integer.toBinaryString( Integer.parseInt( hexLines[h], 16 ) ) ).replace( ' ', '0' ).toCharArray();
                for ( int w = 0; w < bin.length; w++ ) {
                    if ( bin[w] == "1".charAt( 0 ) ) {
                        graphics.fillRect( w * 4, h * 4, 4, 4 );
                    }
                }
            }
            ImageIO.write( bufferedImage, "png", new File( input + ".png" ) );
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        finally {
            scanner.close();
            bufferedImage.flush();
        }
    }
}
