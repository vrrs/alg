package org.problems.sorting;

/**
 * compute the maximum pMean of all possible array rotations. pMean =
 * sum(i=1,i=n,Xi*i)
 * 
 * @author victor regalado
 */
public class MaxPMeanOfArrayRotationsFinder {

	public int MaxPMeanOfArrayRotations(int[] ar) {
		int total = 0;
		int pMean0 = 0;
		int n = ar.length;
		for (int i = 0; i < n; i++) {
			total += ar[i];
			pMean0 += (i + 1) * ar[i];
		}

		int Pi = pMean0;
		int maxPMean = Pi;
		for (int i = 0; i < n - 1; i++) {
			Pi += n * ar[i] - total;
			if (maxPMean < Pi)
				maxPMean = Pi;
		}
		return maxPMean;
	}

}
