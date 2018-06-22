package feature_learn.intercode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/6/22 0022
 * Time: 16:16
 * Description: 
 */
public class TestMain {

	public static void compare(String str, AbstractResumeFeature resumeFeature) {
		System.out.println(resumeFeature.getName());
		System.out.println(resumeFeature.getAddress());
		System.out.println(resumeFeature.getSex());

	}

	public static void main(String[] args) {
		GeneralResumeFeature resumeFeature = new GeneralResumeFeature();
		resumeFeature.setName("ge");
		resumeFeature.setAddress("普通简历地址");

		resumeFeature.cal();

		compare("wxc", resumeFeature);


		AnonymousResumeFeature anonymousResumeFeature = new AnonymousResumeFeature();
		anonymousResumeFeature.setName("anony");
		anonymousResumeFeature.setAddress("匿名简历地址");

		compare("vector",anonymousResumeFeature);


		List<String> temp = new ArrayList<>();



	}

}
