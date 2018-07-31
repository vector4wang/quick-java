package feature_learn.interface_code;

import design_patterns.strategy.Resume;
import design_patterns.strategy.ResumeZero;

public class RelativeCompletion extends AbstractCompletion {

	private ResumeZero resumeZero;

	public RelativeCompletion(Resume resume, ResumeZero resumeZero) {
		super(resume);
		this.resumeZero = resumeZero;
	}

	@Override
	public double calCompletion() {
		Resume resume = getResume();
		double sum = 1;
		int size = resumeZero.getMobiles().size();
		if (size > 0) {
			sum += size * 0.9;
		}
		return sum;
	}
}
