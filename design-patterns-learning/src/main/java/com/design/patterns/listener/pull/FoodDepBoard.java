package com.design.patterns.listener.pull;


import com.design.patterns.listener.pull.abs.BlockBoard;

public class FoodDepBoard extends Interphone {

	public FoodDepBoard(BlockBoard blockBoard) {
		this.blockBoard = blockBoard;
		this.blockBoard.register(this);
	}

	@Override
	public void reciveMsg() {
		System.out.println("food has: " + this.blockBoard.getTxt());
	}
}
