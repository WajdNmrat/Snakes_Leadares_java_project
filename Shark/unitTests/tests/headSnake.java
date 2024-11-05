package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Cell;
import Model.Color;
import Model.Snake;
import View.BoardView;

public class headSnake {

	@Test
	public void test() {
		Snake snake = new Snake("2", Color.RED, 14, 26, 12);
		Cell snakeHeadCell = new Cell(26, "Snake");
		
		int result = new BoardView().onHeadSnakeCell(snakeHeadCell, snake);
		
		assertEquals(snake.getTailPosition(), result);
	}
}
