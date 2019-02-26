package com.design.patterns.strategy.match.abs;


import com.design.patterns.strategy.match.model.AnonymousFeature;
import com.design.patterns.strategy.match.model.Resume;

import java.util.List;

public abstract class AbstractTargetWaitMatchData implements TargetWaitMatchData {

	private List<Resume> targetResumes;

	public AbstractTargetWaitMatchData(AnonymousFeature anonymousFeature) {
		this.targetResumes = getTargetWaitMatchDate(anonymousFeature);
	}


	public List<Resume> get() {
		return targetResumes;
	}
}
