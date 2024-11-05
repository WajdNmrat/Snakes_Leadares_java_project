package tests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import View.BoardView;

public class DoesWinwhite {

	@Test
	public void test() {
		 BoardView board = new BoardView();
	        // Test doesWin method when game not end yet
	 assertEquals(board.doesWin(45, 2), false);
	 assertEquals(board.doesWin(40, 3), false);
     // Test doesWin method when game ends
	 assertEquals(board.doesWin(45, 7), true);
	 assertEquals(board.doesWin(48, 2),true);
	        
	    }
	}


