package com.vrrs.alg.cs.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class TestHashTable {
	
	@Test
	public void willAddAndRemoveElems() {
		Set<Integer> table = new HashTable<>(5);
		assertThat(table.addAll(ImmutableList.of(1,2,3,4,5,6,10,7,8,9,10))).isTrue();
		assertThat(table).hasSize(10);
		assertThat(table.remove(11)).isFalse();
		assertThat(table.remove(8)).isTrue();
		assertThat(table).hasSize(9);
	}

}
