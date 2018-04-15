package com.vrrs.alg.problems.dynamicprog;

public class LongestIncreasingSequenceFinder {
	
	public int[] find(int[] seq) {
		int[][] elems = new int[seq.length][];
		elems[0] = new int[]{seq[0]};
		int iIndex = 0;
		for(int i = 0; i < seq.length; i++) {
			int jIndex = 0, length = 1;
			for(int j = 0; j < i; j++) {
				int curLength = elems[j].length;
				if(seq[j] < seq[i]) {
					curLength = elems[j].length + 1;
				}
				if(curLength > length)	{
					length = curLength;
					jIndex = j;
				}
			}
			elems[i] = new int[length];
			elems[i][length - 1] = seq[i];
			for(int l = 0; l < length - 1; l++)	elems[i][l] = elems[jIndex][l];
			if(length > elems[iIndex].length) {
				iIndex = i;
			}
		}
		return elems[iIndex];
	}

}
