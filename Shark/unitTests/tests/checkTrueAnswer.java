package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class checkTrueAnswer {

	@Test
	public void test() {
		Mainunit object = new Mainunit();
		boolean output=object.checkTrueAnswer(3);
		//test output
		assertEquals(true,output);
	}

}
