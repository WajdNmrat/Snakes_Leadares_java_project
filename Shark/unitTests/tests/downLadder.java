package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Cell;
import Model.Ladder;
import View.BoardView;

public class downLadder {

	@Test
	public void test() {
		
		Ladder l = new Ladder("1",3,10,30);
		Cell c = new Cell(10,"ladderCell");
		
		int result = new BoardView().onDownLadderCell(c, l);
		
		assertEquals(l.getTopPosition(), result);
				
		
	}

}
