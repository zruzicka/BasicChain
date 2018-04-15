package cz.zr.chain.basic;

import org.junit.Assert;
import org.junit.Test;

public class BasicChainTest {

	private final BasicChain chain = new BasicChain();

	@Test
	public void testIsChainValid__empty() {
		Assert.assertTrue(chain.isChainValid());
	}

}
