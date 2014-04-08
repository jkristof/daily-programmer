package com.kristof.dailyprogrammer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;


public class LanguageDetector {

    public static void main( String[] args ) throws Exception {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Enter line to parse: " );
        String phrase = scanner.nextLine();
        scanner.close();
        checkLangugages(phrase);
    }

    private static HashMap<String, String> dictionaryList() {
        HashMap<String, String> list = new HashMap<String, String>();

        list.put( "german", "german.txt" );
        list.put( "english", "english.txt" );
        list.put( "french", "french.txt" );
        list.put( "spanish", "spanish.txt" );
        list.put( "portuguese", "portuguese.txt" );

        return list;
    }
    
    private static void checkLangugages(String phrase) throws Exception {
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();
        HashMap<String, Double> map = new HashMap<String, Double>();
        for ( String langugage : dictionaryList().keySet()) map.put( langugage, checkLanguage( phrase, langugage ) );    
        ValueComparator bvc = new ValueComparator(map);
        TreeMap<String, Double> sortedResults = new TreeMap<String,Double>(bvc);
        sortedResults.putAll( map );
        for ( Entry<String, Double> result : sortedResults.entrySet() ) {
            if ( result.getValue() > .40 ) System.out.println( result.getKey() + " " + percentFormatter.format(result.getValue()));
            if ( result.getValue() > .90 ) break;
        }
    }

    private static double checkLanguage( String phrase, String language ) throws Exception {
        String encoding = "UTF-16";
        if ( language.equals( "english" )) encoding = "ASCII";
        Reader reader = new InputStreamReader( new FileInputStream( dictionaryList().get( language ) ) , encoding );
        BufferedReader br = new BufferedReader( reader );
        String[] phraseSplit = phrase.split( " " );
        String line;
        double j = 0;
        while ( ( line = br.readLine() ) != null ) {
            for ( String word : phraseSplit ) {
                if ( line.toLowerCase().trim().equals( word.toLowerCase() ) ) {
                    j++;
                }
            }
        }
        br.close();
        return j/phraseSplit.length;
    }

}

class ValueComparator implements Comparator<String> {

    Map<String, Double> base;
    public ValueComparator(Map<String, Double> base) {
        this.base = base;
    }

    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}
