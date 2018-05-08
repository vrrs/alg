package com.vrrs.alg.problems.interview.fb;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import io.vavr.Tuple;
import io.vavr.Tuple3;

public class SpiralMatrix {
	
	public int[][] getSpiral(int n) {
		final int[][] spiral = new int[n][n];
		traverse(n, n, coord -> spiral[coord._1][coord._2] = coord._3 + 1);
		return spiral;
	}

	public List<Integer> getFlattenSpiral(int[][] spiral){
		List<Integer> flattenSpiral = new ArrayList<>();
		int m = spiral.length; int n = spiral[0].length;
		traverse(m, n, coord -> flattenSpiral.add(spiral[coord._1][coord._2]));
		return flattenSpiral;
	}
	
	private class Coord {
		int i = 0;
		int j = 0;
		private int iBound;
		private int jBound;
		
		public Coord(int iBound, int jBound) {
			this.iBound = iBound; this.jBound = jBound;
		}
		public boolean isValid() {
			return i < iBound && i >= 0 && j < jBound && j >= 0;
		}
		public void inc(int x, int y) {
			i += x; j += y;
		}
		public void dec(int x, int y) {
			i -= x; j -= y;
		}
	}
	
	private void traverse(int m, int n, Consumer<Tuple3<Integer, Integer, Integer>> func) {
		int[] jDir = new int[] { 1, 0, -1, 0 };
		int[] iDir = new int[] { 0, 1, 0, -1 };
		boolean[][] visited = new boolean[m][n];
		Coord coord = new Coord(m, n);
		for (int k = 0, dir = 0; k < m * n; k++) {
			func.accept(Tuple.of(coord.i, coord.j, k));
			visited[coord.i][coord.j] = true;
			coord.inc(iDir[dir], jDir[dir]);
			if (!coord.isValid() || visited[coord.i][coord.j]) {
				coord.dec(iDir[dir], jDir[dir]);
				dir = (dir + 1) % 4;
				coord.inc(iDir[dir], jDir[dir]);
			}
		}
	}

}
