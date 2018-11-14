package resume_match.model;

public enum AnonymousRangeKey {
	UNIONID(1, "UNIONID"),
	FIRMID(2, "FIRMID"),
	YILIEID(3,"YILIEID"),
	OPERATIONID(4,"OPERATIONID"),
	NAMELISTID(5,"NAMELISTID"),
	;
	private int code;
	private String name;

	AnonymousRangeKey(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
