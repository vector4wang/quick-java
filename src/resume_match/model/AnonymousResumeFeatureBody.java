package resume_match.model;

public class AnonymousResumeFeatureBody {
    private AbstractFeature feature;
    private String unionId;
	private String firmId;
	private Boolean isMatchOperation;

    public AbstractFeature getFeature() {
        return feature;
    }

    public void setFeature(AbstractFeature feature) {
        this.feature = feature;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getFirmId() {
        return firmId;
    }

    public void setFirmId(String firmId) {
        this.firmId = firmId;
    }

    public Boolean getMatchOperation() {
        return isMatchOperation;
    }

    public void setMatchOperation(Boolean matchOperation) {
        isMatchOperation = matchOperation;
    }
}