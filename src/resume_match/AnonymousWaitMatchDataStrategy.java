package resume_match;

import resume_match.model.AbstractFeature;
import resume_match.model.AnonymousResumeFeatureBody;
import resume_match.model.ResumeFeatureSimHash;

import java.util.List;

/**
 * @author vector
 * @date: 2018/10/23 0023 16:39
 */
public interface AnonymousWaitMatchDataStrategy {
    List<ResumeFeatureSimHash> getWaitMatchTargetFeatureDateList();
}
