package hackerRank;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
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
	private int[] elems;
	private int[] edges;
	private int height;
	private int breadth;
	private int size;
	
    public AngryChildren(int n, int k, int[] packets) {
    	this.elems=packets;
    	this.height=n;
    	this.breadth=2;
    	this.size=k;  //max size of a valid set
    	edges=new int[height];
    	for(int i=0;i<height;i++)	edges[i]=0;
    	
	}
    
    public Integer peek(int level){
    	if(edges[level] == breadth){
    		edges[level]=0;
    		return null;
    	}
    	Integer result=edges[level];
    	edges[level]+=1;
    	return result;
    }
    
    public int solve() {
    	Integer elem;
    	int level=0;
    	Deque<Integer> closed=new ArrayDeque<Integer>();
    	List<Integer> unfairnessList=new ArrayList<Integer>();
    	int closedSize=0;
    	while(level>=0){
    		if((elem=peek(level))==null){
    			level--;
    			elem=closed.pollFirst();
    			if(elem!=null)
    				closedSize-= elem==1 ? 1 : 0;
    			continue;
    		}
    		level++;
    		closed.push(elem);
    		if(elem==1)
    			closedSize++;
    		if(closedSize==size){
    			unfairnessList.add(unfairness(closed));
    			level--;
    			elem=closed.pollFirst();
    			if(elem!=null)
    				closedSize-= elem==1 ? 1 : 0;
    			continue;
    		}
    		if(level==height){
    			level--;
    			elem=closed.pollFirst();
    			if(elem!=null)
    				closedSize-= elem==1 ? 1 : 0;
    			continue;
    		}
    	}
    	int min=unfairnessList.get(0);
    	int val;
    	for(int i=1;i<unfairnessList.size();i++){
    		val=unfairnessList.get(i);
    		if(min>val)
    			min=val;
    	}
    	return min;
	}

	private Integer unfairness(Deque<Integer> closed) {
		Iterator<Integer> iter=closed.iterator();
		int level=-1;
		int min=-1;
		int max=0;
		while(iter.hasNext()){
			Integer val=iter.next();
			level++;
			if(val==1){
				if(min==-1)
					min=elems[level];
				max=elems[level];
			}
		}
		return max-min;
	}

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scanner=new Scanner(System.in);
    	int N=Integer.parseInt(scanner.next());
    	int K=Integer.parseInt(scanner.next());
    	int[] packets=new int[N];
    	for(int i=0;i<N;i++)
    		packets[i]=Integer.parseInt(scanner.next());
    	scanner.close();
    	Arrays.sort(packets);
    	AngryChildren solver=new AngryChildren(N,K,packets);
    	System.out.println(solver.solve());
	}
}
