package design_patterns.strategy.match.abs;

import design_patterns.strategy.match.model.AnonymousFeature;
import design_patterns.strategy.match.model.Resume;

import java.util.List;

public interface AnonymousMatch {
	public String match(AnonymousFeature anonymousFeature,List<Resume> targetResume);
}
