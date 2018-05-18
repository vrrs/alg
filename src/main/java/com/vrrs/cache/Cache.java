package com.vrrs.cache;

import java.util.Optional;

public interface Cache <K, V> {
	
	Optional<V> get(K key) throws KeyNotFoundException;
	void put(K key, V value);
	
	public static class KeyNotFoundException extends RuntimeException{

		private static final long serialVersionUID = 1L;
		
		public KeyNotFoundException(String msg) {
			super(msg);
		}
	}
}
