package generics;

class Generics1<T> {
	T o;

	Generics1(T o) {
		this.o = o;
	}

	T getValue() {
		return o;
	}
}

public class GenDemo_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Generics1<Integer> t = new Generics1<>((88));
		System.out.println(t.getValue());
		System.out.println(t.getClass().getName());
	}

}
