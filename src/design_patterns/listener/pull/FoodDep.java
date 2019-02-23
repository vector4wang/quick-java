package design_patterns.listener.pull;

import design_patterns.listener.pull.abs.BlockBoard;

public class FoodDep extends Interphone {


	public FoodDep(BlockBoard blockBoard) {
		this.blockBoard = blockBoard;
		this.blockBoard.register(this);
	}


	@Override
	public void reciveMsg() {
		System.out.println("food has: " + this.blockBoard.getTxt());
	}
}
