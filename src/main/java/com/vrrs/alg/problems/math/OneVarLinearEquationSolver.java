package com.vrrs.alg.problems.math;

import java.util.ArrayList;
import java.util.List;

import io.vavr.Tuple;
import io.vavr.Tuple2;

public class OneVarLinearEquationSolver {
	
	public double getXValue(String eq) {
		String[] exprs= eq.split("=");
		Tuple2<Integer, Integer> leftCoeficientAndconst = getCoeficientAndConst(exprs[0]);
		Tuple2<Integer, Integer> rightCoeficientAndconst = getCoeficientAndConst(exprs[1]);
		return (rightCoeficientAndconst._2 - leftCoeficientAndconst._2) / (leftCoeficientAndconst._1 - rightCoeficientAndconst._1);	
	}

	private Tuple2<Integer, Integer> getCoeficientAndConst(String expr) {
		int coe = 0;
		int constant = 0;
		for(String term : getTerms(expr)) {
			boolean isNeg = term.startsWith("-");
			int mult = isNeg ? -1 : 1;
			if(term.endsWith("x")) {
				coe += mult * getTermValue(isNeg, term); 
			} else {
				constant += mult * getTermValue(isNeg, term + "x"); 
			}
		}
		return Tuple.of(coe, constant);
	}

	private int getTermValue(boolean isNeg, String term) {
		int i = isNeg ? 1 : 0;
		String val = term.substring(i, term.length() - 1);
		return val.equals("") ? 1 : Integer.parseInt(val);
	}

	private List<String> getTerms(String expr) {
		List<String> terms = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			if(i == 0) {
				builder.append(c);continue;
			}
			if(c == '+' || c == '-') {
				terms.add(builder.toString());
				builder = new StringBuilder();
				if(c == '-') builder.append('-');
			} else builder.append(c);
		}
		terms.add(builder.toString());
		return terms;
	}

}
