package feature_learn.intercode;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/6/22 0022
 * Time: 16:14
 * Description: 
 */
public abstract class AbstractResumeFeature {
	private String name;
	private int sex;
	private String address;

	public double cal(ResumeCompletion<? extends AbstractResumeFeature> resumeCompletion) {
		return resumeCompletion.cal(?);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
