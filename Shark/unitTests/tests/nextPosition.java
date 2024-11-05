package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class nextPosition {

	@Test
	public void test() {
		Mainunit object2 = new Mainunit();
		int output_f = object2.nextPosition(9, 4, 8);
		//test output
		assertEquals(8,output_f);
	}

}
