package com.vrrs.alg.problems.codejam2018.qualification.troublesort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public String solve(List<Integer> ar) {
		troubleSort(ar);
		for(int i = 0; i < ar.size() - 1; i++) {
			if(ar.get(i + 1) < ar.get(i)) {
				return String.valueOf(i);
			}
		}
		return "OK";
	}

	private void troubleSort(List<Integer> ar) {
		boolean done = false;
		while(!done) {
			done = true;
			for(int i = 0; i < ar.size() - 2; i++) {
				if(ar.get(i) > ar.get(i+2)) {
					done = false;
					int first = ar.get(i);
					ar.set(i, ar.get(i+ 2));
					ar.set(i + 2, first);
				}
			}
		}
	}
	
	public static void main(String[] s) {
		Solution solver = new Solution();
		Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int numOfTestCases = reader.nextInt();
	    for (int i = 1; i <= numOfTestCases; i++) {
	      int size = reader.nextInt();
	      List<Integer> ar = new ArrayList<>();
	      for(int j = 0; j < size; j++) {
	    	  ar.add(reader.nextInt());
	      }
	      String solution = solver.solve(ar);
	      System.out.println("Case #" + i + ": " + solution);
	    }
	    reader.close();
	}

}
