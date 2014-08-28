package com.kristof.dailyprogrammer;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;


public class MorseAudio {

    public static void main( String[] args ) throws Exception {
        Scanner scanner = new Scanner( System.in );
        System.out.print( "Enter your text: " );
        String input = scanner.nextLine();
        scanner.close();
        ArrayList<Byte> rawData = new ArrayList<Byte>();
        HashMap<String, String> alphabet = getAlphabet();
        for ( String word : input.split( " " ) ) {
            for ( Character letter : word.toCharArray() ) {
                String morse = alphabet.get( letter.toString().toLowerCase() );
                for ( String s : morse.split( "" ) ) {
                    byte[] buf = new byte[1];
                    int length = 0;
                    if ( s.equals( "-" ) ) {
                        length = 500;
                    }
                    else if ( s.equals( "." ) ) {
                        length = 250;
                    }
                    for ( int i = 0; i < length * (float)44100 / 1000; i++ ) {
                        double angle = i / ( (float)44100 / 440 ) * 2.0 * Math.PI;
                        buf[0] = (byte)( Math.sin( angle ) * 100 );
                        rawData.add( buf[0] );
                    }
                    for ( int i = 0; i < 2000; i++ )
                        rawData.add( new Byte( (byte)1 ) );

                }
            }
            for ( int i = 0; i < 10000; i++ )
                rawData.add( new Byte( (byte)1 ) );
        }

        byte[] audioData = new byte[rawData.size()];
        for ( int i = 0; i < rawData.size(); i++ ) {
            audioData[i] = rawData.get( i ).byteValue();
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream( audioData );
        AudioFormat audioFormat = new AudioFormat( (float)44100, 8, 1, true, false );
        AudioInputStream audioInputStream = new AudioInputStream( byteArrayInputStream, audioFormat, audioData.length / audioFormat.getFrameSize() );
        try {
            AudioSystem.write( audioInputStream, AudioFileFormat.Type.WAVE, new File( input.replace( " ", "-" ) + ".wav" ) );
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    static HashMap<String, String> getAlphabet() {
        HashMap<String, String> result = new HashMap<String, String>();

        result.put( "a", ".-" );
        result.put( "b", "-.." );
        result.put( "c", "-.-." );
        result.put( "d", "-.." );
        result.put( "e", "." );
        result.put( "f", "..-." );
        result.put( "g", "--." );
        result.put( "h", "...." );
        result.put( "i", ".." );
        result.put( "j", ".---" );
        result.put( "k", "-.-" );
        result.put( "l", ".-.." );
        result.put( "m", "--" );
        result.put( "n", "-." );
        result.put( "o", "---" );
        result.put( "p", ".--." );
        result.put( "q", "--.-" );
        result.put( "r", ".-." );
        result.put( "s", "..." );
        result.put( "t", "-" );
        result.put( "u", "..-" );
        result.put( "v", "...-" );
        result.put( "w", ".--" );
        result.put( "x", "-..-" );
        result.put( "y", "-.--" );
        result.put( "z", "--.." );
        result.put( "1", ".----" );
        result.put( "2", "..---" );
        result.put( "3", "...--" );
        result.put( "4", "....-" );
        result.put( "5", "....." );
        result.put( "6", "-...." );
        result.put( "7", "--..." );
        result.put( "8", "---.." );
        result.put( "9", "----." );
        result.put( "0", "-----" );

        return result;
    }

}
