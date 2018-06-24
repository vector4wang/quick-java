package design_patterns.strategy;

public class AbsCompletion implements CompletionStrategy {

	@Override
	public double calcCompletion(Resume resume) {
		return 1;
	}
}
