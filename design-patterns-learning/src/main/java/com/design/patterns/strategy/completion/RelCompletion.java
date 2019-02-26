package com.design.patterns.strategy.completion;

public class RelCompletion implements CompletionStrategy {

	private ResumeZero resumeZero;

	public RelCompletion(ResumeZero resumeZero) {
		this.resumeZero = resumeZero;
	}

	@Override
	public double calcCompletion(Resume resume) {
		double sum = 1;
		int size = resumeZero.getMobiles().size();
		if (size > 0) {
			sum += size * 0.9;
		}
		return sum;
	}
}
