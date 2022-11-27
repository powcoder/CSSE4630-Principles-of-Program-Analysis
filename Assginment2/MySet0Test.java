https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package string_sets;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class MySet0Test {
	@Test
	public void test1() {
		Set<String> sut = new MySet0();
		assertEquals(sut.size(), 0);
		assertTrue(sut.add("abc"));
		assertEquals(sut.size(), 1);
		assertFalse(sut.add("abc")); // repeated add
		assertEquals(sut.size(), 1);
		assertTrue(sut.add("def"));
		assertEquals(sut.size(), 2);
	}
}
