package cz.zr.chain.basic;

import org.junit.Test;

public class BasicChainScenarioTest {

	private final BasicChain basicChain = new BasicChain();

	@Test
	// TODO Fix approach of last block hash access.
	public void testDemoChainScenario__initial() {
		System.out.println("Trying to Mine block 1... ");
		basicChain.addBlock(new Block("Hi im the first block", "0"));

		System.out.println("Trying to Mine block 2... ");
		basicChain.addBlock(new Block("Yo im the second block", basicChain.getLastBlockHash()));

		System.out.println("Trying to Mine block 3... ");
		basicChain.addBlock(new Block("Hey im the third block", basicChain.getLastBlockHash()));

		System.out.println("\nBlockchain is Valid: " + basicChain.isChainValid());

		System.out.println("\nThe block chain: " + basicChain.toJson());
	}
}
