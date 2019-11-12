package design_pattern.observer;

public class Follower1 implements Follower {
	String name;

	Follower1(String name) {
		this.name = name;
	}

	@Override
	public void update(int temperature) {
		// TODO Auto-generated method stub
		System.out.println(name + " get notification for :" + temperature);

	}

}
