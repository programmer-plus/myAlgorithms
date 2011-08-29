package org.codeexample.algorithm.chess.horsemove;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ChessBoard {
	private int rows, columns;

	public ChessBoard(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}

	/**
	 * Try to find the minimum-steps path that can move the horse from start
	 * point to end point, if the end point is unreachable, throw
	 * UnreachableException, otherwise return a list including all the steps, if
	 * the start and end point are same, return an empty list.
	 * 
	 * @param startPoint
	 * @param endPoint
	 * @return
	 */
	public List<Point> moveHorseTo(Horse horse, Point endPoint) {
		Point startPoint = horse.getPoint();
		if (startPoint == null) {
			throw new IllegalArgumentException(
					"You must set where the horse is: " + horse);
		}
		List<Point> paths = new ArrayList<Point>();
		if (endPoint.equals(startPoint)) {
			return paths;
		}

		Queue<Point> queue = new LinkedList<Point>();
		Set<Point> visitedPoint = new HashSet<Point>();
		queue.add(startPoint);

		while (!queue.isEmpty()) {

			Point currentPoint = queue.poll();
			visitedPoint.add(currentPoint);

			if(currentPoint.equals(endPoint))
			{
				
			}
			
		}

		return null;

	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
}
