package design_pattern.observer;

public class ObserverTest {

	public static void main(String[] args) {
		CelebrityConcrete c = new CelebrityConcrete();
		Follower1 f = new Follower1("shubham");
		Follower1 f1 = new Follower1("vardaan");
		Follower1 f2 = new Follower1("test");
		c.addFollower(f);
		c.addFollower(f1);
		c.addFollower(f2);
		c.setTemperature(12);
		c.remove(f2); // removing f2
		c.setTemperature(1000);
	}
}
