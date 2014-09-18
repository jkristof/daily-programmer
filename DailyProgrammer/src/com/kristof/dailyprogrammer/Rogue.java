package com.kristof.dailyprogrammer;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class Rogue implements Runnable {

    private int movesRemaining = 100;
    private int score = 0;
    private int x = 1;
    private int y = 1;
    private String[][] playfield = generatePlayfield();

    public static void main( String[] args ) {
        Thread rogue = new Thread( new Rogue() );
        rogue.start();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner( System.in );
        generatePlayfield();

        while ( !Thread.interrupted() ) {
            if ( movesRemaining == 0 ) {
                System.out.println( "Game over! Final score: " + score );
                break;
            }
            printPlayfield();
            printStats();
            String key = scanner.nextLine();
            if ( "wasd".contains( key ) ) {
                makeMove( key );
            }
            else if ( key.equals( "q" ) ) {
                System.out.println( "You Quit!" );
                break;
            }
        }
        scanner.close();
    }

    private String[][] generatePlayfield() {
        String[][] playfield = new String[20][20];
        for ( int i = 0; i < 20; i++ ) {
            for ( int j = 0; j < 20; j++ ) {
                if ( i == 0 || j == 0 || i == 19 || j == 19 ) {
                    playfield[i][j] = "#";
                }
                else {
                    playfield[i][j] = ".";
                }
            }
        }
        Random rand = new Random( System.currentTimeMillis() );
        int objects = 0;
        while ( objects < 100 ) {
            int randomX = rand.nextInt( 20 );
            int randomY = rand.nextInt( 20 );
            if ( playfield[randomX][randomY].equals( "." ) ) {
                playfield[randomX][randomY] = "$";
                objects++;
            }
        }
        playfield[1][1] = "@";
        return playfield;

    }

    private void makeMove( String move ) {
        HashMap<String, Integer> pos = getPos( move );
        if ( !playfield[pos.get( "x" )][pos.get( "y" )].equals( "#" ) ) {
            if ( playfield[pos.get( "x" )][pos.get( "y" )].equals( "$" ) ) score++;
            playfield[x][y] = ".";
            playfield[pos.get( "x" )][pos.get( "y" )] = "@";
            x = pos.get( "x" );
            y = pos.get( "y" );
            movesRemaining--;
        }
    }

    private void printStats() {
        System.out.println( "Move: " + movesRemaining );
        System.out.println( "Score: " + score );
    }

    private void printPlayfield() {
        for ( int i = 0; i < 20; i++ ) {
            for ( int j = 0; j < 20; j++ ) {
                System.out.print( playfield[i][j] );
            }
            System.out.println();
        }
    }

    private HashMap<String, Integer> getPos( String move ) {
        HashMap<String, Integer> pos = new HashMap<String, Integer>();
        pos.put( "x", x );
        pos.put( "y", y );
        switch ( move ) {
            case "a":
                pos.put( "y", y - 1 );
                break;
            case "s":
                pos.put( "x", x + 1 );
                break;
            case "d":
                pos.put( "y", y + 1 );
                break;
            case "w":
                pos.put( "x", x - 1 );
                break;
        }
        return pos;
    }

}
