package design_patterns.listener.pull;

import design_patterns.listener.pull.abs.BlockBoard;

public class TestMain {
	public static void main(String[] args) {
		BlockBoard blockBoard = new BlockBoard();
		new FoodDepBoard(blockBoard);
		blockBoard.setTxt("麻辣鸡丝");
	}
}
