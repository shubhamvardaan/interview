package design_pattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu {
	List<Item> menuItems;

	public Menu() {
		menuItems = new ArrayList<>();
	}

	public void addItem(Item item) {
		menuItems.add(item);
	}

	public Iterator<Item> createIterator() {
		return new MenuIterator();
	}

	class MenuIterator implements Iterator<Item> {

		int currentIndex = 0;

		@Override
		public boolean hasNext() {
			if (currentIndex >= menuItems.size()) {
				return false;
			} else
				return true;
		}

		public Item first() {
			return menuItems.get(0);
		}

		public Item itemCurrentItem() {
			return menuItems.get(currentIndex);
		}

		@Override
		public Item next() {
			return menuItems.get(currentIndex++);
		}

		public void remove() {
			menuItems.remove(--currentIndex);
		}

	}
}
