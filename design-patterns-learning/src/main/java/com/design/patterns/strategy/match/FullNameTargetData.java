package com.design.patterns.strategy.match;


import com.design.patterns.strategy.match.abs.AbstractTargetWaitMatchData;
import com.design.patterns.strategy.match.model.AnonymousFeature;
import com.design.patterns.strategy.match.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class FullNameTargetData extends AbstractTargetWaitMatchData {

	public FullNameTargetData(AnonymousFeature anonymousFeature) {
		super(anonymousFeature);
	}

	@Override
	public List<Resume> getTargetWaitMatchDate(AnonymousFeature anonymousFeature) {
		System.out.println("这里使用全名匹配方式查找目标数据，调用参数为name");
		return new ArrayList<Resume>() {{
			add(new Resume("123"));
			add(new Resume("456"));
			add(new Resume("678"));
			add(new Resume("234"));
			add(new Resume("235"));
		}};
	}
}
