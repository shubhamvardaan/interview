package design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class CelebrityConcrete implements Celebrity {

	List<Follower1> followerList;
	int temperature;

	CelebrityConcrete() {
		followerList = new ArrayList<>();
		temperature = -1;
	}

	public void addFollower(Follower1 f) {
		followerList.add(f);
	}

	@Override
	public void remove(Follower1 f) {
		followerList.remove(f);
	}

	@Override
	public void notifyFollower() {
		for (Follower1 f : followerList) {
			f.update(temperature);
		}
	}

	@Override
	public void setTemperature(int temperature) {
		this.temperature = temperature;
		notifyFollower();
	}

}
