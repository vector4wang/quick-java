//package resume_match;
//
//import resume_match.model.AbstractFeature;
//import resume_match.model.AnonymousRangeKey;
//import resume_match.model.AnonymousResumeFeatureBody;
//import resume_match.model.ResumeFeatureSimHash;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
///**
// * @author vector
// * @date: 2018/10/23 0023 16:34
// */
//public class LastNameWaitMatchData implements AnonymousWaitMatchDataStrategy {
//
//    private String lastName;
//    private AnonymousRangeKey rangeKey;
//
//
//    public LastNameWaitMatchData(String lastName, AnonymousRangeKey rangeKey) {
//        this.lastName = lastName;
//        this.rangeKey = rangeKey;
//    }
//
//    @Override
//    public List<ResumeFeatureSimHash> getWaitMatchTargetFeatureDateList(AnonymousResumeFeatureBody feature) {
//        List<ResumeFeatureSimHash> resumeFeatureSimHashes = new ArrayList<>();
//        if (Arrays.asList(ResumeZeroUtil.specialLastNames).contains(lastName)) {
//            /**
//             * 姓+学校名称
//             */
//            if (StringUtils.isNotBlank(feature.getSchool())) {
//                resumeFeatureSimHashes = resumeFeatureSimHashMapper
//                        .selectResumeFeatureByLastNameAndSchool(lastName, feature.getSchool(), keyId,
//                                rangeKey.getName());
//            }
//        } else {
//            /**
//             * 姓
//             */
//            resumeFeatureSimHashes = resumeFeatureSimHashMapper
//                    .selectResumeFeatureByLastNameAndSchool(lastName,null, keyId, rangeKey.getName());
//        }
//        if (rangeKey == AnonymousRangeKey.UNIONID) {
//
//        } else if (rangeKey == AnonymousRangeKey.FIRMID) {
//        } else if (rangeKey == AnonymousRangeKey.OPERATIONID) {
//        }else{
//            return Collections.emptyList();
//        }
//
//        return null;
//    }
//}
