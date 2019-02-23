//package resume_match;
//
//import resume_match.feature.AnonymousResumeFeature;
//import resume_match.feature.TargetResumeFeature;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author vector
// * @Data 2018/9/19 0019
// * @Description TODO
// */
//public class UnionDataMatch extends AbstractMatch {
//
//
//	public UnionDataMatch(AnonymousResumeFeature anonymousResumeFeature) {
//		super(anonymousResumeFeature);
//	}
//	@Override
//	List<TargetResumeFeature> getTargetResumeFeature() {
//		TargetResumeFeature targetResumeFeature = new TargetResumeFeature();
//		targetResumeFeature.setRealName("wxc");
//		targetResumeFeature.setCompany("八爪");
//		List<TargetResumeFeature> result = new ArrayList<>();
//		result.register(targetResumeFeature);
//		return result;
//	}
//
//}
