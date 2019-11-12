package reflection;

import java.lang.reflect.*;

final class shubham {
	int data;

	int getData() {
		return data;
	}

	void setData(Integer data) {
		this.data = data;
	}
}

public class JavaReflection1 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		shubham s = new shubham();
		Class s1 = s.getClass();
		Method method = s1.getMethod("setData", Integer.class);

		System.out.println(method);
	}

}
