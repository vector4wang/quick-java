package resume_match;

import resume_match.model.AnonymousRangeKey;
import resume_match.model.AnonymousResumeFeatureBody;
import resume_match.model.ResumeFeatureSimHash;

import java.util.List;

/**
 * @author vector
 * @Data 2018/9/19 0019
 * @Description TODO
 */
public class AbstractMatch implements AnonymousMatchInterface {
;
    private AnonymousWaitMatchDataStrategy waitMatchDataStrategy;

    private AnonymousResumeFeatureBody body;

    public AbstractMatch(AnonymousWaitMatchDataStrategy waitMatchDataStrategy, AnonymousResumeFeatureBody body) {
        this.waitMatchDataStrategy = waitMatchDataStrategy;
        this.body = body;
    }

    @Override
	public String match() {

        List<ResumeFeatureSimHash> waitMatchTargetFeatureDateList = waitMatchDataStrategy.getWaitMatchTargetFeatureDateList();
        return null;
	}

    public static void main(String[] args) {
        AnonymousResumeFeatureBody body = new AnonymousResumeFeatureBody();

        AbstractMatch abstractMatch = new AbstractMatch(new NormalWaitMatchData(AnonymousRangeKey.FIRMID, body), body);
        abstractMatch.match();
    }
}
