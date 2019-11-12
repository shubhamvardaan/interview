package miscelleneous;

import java.util.PriorityQueue;

public class PDemo {
	static class person implements Comparable<person> {
		int age;
		String name;

		@Override
		public String toString() {
			return "person [age=" + age + ", name=" + name + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			person other = (person) obj;
			if (age != other.age)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(person p) {
			if (this.age > p.age)
				return 1;
			else if (this.age < p.age)
				return -1;
			else
				return 0;

		}
	}

	public static void main(String[] args) {
		PriorityQueue<person> s = new PriorityQueue<>();
		s.add(new person(9, "tat"));
		s.add(new person(65, "re"));
		s.add(new person(12, "test"));
		s.add(new person(1, "fan"));

		while (!s.isEmpty()) {
			System.out.println(s.remove());
		}

	}
}
