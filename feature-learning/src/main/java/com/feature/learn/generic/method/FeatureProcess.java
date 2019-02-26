package com.feature.learn.generic.method;

/**
 * @author vector
 * @Data 2018/8/15 0015
 * @Description TODO
 */
public class FeatureProcess {
	public static FeatureResult process(AbstractFeature feature) {
		FeatureResult result = new FeatureResult();
		result.setAddress(feature.getAddress().hashCode());
		result.setAge(feature.getAge());
		result.setGender(feature.getGender());
		result.setName(feature.getName().hashCode());
		return result;
	}

	public static void main(String[] args) {
		StudentFeature sf = new StudentFeature();
		sf.setMajor("haha");
		sf.setAddress("sjdofjs");
		sf.setAge(1);
		sf.setGender(2);
		sf.setName("wxc");
		FeatureResult process = process(sf);
//		StudentFeatureResult sfr = new StudentFeatureResult(process);
//		System.out.println(sfr);

		WorkerFeature wf = new WorkerFeature();

	}
}
