package com.vrrs.alg.problems.graph;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

public class TestBoggleSolver {
	
	@Test
	public void willFindAllPossibleWordsInBoggle() {
	    char[][] boggle = new char[][]{{'G','I','Z'},
	                         {'U','E','K'},
	                         {'Q','S','E'}};
	    Set<String> dict = ImmutableSet.of("GEEKS", "FOR", "QUIZ", "GO");
	    assertThat(new BoggleSolver().getPossibleWords(dict, boggle))
	    .containsExactlyInAnyOrder("GEEKS", "QUIZ");
	}

}
