package com.design.patterns.listener.pull;


import com.design.patterns.listener.pull.abs.BlockBoard;

public abstract class Interphone {

	protected BlockBoard blockBoard;

	public abstract void reciveMsg();

}
