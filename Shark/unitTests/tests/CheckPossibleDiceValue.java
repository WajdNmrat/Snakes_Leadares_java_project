package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckPossibleDiceValue {

	@Test
	public void test() {
		Mainunit object = new Mainunit();
		boolean output=object.CheckPossibleDiceValue(1);
		//test output
		assertEquals(true,output);
	}

}
