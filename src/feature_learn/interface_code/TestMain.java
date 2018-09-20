package feature_learn.interface_code;

import design_patterns.strategy.*;

import java.util.HashMap;
import java.util.Map;

public class TestMain {
	public static void main(String[] args) {
		Resume resume = new Resume();
		resume.setName("wangxc");
		resume.setMobile("123123123");

		ResumeZero resumeZero = new ResumeZero();
		resumeZero.setName("vector");
		Map<String, Integer> map = new HashMap<>();
		map.put("121231", 2);
		resumeZero.setMobiles(map);

		AbstractCompletion abstractCompletion = new AbsResumeCompletion(resume);
		double v = abstractCompletion.calCompletion();
		System.out.println(v);

		RelativeCompletion relativeCompletion = new RelativeCompletion(resume, resumeZero);
		double v1 = relativeCompletion.calCompletion();
		System.out.println(v1);


	}
}
