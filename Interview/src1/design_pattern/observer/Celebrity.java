package design_pattern.observer;

public interface Celebrity {
	void addFollower(Follower1 f);

	void remove(Follower1 f);

	void notifyFollower();

	void setTemperature(int temperature);
}
