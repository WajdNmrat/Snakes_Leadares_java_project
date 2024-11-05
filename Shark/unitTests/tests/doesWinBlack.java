package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import View.BoardView;

public class doesWinBlack {

	@Test
	public void test() {
		 
		 BoardView board = new BoardView();
	        
			// Test doesWin method when negative input
		 assertEquals(board.doesWin(-45, -10), false);
		 assertEquals(board.doesWin(-40, -3), false);
	        // Test doesWin method when illogical input
		 assertEquals(board.doesWin(55,-2), true);
		 assertEquals(board.doesWin(50,-6),false);
	    }

}
