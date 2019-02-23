package feature_learn.interface_code;

import design_patterns.strategy.completion.Resume;

public abstract class AbstractCompletion implements ResumeCompletion {

	private Resume resume;

	public AbstractCompletion(Resume resume) {
		this.resume = resume;
	}

	public Resume getResume() {
		return this.resume;
	}

}
