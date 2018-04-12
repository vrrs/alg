package com.vrrs.alg.problems.codejam2018.qualification.saveuniverse;

import java.util.*;
import java.io.*;

public class Solution {
	
	public String solve(int maxDamage, String codes) {
		int totalDamage = getTotalDamage(codes);
		if(totalDamage <= maxDamage) return "0";
		int swaps = 0, curC = 0;
		long totalC = codes.chars().filter(c -> c == 'C').count();
		for (int j = codes.length() - 1; j >= 0; j--) {
			if (codes.charAt(j) == 'C') {
				for (int i = j + 1; i < codes.length() - curC; i++) {
					++swaps;
					totalDamage -= (int) Math.pow(2, totalC - curC - 1);
					if (totalDamage <= maxDamage) {
						return String.valueOf(swaps);
					}
				}
				curC++;
			}
		}
		return "IMPOSSIBLE";
	}

	private int getTotalDamage(String code) {
		int prevDamage = 0;
		int prevBeam = 1;
		for(Character c : code.toCharArray()) {
			if(c == 'S') {
				prevDamage += prevBeam;
			} else {
				prevBeam *= 2;
			}
		}
		return prevDamage;
	}

	public static void main(String[] s) {
		Solution solver = new Solution();
		Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int numOfTestCases = reader.nextInt();
	    for (int i = 1; i <= numOfTestCases; ++i) {
	      String line = reader.nextLine();
	      String[] lineParts = line.split(" ");
	      int damage = Integer.parseInt(lineParts[0]);
	      String code = lineParts[1];
	      String solution = solver.solve(damage, code);
	      System.out.println("Case #" + i + ": " + solution);
	    }
	    reader.close();
	}
}
