package com.kristof.dailyprogrammer;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class Blackjack {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Enter number of decks:" );
        int decks = Integer.parseInt( scanner.nextLine() );
        scanner.close();
        int numOfBlackjacks = 0;
        ArrayList<String> shoe = buildShoe( decks );
        ArrayList<String> winningHands = new ArrayList<String>();
        int i = 0;
        while ( shoe.size() > 1 ) {
            int handValue = getCardValue( shoe.get( 0 ) ) + getCardValue( shoe.get( 1 ) );
            if ( shoe.get( 0 ).contains( "A" ) && shoe.get( 1 ).contains( "A" ) ) handValue = 21;
            if ( handValue == 21 ) {
                numOfBlackjacks++;
                winningHands.add( shoe.get( 0 ) + " " + shoe.get( 1 ) );
            }
            if ( handValue <= 11 ) {
                handValue = getCardValue( shoe.get( 0 ) ) + getCardValue( shoe.get( 1 ) ) + getCardValue( shoe.get( 2 ) );
                if ( handValue == 21 ) {
                    numOfBlackjacks++;
                    winningHands.add( shoe.get( 0 ) + " " + shoe.get( 1 ) + " " + shoe.get( 2 ) );
                }
                shoe.remove( 0 );
            }
            shoe.remove( 0 );
            shoe.remove( 0 );
            i++;
        }
        NumberFormat pf = NumberFormat.getPercentInstance();
        System.out.printf( "After %d hands there %s %d blackjack%s (%s)\n", i, ( numOfBlackjacks == 1 ? "was" : "were" ), numOfBlackjacks,
                           ( numOfBlackjacks == 1 ? "" : "s" ), pf.format( (float)numOfBlackjacks / (float)i ) );
        for ( String hand : winningHands )
            System.out.println( hand );
    }

    private static ArrayList<String> buildShoe( int decks ) {
        ArrayList<String> shoe = new ArrayList<String>();
        String[] suits = { "♦", "♣", "♥", "♠" };
        String[] values = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        String[] deck = new String[52];
        int i = 0;
        for ( String suit : suits ) {
            for ( String value : values ) {
                deck[i] = value + suit;
                i++;
            }
        }
        for ( int j = 0; j < decks; j++ ) {
            shoe.addAll( Arrays.asList( deck ) );
        }
        long seed = System.nanoTime();
        Collections.shuffle( shoe, new Random( seed ) );
        return shoe;
    }

    private static Integer getCardValue( String card ) {
        return Integer.parseInt( card.replaceAll( "[♦,♣,♥,♠]", "" ).replaceAll( "[A]", "11" ).replaceAll( "[J,Q,K]", "10" ) );
    }

}
