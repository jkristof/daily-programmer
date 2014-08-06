package com.kristof.dailyprogrammer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;


public class AvatarGenerator {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        String userName = "";
        System.out.print( "Enter user name: " );
        userName = scanner.nextLine();
        scanner.close();
        BufferedImage imageModifiable = new BufferedImage( 64, 64, BufferedImage.TYPE_INT_RGB );
        Graphics graphics = imageModifiable.getGraphics();
        try {
            graphics.setColor( Color.WHITE );
            graphics.fillRect( 0, 0, imageModifiable.getHeight(), imageModifiable.getWidth() );
            byte[] nameBytes = userName.getBytes( "UTF8" );
            String nameBin = "";
            for ( byte b : nameBytes )
                nameBin += Integer.toBinaryString( b );
            while ( nameBin.length() < 64 )
                nameBin += nameBin;
            nameBin = nameBin.substring( 0, 64 );
            String[] colorArray = nameBin.split( "(?<=\\G.{8})" );
            for ( int i = 0; i < colorArray.length; i++ ) {
                for ( int j = 0; j < colorArray[i].length(); j++ ) {
                    int c = colorArray[i].charAt( j );
                    graphics.setColor( new Color( c * userName.hashCode() ) );
                    graphics.fillRect( i * 8, j * 8, 8, 8 );
                }
            }
            ImageIO.write( imageModifiable, "png", new File( userName + ".png" ) );
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        finally {
            graphics.dispose();
            imageModifiable.flush();
        }
    }
}
