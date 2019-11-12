package design_pattern;

import java.io.Serializable;

public class Singleton implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2667879342749453112L;
	static int value;
	public static final Singleton INSTANCE = new Singleton();

	private Singleton() {
	}

	static void setValue(int x) {
		value = x;
	}

	static int getValue() {
		return value;
	}
}
