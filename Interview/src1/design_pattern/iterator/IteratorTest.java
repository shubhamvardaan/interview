package design_pattern.iterator;

import java.util.Iterator;

public class IteratorTest {

	public static void main(String[] args) {
		Item i = new Item("dal", 100);
		Item i1 = new Item("roti", 12);
		Item i2 = new Item("sabji", 110);
		Menu menu = new Menu();
		menu.addItem(i);
		menu.addItem(i1);
		menu.addItem(i2);
		System.out.println("Displaying Menu:");
		Iterator<Item> iterator = menu.createIterator();
		while (iterator.hasNext()) {
			Item item = iterator.next();
			System.out.println(item);
		}
		System.out.println("Removing the last item returned");
		iterator.remove();
		iterator = menu.createIterator();
		while (iterator.hasNext()) {
			Item item = iterator.next();
			System.out.println(item);
		}
	}
}
