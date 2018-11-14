//package resume_match;
//
//import resume_match.model.AbstractFeature;
//import resume_match.model.AnonymousRangeKey;
//import resume_match.model.AnonymousResumeFeatureBody;
//import resume_match.model.ResumeFeatureSimHash;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//
///**
// * @author vector
// * @date: 2018/10/23 0023 16:34
// */
//public class NameLessWaitMatchData implements AnonymousWaitMatchDataStrategy {
//
//    private AnonymousRangeKey rangeKey;
//
//    AnonymousResumeFeatureBody body;
//
//    public NameLessWaitMatchData(AnonymousRangeKey rangeKey, AnonymousResumeFeatureBody body) {
//        this.rangeKey = rangeKey;
//        this.body = body;
//    }
//
//    @Override
//    public List<ResumeFeatureSimHash> getWaitMatchTargetFeatureDateList() {
//        List<ResumeFeatureSimHash> targetResumeFeaturesSimHash = new ArrayList<>();
//        AbstractFeature feature = body.getFeature();
//        String school = feature.getSchool();
//        String major = standardService.standardMajor(anonymousResumeFeature2.getMajor(), anonymousResumeFeature2.getDegree());
//        Date eduStartDate = feature.getEduStartDate();
//        String company = feature.getCompany();
//        String title = feature.getTitle();
//        Date currentDate = new Date();
//        long s = System.currentTimeMillis();
//        if (school!=null) {
//            if (major!=null) {
//                targetResumeFeaturesSimHash = resumeFeatureSimHashMapper.selectNameLessResumeFeatureBySchoolAndMajor(school, major,type==AnonymousRangeKey.UNIONID?body.getUnionId():body.getFirmId(),operationUnionList,type);
//            }else{
//                if (eduStartDate.compareTo(currentDate) < 0 && eduStartDate.compareTo(LOWER_LIMIT)>0) {
//                    targetResumeFeaturesSimHash = resumeFeatureSimHashMapper.selectNameLessResumeFeatureBySchoolAndEduStartDate(school, eduStartDate,type==AnonymousRangeKey.UNIONID?body.getUnionId():body.getFirmId(),operationUnionList,type);
//                }
//            }
//        }else{
//            if (StringUtils.isNotBlank(company) && StringUtils.isNotBlank(title)) {
//                targetResumeFeaturesSimHash = resumeFeatureSimHashMapper.selectNameLessResumeFeatureByByCompanyAndTitle(company, title,type==AnonymousRangeKey.UNIONID?body.getUnionId():body.getFirmId(),operationUnionList,type);
//            }
//        }
//        return Collections.emptyList();
//    }
//}
