package classloader;

import java.util.HashSet;

public class ClassLoaderExample {
	public static void main(String[] args) {
		System.out.println(HashSet.class.getClassLoader());
		System.out.println(Employ.class.getClassLoader());
	}

}
