package feature_learn.proxy;

import feature_learn.proxy.again.Subject;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/6/28 0028
 * Time: 16:52
 * Description: 
 */
public class ProxyUtil {

	public static void main(String[] args) {
		writeClassToDisk("D:\\githubspace\\java-learning-quick\\proxy1.class",new Class[]{Subject.class});
	}

	public static void writeClassToDisk(String path,Class<?>[] var1){
		byte[] classFile = ProxyGenerator.generateProxyClass("$proxy0", var1);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
			fos.write(classFile);
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
