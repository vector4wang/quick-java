package com.design.patterns.strategy.match;


import com.design.patterns.strategy.match.model.AnonymousFeature;

/**
 * 基本上把匿名匹配使用策略的方式重构了一下
 */
public class TestMain {
	public static void main(String[] args) {
		AnonymousFeature anonymousFeature = new AnonymousFeature();
		anonymousFeature.setName("wxc");
		anonymousFeature.setCompany("哈哈哈");
		FullNameTargetData fullNameTargetData = new FullNameTargetData(anonymousFeature);
		FullNameMatch fullNameMatch = new FullNameMatch(anonymousFeature, fullNameTargetData);
		String result = fullNameMatch.doMatch();
		System.out.println("result====>" + result);
	}
}
