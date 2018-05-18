package com.vrrs.alg.problems.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BoggleSolver {
	
	private static class Cell {
		int i;
		int j;
		public Cell(int i, int j) {
			this.i = i;
			this.j = j;
		}
		public int hashCode() {
			return (String.valueOf(i) + "*" + String.valueOf(j)).hashCode();
		}
		public boolean equals(Object that) {
			Cell other = (Cell) that;
			return other.hashCode() == this.hashCode();
		}
	}
	
	public Set<String> getPossibleWords(Set<String> dict, char[][] boggle){
		Set<String> posWords = new HashSet<>();
		Set<Cell> visitedCells = new LinkedHashSet<>();
		for(int i = 0; i< boggle.length; i++) {
			for(int j = 0; j < boggle[i].length; j++) {
				Cell rootCell = new Cell(i, j);
				visitedCells.add(rootCell);
				findPossibleWords(rootCell, dict, boggle, visitedCells, posWords);
				visitedCells.remove(rootCell);
			}
		}
		return posWords;
	}

	private void findPossibleWords(Cell cell, Set<String> dict, char[][] boggle, Set<Cell> visitedCells,
			Set<String> posWords) {
		String cellStr = toString(visitedCells, boggle);
		if (dict.contains(cellStr)) posWords.add(cellStr);
		List<Cell> adjCells = getAdjacentCells(cell, boggle, visitedCells);
		for (Cell adjCell : adjCells) {
			visitedCells.add(adjCell);
			findPossibleWords(adjCell, dict, boggle, visitedCells, posWords);
			visitedCells.remove(adjCell);
		}
	}

	private String toString(Set<Cell> visitedCells, char[][] boggle) {
		StringBuilder builder = new StringBuilder();
		for(Cell cell : visitedCells) {
			builder.append(boggle[cell.i][cell.j]);
		}
		return builder.toString();
	}

	private List<Cell> getAdjacentCells(Cell cell, char[][] boggle, Set<Cell> visitedCells) {
		List<Cell> adjCells = new ArrayList<>();
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				Cell newCell = new Cell(cell.i + i, cell.j + j);
				if(newCell.i >= 0 && newCell.j >= 0 && newCell.i < boggle.length && newCell.j < boggle[newCell.i].length 
						&& !visitedCells.contains(newCell)) {
					adjCells.add(newCell);
				}
			}
		}
		return adjCells;
	}

}
