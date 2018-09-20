package resume_match;

import resume_match.feature.AnonymousResumeFeature;
import resume_match.feature.TargetResumeFeature;

import java.util.List;

/**
 * @author vector
 * @Data 2018/9/19 0019
 * @Description TODO
 */
public abstract class AbstractMatch implements AnonymousMatchInterface {

	boolean isLastName = false;
	boolean isNameLess = false;

	private AnonymousResumeFeature anonymousResumeFeature;

	public AbstractMatch(AnonymousResumeFeature anonymousResumeFeature) {
		this.anonymousResumeFeature = anonymousResumeFeature;
		if (this.anonymousResumeFeature.getRealName() == "") {
			isNameLess = true;
		} else if (this.anonymousResumeFeature.getRealName().length() == 1) {
			isLastName = true;
		}

	}

	abstract List<TargetResumeFeature> getTargetResumeFeature();

	@Override
	public String match() {
		List<TargetResumeFeature> targetResumeFeature = getTargetResumeFeature();
		return getOptionVal(anonymousResumeFeature, targetResumeFeature);
	}

	private String getOptionVal(AnonymousResumeFeature anonymousResumeFeature,
			List<TargetResumeFeature> targetResumeFeature){
		return targetResumeFeature.get(0).getRealName();
	}
}
