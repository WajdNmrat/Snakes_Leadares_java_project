package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class nextpositionblack {

	@Test
	public void test() {
		Mainunit object2 = new Mainunit();
		int output_f = object2.nextPosition(9, 4, 8);
		//test output
		assertEquals(8,output_f);
		//check negative numbers
		 output_f = object2.nextPosition(-12, -10,-12);
		//test output
		assertEquals(-22,output_f);
		//check negative with positive numbers
		 output_f = object2.nextPosition(-1, 3, -2);
		//test output
		assertEquals(-2,output_f);
		
		

	}

}
