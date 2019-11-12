package design_pattern;

public class SingletonEarly {
	static SingletonEarly ref = new SingletonEarly();

	private SingletonEarly() {
	}

	static public SingletonEarly getInstance() {
		return ref;
	}
}
