package design_pattern.iterator;

public class Item {

	String itemName;
	int itemPrice;

	public Item(String itemName, int itemPrice) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	public String toString() {
		return itemName + " : " + itemPrice;
	}
}
