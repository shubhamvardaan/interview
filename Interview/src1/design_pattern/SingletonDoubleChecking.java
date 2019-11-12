package design_pattern;

public class SingletonDoubleChecking {
	private static SingletonDoubleChecking ref;

	private SingletonDoubleChecking() {
	}

	public static SingletonDoubleChecking getInstance() {
		if (ref == null) {
			synchronized (SingletonDoubleChecking.class) {
				if (ref == null)
					ref = new SingletonDoubleChecking();
			}
		}
		return ref;
	}
}
