package com.vrrs.alg.problems.dynamicprog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.vavr.Tuple;
import io.vavr.Tuple2;

public class EditDistance {
	
	enum Operation {
		INSERT, DELETE, SUBSTITUTION, SKIP 
	}
	
	private class Edit {
		Operation op = null;
		int cost = 0, i = 0, j = 0;
		public Edit(Operation op, int cost, int i, int j) {
			this.op = op;
			this.cost = cost;
			this.i = i;
			this.j = j;
		}
		public Edit(int cost) {
			this(null, cost, 0, 0);
		}
	}
	
	public List<Edit> find(String s, String t){
		Edit[][] edits = getEditOperations(s, t);
		List<Edit> editsToS = new ArrayList<>();
		int i = s.length();
		int j = t.length();
		Edit curEdit = edits[i][j];
		while (curEdit != null && curEdit.op != null) {
			editsToS.add(curEdit);
			switch(curEdit.op) {
				case DELETE : --i;break;
				case INSERT : --j; break;
				default : --i; --j;  
			}
			curEdit = edits[i][j];
		}
		return editsToS;
	}
	
	public boolean isOneEditApart(String s, String t) {
		int diffLength = Math.abs(s.length() - t.length());
		if(diffLength <= 1) {
			Edit[][] edits = getEditOperations(s, t);
			return edits[s.length()][t.length()].cost <= 1;
		} else {
			return false;
		}
	}

	private Edit[][] getEditOperations(String s, String t) {
		Edit[][] edits = new Edit[s.length() + 1][t.length() + 1];
		for(int i = 1; i <= s.length(); i++) edits[i][0] = new Edit(Operation.DELETE, i, i, 0); //de
		for(int i = 1; i <= t.length(); i++) edits[0][i] = new Edit(Operation.INSERT, i, 0, i);
		edits[0][0] = new Edit(0);
		for(int i = 1; i <= s.length(); i++) {
			for(int j = 1; j <= t.length(); j++) {
				if(s.charAt(i-1) == t.charAt(j-1)) {
					edits[i][j] = new Edit(Operation.SKIP, edits[i-1][j-1].cost, i, j);
				} else {
					edits[i][j] = getEdit(i, j, edits);
				}
			}
		}
		return edits;
	}
	
	private Edit getEdit(int i, int j, Edit[][] edits) {
		int deleteCost = edits[i-1][j].cost + 1;
		int insertCost = edits[i][j-1].cost + 1;
		int subsCost = edits[i-1][j-1].cost + 1;
		if(deleteCost < insertCost && deleteCost < subsCost) {
			return new Edit(Operation.DELETE, deleteCost, i, j);
		} else if (insertCost < deleteCost && insertCost < subsCost) {
			return new Edit(Operation.INSERT, insertCost, i, j);
		} else {
			return new Edit(Operation.SUBSTITUTION, subsCost, i, j);
		}
	}
	

}
