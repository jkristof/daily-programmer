package com.kristof.dailyprogrammer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UpsideDown {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your text:");
        ArrayList<String> input = new ArrayList<String>();
        String line = null;
        while(!(line = scanner.nextLine()).isEmpty() ) {
            input.add( line );
        }
        scanner.close();
        HashMap<Character, Character> charMap = new HashMap<Character, Character>();
        String normalAscii = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890?!. ";
        String updAscii = "ɐqɔpǝɟƃɥᴉɾʞlɯuodbɹsʇnʌʍxʎz∀qƆpƎℲפHIſʞ˥WNOԀQɹS┴∩ΛMX⅄ZƖᄅƐㄣϛ9ㄥ860¿¡˙ ";
        for ( int i = 0; i < normalAscii.length(); i++) {
            charMap.put( normalAscii.charAt( i ), updAscii.charAt( i ) );
        }
        StringBuffer output = new StringBuffer();
        for ( int i = input.size() - 1; i >= 0; i-- ) {
            StringBuilder tmpSB = new StringBuilder(input.get( i )).reverse();
            for ( int j = 0; j < tmpSB.length(); j++ ) {
                tmpSB.setCharAt( j, charMap.get( tmpSB.charAt( j ) ) );
            }
            output.append( tmpSB.toString() + "\n" );
        }
        System.out.println( output.toString() );
    }

}
