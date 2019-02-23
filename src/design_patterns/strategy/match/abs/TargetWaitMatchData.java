package design_patterns.strategy.match.abs;

import design_patterns.strategy.match.model.AnonymousFeature;
import design_patterns.strategy.match.model.Resume;

import java.util.List;

public interface TargetWaitMatchData {
	List<Resume> getTargetWaitMatchDate(AnonymousFeature anonymousFeature);
}
