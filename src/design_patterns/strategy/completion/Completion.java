package design_patterns.strategy.completion;

public class Completion {

	private CompletionStrategy completionStrategy;

	public Completion(CompletionStrategy completionStrategy) {
		this.completionStrategy = completionStrategy;
	}

	public double getCompletion(Resume resume) {
		 return completionStrategy.calcCompletion(resume);
	}
}
