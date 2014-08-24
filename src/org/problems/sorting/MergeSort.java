package org.problems.sorting;

public class MergeSort implements Sort{
	
	public void sort(int[] ar) {
		int n =  ar.length, size = 1, lb = 0, ub = 0;
		while( size < n ){
			if ((ub = 2*size + lb - 1) >= n )  ub = n - 1;
			merge(lb, size, ub, ar);
			lb = ub + 1;
			if(lb >= n)  {
				size *= 2;
				lb = 0;
			}
		}
	}
		 
	// first_list= ar[lb..lb + mid-1] and second_list= ar[lb + mid..ub] 
	private void merge(int lb, int mid, int ub, int[] ar){
		int i = lb ,j = lb + mid, k = 0;
		int[] out = new int[ub - lb + 1];
		while( (i <= lb + mid - 1) && (j <= ub)){
		   if(ar[i] <= ar[j])   out[k++] = ar[i++];
		     else  out[k++] = ar[j++];
		}
		while(i <= lb + mid - 1)  out[k++] = ar[i++];
		while(j <= ub)       	  out[k++] = ar[j++];
		for(int l = 0; l < k; l++)  ar[lb + l] = out[l];
	}

}
