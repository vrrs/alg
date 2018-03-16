package com.vrrs.alg.problems.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/*
*Input Format
*The first line contains an integer N.
*The second line contains an integer K. N lines follow each integer containing the candy in the ith packet.
*
*Output Format
*A single integer which will be the minimum unfairness.
*
*Constraints
*1<=N<=105
*1<=K<=N
*0<= number of candies in any packet <=109
*/

//strategy: traverse sorted list of N. For every K elements choose rightmost and leftmost and find unfairness 
public class AngryChildren {
	private int[] elems; //the set
	private int width; // cardinality of a valid subset
	private int size; //cardinality of the set
	
    public AngryChildren(int n, int k, int[] packets) {
    	Arrays.sort(packets);
    	this.elems=packets;
    	this.size=n;
    	this.width=k;
	}
   
    public int solve() {
    	int rightmost,unfairness,min=-1;
    	for(int leftmost=0;leftmost<size;leftmost++){
    		rightmost=width+leftmost-1;
    		if(rightmost>=size)		break;
    		unfairness=elems[rightmost]-elems[leftmost];
    		if(unfairness<min || min==-1)
    			min=unfairness;
    	}
    	return min;
	}

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scanner=new Scanner(System.in);
    	int N=scanner.nextInt();
    	int K=scanner.nextInt();
    	int[] packets=new int[N];
    	for(int i=0;i<N;i++)
    		packets[i]=scanner.nextInt();
    	scanner.close();
    	AngryChildren solver=new AngryChildren(N,K,packets);
    	System.out.println(solver.solve());
	}
}
