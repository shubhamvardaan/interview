package design_pattern;

public class SingletonLazy {
	static private SingletonLazy ref;

	private SingletonLazy() {
	}

	static synchronized SingletonLazy getInstance() {
		if (ref == null)
			ref = new SingletonLazy();
		return ref;
	}
}
