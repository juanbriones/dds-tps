package tests;

import org.junit.Test;

import persistance.ModelManager;

public class ContextTest {

	@Test
	public void contextUp() {
		ModelManager.getManager();
	}
}
