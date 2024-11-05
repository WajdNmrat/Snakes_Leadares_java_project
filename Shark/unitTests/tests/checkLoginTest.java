package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class checkLoginTest {

	@Test
	public void test() {
		Mainunit object = new Mainunit();
		boolean output=object.checkLogin("admin", "123");
		//test output
		assertEquals(true,output);
	}

}
