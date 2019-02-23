package design_patterns.strategy.match;

import design_patterns.strategy.match.abs.AbstractAnonymousMatch;
import design_patterns.strategy.match.abs.AbstractTargetWaitMatchData;
import design_patterns.strategy.match.model.AnonymousFeature;
import design_patterns.strategy.match.model.Resume;

import java.util.List;

public class FullNameMatch extends AbstractAnonymousMatch {

	public FullNameMatch(AnonymousFeature anonymousFeature, AbstractTargetWaitMatchData targetWaitMatchData) {
		super(anonymousFeature, targetWaitMatchData);
	}

	@Override
	public String match(AnonymousFeature anonymousFeature, List<Resume> targetResume) {
		System.out.println("这是全姓名匹配，已经做好比对，调用API1");
		return "FULL_NAMEM_ATCH";
	}

}
