package design_patterns.listener.pull;

import design_patterns.listener.pull.abs.BlockBoard;

public abstract class Interphone {

	protected BlockBoard blockBoard;

	public abstract void reciveMsg();

}
