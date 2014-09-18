package com.kristof.dailyprogrammer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;


public class GreyScale {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        try {
            System.out.print( "Path to image: " );
            File file = new File( scanner.nextLine() );
            scanner.close();
            String[] fileTokens = file.getName().split( "\\.(?=[^\\.]+$)" );
            BufferedImage input = ImageIO.read( file );
            BufferedImage output = new BufferedImage( input.getWidth(), input.getHeight(), BufferedImage.TYPE_BYTE_GRAY );
            output.getGraphics().drawImage( input, 0, 0, null );
            ImageIO.write( output, fileTokens[1], new File( file.getParent(), fileTokens[0] + "_grey." + fileTokens[1] ) );
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        finally {
            scanner.close();
        }
    }

}
