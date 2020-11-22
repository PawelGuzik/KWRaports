package kw.raport.model.utils;

import java.util.HashMap;
import java.util.Map;

public class ContolNumberCalc {

	private static Map<Character, Integer> characterValueMap = new HashMap<Character, Integer>();

	private ContolNumberCalc() {
		characterValueMap.put('0', 0);
		characterValueMap.put('1', 1);
		characterValueMap.put('2', 2);
		characterValueMap.put('3', 3);
		characterValueMap.put('4', 4);
		characterValueMap.put('5', 5);
		characterValueMap.put('6', 6);
		characterValueMap.put('7', 7);
		characterValueMap.put('8', 8);
		characterValueMap.put('9', 9);
		characterValueMap.put('X', 10);
		characterValueMap.put('A', 11);
		characterValueMap.put('B', 12);
		characterValueMap.put('C', 13);
		characterValueMap.put('D', 14);
		characterValueMap.put('E', 15);
		characterValueMap.put('F', 16);
		characterValueMap.put('G', 17);
		characterValueMap.put('H', 18);
		characterValueMap.put('I', 19);
		characterValueMap.put('J', 20);
		characterValueMap.put('K', 21);
		characterValueMap.put('L', 22);
		characterValueMap.put('M', 23);
		characterValueMap.put('N', 24);
		characterValueMap.put('O', 25);
		characterValueMap.put('P', 26);
		characterValueMap.put('R', 27);
		characterValueMap.put('S', 28);
		characterValueMap.put('T', 29);
		characterValueMap.put('U', 30);
		characterValueMap.put('W', 31);
		characterValueMap.put('Y', 32);
		characterValueMap.put('Z', 33);
	}

	public static Boolean isCorrect(String kWnumberPart1, String kWnumberPart2, int controlNumber) {
		new ContolNumberCalc();
		if(kWnumberPart2.length()<8) {
			for(int i = 0; i< 8-kWnumberPart2.length(); i++) {
				kWnumberPart1 = kWnumberPart1.concat("0");
			}
		}
		String combinedNumber = kWnumberPart1.concat(kWnumberPart2);
		int result = 0;
		int multiplier = 0;

		for (int i = 0; i < 12; i++) {

			if (i == 0 || i == 3 || i == 6 || i == 9) {
				multiplier = 1;
				result += multiplier * characterValueMap.get(combinedNumber.charAt(i));

			} else if (i == 1 || i == 4 || i == 7 || i == 10) {
				multiplier = 3;
				result += multiplier * characterValueMap.get(combinedNumber.charAt(i));
			} else {
				multiplier = 7;
				result += multiplier * characterValueMap.get(combinedNumber.charAt(i));
			}
		}
		result = result % 10;
		return result == controlNumber;
	}

}
