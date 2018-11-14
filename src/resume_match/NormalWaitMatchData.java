package resume_match;

import resume_match.model.AbstractFeature;
import resume_match.model.AnonymousRangeKey;
import resume_match.model.AnonymousResumeFeatureBody;
import resume_match.model.ResumeFeatureSimHash;

import java.util.Collections;
import java.util.List;

/**
 * @author vector
 * @date: 2018/10/23 0023 16:34
 */
public class NormalWaitMatchData implements AnonymousWaitMatchDataStrategy {

    private AnonymousRangeKey rangeKey;

    private AnonymousResumeFeatureBody body;

    public NormalWaitMatchData(AnonymousRangeKey rangeKey, AnonymousResumeFeatureBody body) {
        this.rangeKey = rangeKey;
        this.body = body;
    }

    @Override
    public List<ResumeFeatureSimHash> getWaitMatchTargetFeatureDateList() {
        AbstractFeature feature = body.getFeature();
        // 继续细分到拼音
//        if (rangeKey == AnonymousRangeKey.UNIONID) {
//            return resumeFeatureSimHashMapper.selectResumeSimHashFeatureByName(feature.getRealName(), body.getUnionId(), rangeKey.getName());
//        } else if (rangeKey == AnonymousRangeKey.FIRMID) {
//            return resumeFeatureSimHashMapper.selectResumeSimHashFeatureByName(feature.getRealName(), body.getFirmId(), rangeKey.getName());
//        } else if (rangeKey == AnonymousRangeKey.OPERATIONID) {
//            return resumeFeatureSimHashMapper.selectOperationResumeSimHashFeatureByName(feature.getRealName(), "operation list");
//        }else{
//            return Collections.emptyList();
//        }
        return Collections.emptyList();
    }
}
