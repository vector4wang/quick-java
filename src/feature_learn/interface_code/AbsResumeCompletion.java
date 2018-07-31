package feature_learn.interface_code;

import design_patterns.strategy.Resume;

public class AbsResumeCompletion extends AbstractCompletion {

	public AbsResumeCompletion(Resume resume) {
		super(resume);
	}

	@Override
	public double calCompletion() {
		Resume resume = getResume();
		return 1;
	}
}
