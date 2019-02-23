package design_patterns.strategy.match.model;

public class MatchCondition {
	private String unionId;
	private String firmId;
	private Boolean isMatchOperation;

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
