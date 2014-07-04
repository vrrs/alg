package org.problems.sorting;

import java.util.Comparator;
import org.markovLabs.lib.datastructures.cs.NaturalComparator;
import static org.markovLabs.lib.datastructures.cs.NaturalComparator.LESS_THAN_RELATION;

public class QuickSort {
	
	public static <T> T[] quickSort(T[] ar){
		return quickSort(ar, null);
	}
	
	public static <T> T[] quickSort(T[] ar, Comparator<T> comparator){
		int n = ar.length, size = n,  upperBound;	//size is the # of siblings selected at each level
		if (n <= 1)		return ar;	
		for(int lowerBound = 0; size > 0; ){
			upperBound = lowerBound + size >= n ? n - 1 : lowerBound + size;
			centralPivotPartition(ar, lowerBound, upperBound, comparator);
			lowerBound = upperBound + 1; //select the next set of siblings
			if(lowerBound >= n){
				size /= 2;
				lowerBound = 0;
			}
		}	
		return ar;
	}
	public static <T> T[] recursiveQuickSort(T[] ar){
		return recursiveQuickSort(ar, null);
	}
	
	public static <T> T[] recursiveQuickSort(T[] ar, Comparator<T> comparator){
		return recursiveQuickSort(ar, 0, ar.length - 1, comparator);
	}
	
	private static <T> T[] recursiveQuickSort(T[] ar, int lowerBound, int upperBound, Comparator<T> comparator){
		if(upperBound > lowerBound){
			int pivotIndex = centralPivotPartition(ar, lowerBound, upperBound, comparator);
			recursiveQuickSort(ar, lowerBound, pivotIndex - 1, comparator);
			recursiveQuickSort(ar, pivotIndex + 1, upperBound, comparator);
		}
		return ar;
	}

	public static<T> int randomPivotPartition(T[] ar, int lowerBound, int upperBound, Comparator<T> comparator){
		swap(ar, lowerBound, selectRandomPivot(lowerBound, upperBound));
		return partition(ar, lowerBound, upperBound, comparator);
	}
	
	public static<T> int centralPivotPartition(T[] ar, int lowerBound, int upperBound, Comparator<T> comparator){
		swap(ar, lowerBound, selectCentralPivot(lowerBound, upperBound));
		return partition(ar, lowerBound, upperBound, comparator);
	}
	
	private static int selectCentralPivot(int lowerBound, int upperBound){
		return (upperBound - lowerBound + 1) / 2;
	}
	
	private static int selectRandomPivot(int lowerBound, int upperBound){
		return (int) ((upperBound - lowerBound + 1) * Math.random());
	}
	
	/**
	 * Left-pivot partition routine.
	 * @param ar T array of n elems
	 * @return index j | for all i,k in [0,n), if i<=j<=k then ar[i] <= ar[j] <= ar[k]  
	 */
	private static<T> int partition(T[] ar, int lowerBound, int upperBound, Comparator<T> comparator){
		if(comparator==null)	 comparator = new NaturalComparator<T>();
		if(upperBound > lowerBound){
			T pivot = ar[lowerBound];
			int i = lowerBound + 1;
			for(int j = lowerBound + 1; j <= upperBound; j++)
				if(comparator.compare(ar[j], pivot) == LESS_THAN_RELATION)
					swap(ar, i++, j);
			swap(ar, i-1, lowerBound);
			return i-1;
		}
		return lowerBound;
	}
	
	private static<T> void swap(T[] ar, int left, int right){
		T temp = ar[left];
		ar[left] = ar[right];
		ar[right] = temp;
	}

}
