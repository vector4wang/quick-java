package design_patterns.strategy.completion;

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


		CompletionStrategy strategy = new AbsCompletion();
		Completion completion = new Completion(strategy);
		double com = completion.getCompletion(resume);
		System.out.println(com);


		CompletionStrategy strategy2 = new RelCompletion(resumeZero);
		Completion completion2 = new Completion(strategy2);
		double completion1 = completion2.getCompletion(resume);
		System.out.println(completion1);


	}
}
