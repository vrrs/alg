package com.vrrs.alg.problems.hackerrank;

import java.util.Scanner;

public class ChocolateFeast {
	public int solve(int n,int c,int m ){
		int candys = n / c;
		int candysOffered=candys;
		int candysOfferedTemp;
		while((candysOfferedTemp = candysOffered / m) > 0){
			candys+=candysOfferedTemp;
			candysOffered= candysOfferedTemp + candysOffered % m;
		}
		return candys;
	}
	
	public static void main(String[] s){
		Scanner scanner=new Scanner(System.in);
		int T=scanner.nextInt();
		int n,c,m;
		ChocolateFeast solver=new ChocolateFeast();
		for(int i=0;i<T;i++){
			  n=scanner.nextInt();
			  c=scanner.nextInt();
			  m=scanner.nextInt();
			  System.out.println(solver.solve(n,c,m));
		}
		scanner.close();
	}
}
