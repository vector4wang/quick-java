package design_patterns.strategy.match.abs;

import design_patterns.strategy.match.model.AnonymousFeature;
import design_patterns.strategy.match.model.Resume;

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
