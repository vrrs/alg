package other;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.markovLabs.lib.datastructures.cs.FixedSimplePriorityQueue;

/**
 * @author victor regalado 
 * Print all the permutations of a given string without caching previous computed results. 
 * This problem is given by AppNexus
 */
public class StringPermutations {
	private String word;
	private Character[] letterSet;
	private final Map<Character, Integer> multiplicity = new HashMap<Character, Integer>();
	private int height;
	
	public StringPermutations(String w) {
		height=w.length();
		word=w;
	}
	
	private String prnt(Deque<Character> c){
		StringBuilder s=new StringBuilder();
		Iterator<Character> iter=c.iterator();
		while(iter.hasNext()){
			s.append(iter.next());
		}
		return s.toString();
	}

	public void printPermutations() {
		char[] chars = word.toCharArray();
		Set<Character> set=new HashSet<Character>();
		for (int i = 0; i < chars.length; i++) {
			Character c = chars[i];
			set.add(c);
			Integer counter = multiplicity.get(c);
			if (counter == null)
				counter = 0;
			multiplicity.put(c, ++counter);
		}
		letterSet=new Character[set.size()];
		set.toArray(letterSet);
		search(); 
	}
	
	public void search(){
		int level=0;
		FixedSimplePriorityQueue<Character> open=new FixedSimplePriorityQueue<Character>(letterSet,height);
		Deque<Character> closed=new ArrayDeque<Character>();
		Character elem;
		
		while(level>=0){
			if((elem=open.peek(level))==null){
				level--;
				backtrack(closed.pollFirst());
				continue;
			}
			if(!valid(elem))	continue;
			level++;
			closed.addFirst(elem);
			if(level==height){
				actionHandler(closed);
				level--;
				backtrack(closed.pollFirst());
			}
		}
	}

	protected void actionHandler(Deque<Character> path) {
		System.out.println(prnt(path));
	}


	protected boolean valid(Character elem) {
		Integer counter=multiplicity.get(elem);
		if(counter==0)
			return false;
		multiplicity.put(elem, --counter);
		return true;
	}
	

	protected void backtrack(Character elem) {
		if(elem!=null){
			Integer counter=multiplicity.get(elem);
			multiplicity.put(elem,++counter);
		}
	}
	
	public static void main(String[] s) {
		String word;
		if (s.length == 0) {
			word="vicc";
		}
		else{
			word=s[0];
		}
		StringPermutations permutator=new StringPermutations(word);
		permutator.printPermutations();
	}
}
