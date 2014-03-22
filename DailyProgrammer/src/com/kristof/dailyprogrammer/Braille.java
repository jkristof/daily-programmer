package com.kristof.dailyprogrammer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Braille {

	public static void main(String[] args) throws Exception {
		ArrayList<String> letters = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter location of text file to parse:");
		BufferedReader br = new BufferedReader(new FileReader(scanner.next()));
		scanner.close();
		String line;
		int j = 0;
		while ((line = br.readLine()) != null) {
			String[] temp = line.split(" ");
			for (int i = 0; i < temp.length; i++) {
				if (j==0) {
					letters.add(temp[i]);
				} else {
					letters.set(i, letters.get(i) + temp[i]);
				}
			}
			j++;
		}
		br.close();
		for ( String letter : letters ) {
			if (getAlphabet().containsKey( letter )) System.out.print( getAlphabet().get(letter) );
		}
	}

	static HashMap<String, String> getAlphabet() {
		HashMap<String, String> result = new HashMap<String, String>();
		
		result.put("O.....", "a");
		result.put("O.O...", "b");
		result.put("OO....", "c");
		result.put("OO.O..", "d");
		result.put("O..O..", "e");
		result.put("OOO...", "f");
		result.put("OOOO..", "g");
		result.put("O.OO..", "h");
		result.put(".OO...", "i");
		result.put(".OOO..", "j");
		result.put("O...O.", "k");
		result.put("O.O.O.", "l");
		result.put("OO..O.", "m");
		result.put("OO.OO.", "n");
		result.put("O..OO.", "o");
		result.put("OOO.O.", "p");
		result.put("OOOOO.", "q");
		result.put("O.OOO.", "r");
		result.put(".OO.O.", "s");
		result.put(".OOOO.", "t");
		result.put("O...OO", "u");
		result.put("O.O.OO", "v");
		result.put(".OOO.O", "w");
		result.put("OO..OO", "x");
		result.put("OO.OOO", "y");
		result.put("O..OOO", "z");
		
		return result;
	}

}
