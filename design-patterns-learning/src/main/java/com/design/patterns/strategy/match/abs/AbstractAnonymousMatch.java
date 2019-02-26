package com.design.patterns.strategy.match.abs;


import com.design.patterns.strategy.match.model.AnonymousFeature;

public abstract class AbstractAnonymousMatch implements AnonymousMatch {

	private AnonymousFeature anonymousFeature;

	private AbstractTargetWaitMatchData abstractTargetWaitMatchData;

	public AbstractAnonymousMatch(AnonymousFeature anonymousFeature, AbstractTargetWaitMatchData targetWaitMatchData) {
		this.anonymousFeature = anonymousFeature;
		this.abstractTargetWaitMatchData = targetWaitMatchData;
	}

	public String doMatch() {
		return match(anonymousFeature, abstractTargetWaitMatchData.get());
	}
}
