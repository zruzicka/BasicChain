package cz.zr.chain.basic;

import java.util.ArrayList;
import java.util.List;

public class BasicChain {

	public static final List<Block> blockchain = new ArrayList<Block>();
	public static final int difficulty = 5;

	/**
	 * @return
	 */
	public static boolean isChainValid() {
		Block currentBlock;
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');

		// loop through blockchain to check hashes:
		for (int i = 1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i - 1);
			// compare registered hash and calculated hash:
			if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
				System.out.println("Current Hashes not equal");
				return false;
			}
			// compare previous hash and registered previous hash
			if (!previousBlock.hash.equals(currentBlock.previousHash)) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			// check if hash is solved
			if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}

		}
		return true;
	}

	/**
	 * @param newBlock
	 */
	public static void addBlock(Block newBlock) {
		newBlock.mineBlock(difficulty);
		blockchain.add(newBlock);
	}

	/**
	 * @return
	 */
	public String getLastBlockHash() {
		return blockchain.get(blockchain.size()-1).hash;
	}

	/**
	 * @return
	 */
	public String toJson() {
		return StringUtil.getJson(blockchain);
	}
}
