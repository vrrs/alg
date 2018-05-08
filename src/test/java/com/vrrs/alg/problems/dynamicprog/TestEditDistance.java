package com.vrrs.alg.problems.dynamicprog;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TestEditDistance {

	@Test
	public void willFindIfTheyAreOneEditApart() {
		EditDistance editDistance = new EditDistance();
		assertThat(editDistance.isOneEditApart("cat", "dog")).isFalse();
		assertThat(editDistance.isOneEditApart("cat", "cats")).isTrue();
		assertThat(editDistance.isOneEditApart("cat", "cut")).isTrue();
		assertThat(editDistance.isOneEditApart("cat", "cast")).isTrue();
		assertThat(editDistance.isOneEditApart("cat", "at")).isTrue();
		assertThat(editDistance.isOneEditApart("cat", "act")).isFalse();
	}

}
