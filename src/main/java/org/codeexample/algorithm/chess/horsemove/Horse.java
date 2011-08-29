package org.codeexample.algorithm.chess.horsemove;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Horse implements Iterable<Point> {

	private String name;

	private Point point;

	private ChessBoard chessBoard;

	public Horse() {
		super();
	}

	public Horse(String name, ChessBoard chessBoard, Point point) {
		super();
		this.name = name;
		this.chessBoard = chessBoard;
		this.point = point;
		if (!isValidPoint(point)) {
			throw new IllegalArgumentException("ponit is not valid: " + point);
		}
	}

	/*
	 * Returns an iterator over a set of all possible next positions this horse
	 * can move to. @return an Iterator.
	 */
	@Override
	public Iterator<Point> iterator() {
		return new NextPositionIter();
	}

	private class NextPositionIter implements Iterator<Point> {

		Point startPoint, currentPoint;

		// the two-dimensional array that lists all possible delta in
		// anti-clockwise.
		private int[][] horseDeltas = { { 2, 1 }, { 1, 2 }, { -1, 2 },
				{ -2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 } };

		private int deltaSize = horseDeltas.length;

		// current position in the horse deltas array
		// index of next element to returns
		private int cursor = 0;

		@Override
		public boolean hasNext() {

			if (cursor >= deltaSize)
				return false;

			while (cursor <= deltaSize) {
				Point nextPoint = new Point(point.getX()
						+ horseDeltas[cursor][0], point.getY()
						+ horseDeltas[cursor][1]);
				if (isValidPoint(nextPoint)) {
					return true;
				} else {
					++cursor;
				}
			}
			return false;
		}

		@Override
		public Point next() {
			// call hasNext() again to do the check in case user doesn't call
			// hasNext() before call this method.
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return new Point(point.getX() + horseDeltas[cursor][0], point
					.getY()
					+ horseDeltas[cursor][1]);
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	private boolean isValidPoint(Point point) {
		boolean valid = true;
		if (point.getX() < 0 || point.getY() < 0
				|| point.getX() > chessBoard.getColumns() - 1
				|| point.getY() > chessBoard.getRows() - 1) {
			valid = false;
		}
		return valid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public ChessBoard getChessBoard() {
		return chessBoard;
	}
}
