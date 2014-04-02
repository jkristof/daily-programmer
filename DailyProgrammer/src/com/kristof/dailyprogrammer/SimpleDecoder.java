package com.kristof.dailyprogrammer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SimpleDecoder {

    public static void main( String[] args ) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter location of text file to parse:");
        BufferedReader br = new BufferedReader(new FileReader(scanner.next()));
        scanner.close();
        String line;
        String result = "";
        while ((line = br.readLine()) != null) {
            for ( char c : line.toCharArray() ) {
                result += String.valueOf( (char) (c - 4) );
            }
            result += "\n";
        }        
        System.out.println( result );
    }

}
