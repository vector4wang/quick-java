package com.design.patterns.strategy.completion;

public class AbsCompletion implements CompletionStrategy {

    @Override
    public double calcCompletion(Resume resume) {
        return 1;
    }
}
