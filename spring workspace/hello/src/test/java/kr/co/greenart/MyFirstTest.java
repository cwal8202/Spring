package kr.co.greenart;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.co.greenart.model.User;

public class MyFirstTest {

	@Test
	public void test() {
//		fail("Not yet implemented");
		int a = 10;
		int b = 20;
		
		int sum = a + b;
		assertEquals(sum, 30);
	}
	
	@Test
	public void test2() {
		String abc = "abc";
		String abc2 = abc;
		
		assertSame(abc, abc2);
	}
	
	@Test
	public void test3() {
		User u = new User();
		
		assertNotNull(u);
	}
}
