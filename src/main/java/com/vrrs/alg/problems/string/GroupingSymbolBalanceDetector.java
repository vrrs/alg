package com.vrrs.alg.problems.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class GroupingSymbolBalanceDetector {
	private final Map<Character, Character> openSymbolsByClosedSymbols = new HashMap<Character, Character>();
	
	public GroupingSymbolBalanceDetector(){
		openSymbolsByClosedSymbols.put('}', '{');
		openSymbolsByClosedSymbols.put(']', '[');
		openSymbolsByClosedSymbols.put(')', '(');
	}
	
	public boolean isBalance(String expr){
		Deque<Character> stack = new ArrayDeque<Character>();
		for(Character c : expr.toCharArray()){
			if(isOpenSymbol(c))
				stack.push(c);
			else
				if (isClosedSymbol(c) && (stack.isEmpty() || !match(c,stack.pop())))	return false;
		}
		if(!stack.isEmpty()) return false;
		return true;
	}
	
	private boolean match(Character closedSymbol, Character openSymbol) {
		 return openSymbol == openSymbolsByClosedSymbols.get(closedSymbol);
	}

	private boolean isClosedSymbol(Character symbol) {
		return openSymbolsByClosedSymbols.containsKey(symbol);
	}

	private boolean isOpenSymbol(Character symbol) {
		return openSymbolsByClosedSymbols.containsValue(symbol);
	}
}
