package com.vrrs.alg.problems.dynamicprog;

import org.junit.Test;

import com.vrrs.alg.problems.string.RecurringCharacters;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRecurringCharacters {
	
	@Test
	public void willReturnFirstRecurringCharacter() {
		RecurringCharacters recurringCharacters = new RecurringCharacters();
		assertThat(recurringCharacters.getFirstRecurringCharacters("abca"))
		.isEqualTo('a');
		assertThat(recurringCharacters.getFirstRecurringCharacters("bcaba"))
		.isEqualTo('b');
		assertThat(recurringCharacters.getFirstRecurringCharacters("abbac"))
		.isEqualTo('a');
		assertThat(recurringCharacters.getFirstRecurringCharacters("abc"))
		.isNull();
	}

}
